package origin.algorithm.dac;

/**
 * 汉诺塔@author 原初
 *
 * @create 2022 - 04 - 20
 * 分治算法解决汉诺塔问题
 */
public class Hanoi {
    /**
     * 这个方法实际上的意思是吧 自顶向下第topToWhat
     * 位置包括自己以及上面所有的盘子从from移动到to上
     * @param topToWhat 从最顶层到num层的盘子的计数
     * @param from      从
     * @param depend    借助
     * @param to        到
     */
    public static void hanoi(int topToWhat, char from, char depend, char to) {
        //如果只有一个
        if (topToWhat == 1) {
            System.out.println(from + "->" + to); //从目标到真正位置
            return;
        }
        //本质上这三根柱子没有任何区别
        // 这个盘子上面的所有盘子移动到除了from 到 to 外的柱子上
        //也就是说此时的1 - topToWhat - 1的盘子最终的目标是depend上
        hanoi(topToWhat - 1, from, to, depend);
        //此时这个盘子已经在最上面了，可以直接移动到to位置
        System.out.println(from + "->" + to);
        //这个盘子上面的所有盘子移动从depend上移动到to上
        hanoi(topToWhat - 1, depend, from, to);
    }
}
