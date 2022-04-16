package origin.algorithm.sort.merge;

import origin.algorithm.sort.SortDecorator;

/**
 * @author 原初
 * @create 2022 - 03 - 13
 */
public class MergeTest {
    public static void main(String[] args) {
        SortDecorator<Integer> sorttor = new SortDecorator<>(new MergerSort<>());
        System.out.println(sorttor.sort(true, 1, 2, 3, 2, 1, 5, 8, 5, 2, 6, 8));
    }
}
