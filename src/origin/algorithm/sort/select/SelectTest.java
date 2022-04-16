package origin.algorithm.sort.select;

import origin.algorithm.sort.SortDecorator;

/**
 * @author 原初
 * @create 2022 - 03 - 11
 */
public class SelectTest {
    public static void main(String[] args) {
        SortDecorator<Integer> softer = new SortDecorator<>(new SelecttSort<>());
        System.out.println(softer.sort(true, 1, 2, 3, 2, 1, 5, 8, 5, 2, 6, 8));
    }
}
