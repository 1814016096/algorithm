package origin.algorithm.sort.insert;

import origin.algorithm.sort.SortDecorator;

/**
 * @author 原初
 * @create 2022 - 03 - 12
 */
public class InsertTest {
    public static void main(String[] args) {
        SortDecorator<Integer> sortor = new SortDecorator<Integer>(new InsertSort<>());
        System.out.println(sortor.sort(true, 1, 2, 3, 2, 1, 5, 8, 5, 2, 6, 8));
    }
}
