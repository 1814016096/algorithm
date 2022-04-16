package origin.algorithm.sort.heap;

import origin.algorithm.sort.SortDecorator;

/**
 * @author 原初
 * @create 2022 - 03 - 27
 */
public class HeapTest {
    public static void main(String[] args) {
        SortDecorator<Integer> sort = new SortDecorator<>(new HeapSort<>());
        System.out.println(sort.sort(true, 1, 25, 8, 15, 105, 41, 1, 2015, 6, 7, 4));
    }
}
