package origin.algorithm.sort.quick;

import origin.algorithm.sort.SortDecorator;

/**
 * @author 原初
 * @create 2022 - 03 - 14
 */
public class QuickTest {
    public static void main(String[] args) {
        SortDecorator<Integer> sortor = new SortDecorator<>(new QuickSort<>());
        System.out.println(sortor.sort(true, 1, 2, 3, 2, 1, 5, 8, 5, 2, 6, 8));
    }
}
