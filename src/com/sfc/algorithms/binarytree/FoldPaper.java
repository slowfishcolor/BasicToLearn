package com.sfc.algorithms.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展开。此时有1条折痕，突起的
 * ⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每
 * 次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 *
 * 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 *
 * Created by Prophet on 2017/8/18.
 */
public class FoldPaper {


    /**
     *           u
     *        /    \
     *       u      d
     *      / \    / \
     *     u   d  u   d
     *
     * 每一个折痕的左边都是下折痕，右边为上折痕，所以折过后为高度为N的满二叉树。
     * 最后输出先右，在中，最后左的遍历。
     * @param n
     * @return
     */
    public String[] foldPaper(int n) {
        List<String> list = new ArrayList<String>();
        fold(1, n, true, list);
        String[] str = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            str[i] = list.get(i);
        }

        return str;
    }

    /**
     *
     * @param i 第几次折
     * @param n 折的总次数
     * @param down 是否朝下
     * @param list 放结果
     */
    public void fold(int i, int n, boolean down, List<String> list){
        if(i > n)
            return;
        fold(i+1, n, true, list);
        list.add(down == true?"down":"up");
        fold(i+1, n, false, list);
    }
}
