package origin.algorithm.linear.queue;

/**
 * @author 原初
 * @create 2022 - 03 - 20
 */
public interface Queue <T> extends Iterable<T>{
    boolean enqueue(T content);
    T dequeue();
    int size();
    boolean isEmpty();
}
