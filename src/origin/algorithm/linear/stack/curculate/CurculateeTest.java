package origin.algorithm.linear.stack.curculate;

/**
 * @author 原初
 * @create 2022 - 03 - 19
 */
public class CurculateeTest {
    public static void main(String[] args) {
        Curculate curculate = new Curculate("(15 + 30)/10 * 11");
        System.out.println(curculate.transform());
        System.out.println(curculate.getResult());
    }
}
