package origin.algorithm.search;

/**
 * @author 原初
 * @create 2022 - 04 - 13
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        BaseSearch<Integer> search = new BinarySearch<>();
        Integer[] ints = new Integer[]{1, 2, 4, 5, 7};
        System.out.println(search.find(4, ints));
    }
}
