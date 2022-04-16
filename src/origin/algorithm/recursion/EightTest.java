package origin.algorithm.recursion;

import java.util.Arrays;

/**
 * @author 原初
 * @create 2022 - 03 - 22
 * 八皇后问题测试
 */
public class EightTest {
    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.solve(0);
        System.out.println(eightQueens.getCount());
        for (int i = 0; i < eightQueens.getResult().length; i++) {
            System.out.println(Arrays.toString(eightQueens.getResult()[i]));
        }
    }
}
