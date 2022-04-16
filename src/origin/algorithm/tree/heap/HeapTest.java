package origin.algorithm.tree.heap;

/**
 * @author 原初
 * @create 2022 - 03 - 26
 */
public class HeapTest {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(10);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(7);
        heap.insert(4);
        heap.insert(5);
        while (heap.size() > 0)
        {
            System.out.println(heap.delMax());
        }
    }
}
