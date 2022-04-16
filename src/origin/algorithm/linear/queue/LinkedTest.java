package origin.algorithm.linear.queue;

/**
 * @author 原初
 * @create 2022 - 03 - 20
 */
public class LinkedTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(10);
        queue.enqueue(2);
        queue.enqueue(1200);
        queue.enqueue(10);
        queue.enqueue(17);
        queue.enqueue(170);
        queue.enqueue(17);
        queue.enqueue(7);
        for(var i : queue)
        {
            System.out.println(i);
        }
        System.out.println(queue.size());
    }
}
