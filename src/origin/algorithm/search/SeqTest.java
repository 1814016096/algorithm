package origin.algorithm.search;

import java.util.Arrays;

/**
 * @author 原初
 * @create 2022 - 04 - 13
 */
public class SeqTest {
    public static void main(String[] args) {
        SequenceSearch<Integer> sequenceSearch = new SequenceSearch<>();
        Integer[] ints = new Integer[]{1, 5, 5, 5, 7, 4, 2};
        System.out.println(sequenceSearch.findAll(5, ints));
    }
}
