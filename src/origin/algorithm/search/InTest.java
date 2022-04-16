package origin.algorithm.search;

/**
 * @author 原初
 * @create 2022 - 04 - 14
 */
public class InTest {
    public static void main(String[] args) {
        InterpolationFind<Integer> find = new InterpolationFind<>();
        Integer[] ints = new Integer[]{1, 2, 4, 5, 7};
        System.out.println(find.find(1, ints));
    }
}
