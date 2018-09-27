# NIO

ref:[Java NIO 系列教程](http://www.iteye.com/magazines/132-Java-NIO)

## NIO vs. IO
|IO|NIO|
|----|----|
|Stream oriented|Buffer oriented|
|Blocking IO|Non blocking IO|
| |Selectors|

Java NIO提供了与标准IO不同的IO工作方式： 

* **Channels and Buffers（通道和缓冲区）：** 标准的IO基于字节流和字符流进行操作的，而NIO是基于通道（Channel）和缓冲区（Buffer）进行操作，数据总是从通道读取到缓冲区中，或者从缓冲区写入到通道中。
* **Asynchronous IO（异步IO）：** Java NIO可以让你异步的使用IO，例如：当线程从通道读取数据到缓冲区时，线程还是可以进行其他事情。当数据被写入到缓冲区时，线程可以继续处理它。从缓冲区写入通道也类似。
* **Selectors（选择器）：** Java NIO引入了选择器的概念，选择器用于监听多个通道的事件（比如：连接打开，数据到达）。因此，单个的线程可以监听多个数据通道。

## Channel

Java NIO的通道类似流，但又有些不同： 

* 既可以从通道中读取数据，又可以写数据到通道。但流的读写通常是单向的。
* 通道可以异步地读写。
* 通道中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入。

这些是Java NIO中最重要的通道的实现： 

* FileChannel：从文件中读写数据。
* DatagramChannel：能通过UDP读写网络中的数据。
* SocketChannel：能通过TCP读写网络中的数据。
* ServerSocketChannel：可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel。

[FileChannel 示例](FileChannelTest.java)

## Buffer 

Java NIO中的Buffer用于和NIO通道进行交互。数据是从通道读入缓冲区，从缓冲区写入到通道中的。 

缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。这块内存被包装成NIO Buffer对象，并提供了一组方法，用来方便的访问该块内存。 

**Buffer的基本用法** 

使用Buffer读写数据一般遵循以下四个步骤： 

* 写入数据到Buffer
* 调用flip()方法
* 从Buffer中读取数据
* 调用clear()方法或者compact()方法

当向buffer写入数据时，buffer会记录下写了多少数据。一旦要读取数据，需要通过flip()方法将Buffer从写模式切换到读模式。在读模式下，可以读取之前写入到buffer的所有数据。 

一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。有两种方式能清空缓冲区：调用clear()或compact()方法。clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。 

## Scatter and Gather

* 分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个 buffer 中。因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。 

* 聚集（gather）写入Channel是指在写操作时将多个 buffer 的数据写入同一个 Channel，因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。 

* scatter / gather经常用于需要将传输的数据分开处理的场合，例如传输一个由消息头和消息体组成的消息，你可能会将消息体和消息头分散到不同的buffer中，这样你可以方便的处理消息头和消息体。 

[ScatterAndGather](ScatterAndGather.java)

## Transfer Between Channels

* `FileChannel` 的 `transferFrom(ReadableByteChannel, long, long)`方法可以将数据从源通道传输到 FileChannel 中

* `transferTo(long, long, WritableByteChannel)` 将数据从 FileChannel 传输到 WritableByteChannel 中。

* 在 `SoketChannel` 的实现中，SocketChannel 只会传输此刻准备好的数据（可能不足 `count` 字节）。因此，SocketChannel 可能不会将请求的所有数据( count 个字节)全部传输到 FileChannel 中。

[TransferBetweenChannels](TransferBetweenChannels.java)

## Selector

Selector（选择器）是 Java NIO 中能够检测一到多个 NIO 通道，并能够知晓通道是否为诸如读写事件做好准备的组件。这样，一个单独的线程可以管理多个channel，从而管理多个网络连接。

ref:[NIO Selector 详解](https://segmentfault.com/a/1190000006824196?utm_source=tuicool&utm_medium=referral)

**Selector 的基本使用流程**

1. 通过 Selector.open() 打开一个 Selector.
2. 将 Channel 注册到 Selector 中, 并设置需要监听的事件(interest set)
3. 不断重复:
 * 调用 select() 方法
 * 调用 selector.selectedKeys() 获取 selected keys
 * 迭代每个 selected key:
   * 从 selected key 中获取 对应的 Channel 和附加信息(如果有的话)
   * 判断是哪些 IO 事件已经就绪了, 然后处理它们. 如果是 OP_ACCEPT 事件, 则调用 "SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept()" 获取 SocketChannel, 并将它设置为 非阻塞的, 然后将这个 Channel 注册到 Selector 中.
   * 根据需要更改 selected key 的监听事件.
   * 将已经处理过的 key 从 selected keys 集合中删除.

一个栗子：

```java
Selector selector = Selector.open();
// 如果一个 Channel 要注册到 Selector 中, 那么这个 Channel 必须是非阻塞的
channel.configureBlocking(false);
SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
while(true) {
  int readyChannels = selector.select();
  if(readyChannels == 0) continue;
  Set selectedKeys = selector.selectedKeys();
  Iterator keyIterator = selectedKeys.iterator();
  while(keyIterator.hasNext()) {
    SelectionKey key = keyIterator.next();
    if(key.isAcceptable()) {
        // a connection was accepted by a ServerSocketChannel.
    } else if (key.isConnectable()) {
        // a connection was established with a remote server.
    } else if (key.isReadable()) {
        // a channel is ready for reading
    } else if (key.isWritable()) {
        // a channel is ready for writing
    }
    keyIterator.remove();
  }
```

**注意：**
* 如果一个 Channel 要注册到 Selector 中, 那么这个 Channel 必须是非阻塞的，即 `channel.configureBlocking(false);` 因为 Channel 必须要是非阻塞的, 因此 FileChannel 是不能够使用选择器的, 因为 FileChannel 都是阻塞的.
* 我们都调用 "keyIterator.remove()" 将这个 key 从迭代器中删除, 因为 select() 方法仅仅是简单地将就绪的 IO 操作放到 selectedKeys 集合中, 因此如果我们从 selectedKeys 获取到一个 key, 但是没有将它删除, 那么下一次 select 时, 这个 key 所对应的 IO 事件还在 selectedKeys 中.
 
## SocketChannel
 
SocketChannel是一个连接到TCP网络套接字的通道。可以通过以下2种方式创建SocketChannel： 
 
* 打开一个 SocketChannel 并连接到互联网上的某台服务器。
* 一个新连接到达 ServerSocketChannel 时，会创建一个 SocketChannel。
 
**用法：**

1. 打开SocketChannel `SocketChannel socketChannel = SocketChannel.open();` 
2. 连接端口 `socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));` 
3. 读取/写入数据 `int bytesRead = socketChannel.read(buf);` 
4. 关闭 `socketChannel.close();`

**非阻塞模式** 

* 可以设置 SocketChannel 为非阻塞模式（non-blocking mode）.设置之后，就可以在异步模式下调用connect(), read() 和write()了。 
`socketChannel.configureBlocking(false);`

* 非阻塞模式下，`write()` 方法在尚未写出任何内容时可能就返回了。所以需要在循环中调用write()。 
* 非阻塞模式下, `read()` 方法在尚未读取到任何数据时可能就返回了。所以需要关注它的int返回值，它会告诉你读取了多少字节。
 
 ## ServerSocketChannel
 
 ServerSocketChannel 是一个可以监听新进来的TCP连接的通道，就像标准IO中的ServerSocket一样。ServerSocketChannel类在 java.nio.channels包中。