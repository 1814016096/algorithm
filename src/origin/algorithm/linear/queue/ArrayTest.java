package origin.algorithm.linear.queue;

/**
 * @author 原初
 * @create 2022 - 03 - 20
 */
public class ArrayTest {
    public static void main(String[] args) {
        ArraryQueue<Integer> queue = new ArraryQueue<>(10);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
//        queue.enqueue(7);
//        for(var i : queue)
//        {
//            System.out.println(i);
//        } ok
        for (int i = 0; i < 2; i++) {
            System.out.println(queue.dequeue());
        }
        System.out.println();
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(4);
        queue.enqueue(4);
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
