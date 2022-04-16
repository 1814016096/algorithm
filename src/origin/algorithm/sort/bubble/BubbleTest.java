package origin.algorithm.sort.bubble;

import origin.algorithm.sort.SortDecorator;

/**
 * @author 原初
 * @create 2022 - 03 - 11
 * 冒泡排序的测试
 */
public class BubbleTest {
    public static void main(String[] args) {
        SortDecorator<Integer> softer = new SortDecorator<>(new BubbleSort<>());
        System.out.println(softer.sort(false, 1, 5, 6, 6, 2, 7, 9));
    }
}
