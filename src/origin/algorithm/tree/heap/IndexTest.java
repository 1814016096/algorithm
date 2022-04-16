package origin.algorithm.tree.heap;

import java.util.Random;

/**
 * @author 原初
 * @create 2022 - 03 - 28
 */
public class IndexTest {
    public static void main(String[] args) {
        IndexPriorityQueue<Integer> index = new IndexPriorityQueue<Integer>(100);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            index.insert(i, i);
        }
        index.delete(9);
        for (int i = 0; i < 9; i++) {
            System.out.println(index.deleteMin());
        }
    }
}
