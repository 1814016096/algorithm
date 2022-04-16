package origin.algorithm.linear.sparse;

import java.util.Arrays;

/**
 * @author 原初
 * @create 2022 - 03 - 21
 */
public class SpareTest {
    public static void main(String[] args) {
        Integer[][] integers = new Integer[10][10];
        integers[3][7] = 15;
        integers[2][5] = 55;
        integers[0][0] = 10;
        integers[9][9] = 10;
        SpareArray<Integer> spare = SpareArrayUtils.toSpare(integers, 0);
        Object[][] integers1 = SpareArrayUtils.toNormal(spare);
        for (int i = 0; i < integers.length; i++) {
            for (int j = 0; j < integers[i].length; j++) {
                if(integers1[i][j] == null)
                {
                    System.out.print(0);
                }else{
                    System.out.print(integers1[i][j]);
                }
            }
            System.out.println();
        }
    }
}
