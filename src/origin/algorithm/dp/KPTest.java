package origin.algorithm.dp;

/**
 * @author 原初
 * @create 2022 - 04 - 21
 */
public class KPTest {
    public static void main(String[] args) {
        KnapsackProblem kp = new KnapsackProblem(500);
        kp.insertGoods("1", 1, 100);
        kp.insertGoods("2", 2, 50);
        kp.insertGoods("3", 3, 400);
        kp.insertGoods("4", 5, 200);
        kp.insertGoods("5", 5, 500);
        kp.insertGoods("6", 5, 700);
        kp.insertGoods("7", 8, 1000);
        System.out.println(kp.optimization());
    }
}
