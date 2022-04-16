package origin.algorithm.sort;

/**
 * @author 原初
 * @create 2022 - 03 - 13
 * 递归来阶乘
 */
public class Factorial {
    public static int getResult(int n) {
        if(n == 1)
        {
            return 1;
        }
        return getResult(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(getResult(3));
    }
}
