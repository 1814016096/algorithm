package origin.algorithm.tree.heap;

/**
 * @author 原初
 * @create 2022 - 03 - 28
 * 最小优先对列的创建
 */
public class MinPriTest {
    public static void main(String[] args) {
        MinPriorityQueue<Integer> min = new MinPriorityQueue<Integer>(10);
        min.insert(9);
        min.insert(8);
        min.insert(7);
        min.insert(6);
        min.insert(5);
        min.insert(4);
        min.insert(3);
        min.insert(2);
        while (!min.isEmpty())
        {
            System.out.println(min.delMin());
        }
    }
}
