package origin.algorithm.simple;

/**
 * @author 原初
 * @create 2022 - 04 - 16
 */
public class TestScore {
    public static void main(String[] args) {
        Sorce sorce = new Sorce();
        sorce.input(5);
        System.out.println(sorce.getMax());
        System.out.println(sorce.getMin());
        System.out.println(sorce.getAvg());
    }
}
