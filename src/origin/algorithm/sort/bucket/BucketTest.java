package origin.algorithm.sort.bucket;

import origin.algorithm.sort.SortDecorator;
import origin.algorithm.sort.merge.MergerSort;

/**
 * @author 原初
 * @create 2022 - 03 - 15
 */
public class BucketTest {
    public static void main(String[] args) {
        SortDecorator<Integer> sortor = new SortDecorator<>(new BucketSort<>(new MergerSort<>()));
        System.out.println(sortor.sort(true, 1,1,1,1, 5, 6, 6, 2, 7, 9,8,9,89,7,9));
    }
}
