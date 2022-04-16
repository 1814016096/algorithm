package origin.algorithm.sort.monkey;

import origin.algorithm.sort.SortDecorator;
import origin.algorithm.sort.merge.MergerSort;

/**
 * @author 原初
 * @create 2022 - 03 - 15
 */
public class MonkeyTest {
    public static void main(String[] args) {
        SortDecorator<Integer> sortor = new SortDecorator<>(new MonkeySort<>());
        System.out.println(sortor.sort(true, 1, 2, 5, 4,7,55,3,5));
    }
}
