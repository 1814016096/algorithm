package origin.algorithm.linear.queue;

import origin.algorithm.linear.array.Scquence;

import java.util.Iterator;

/**
 * @author 原初
 * @create 2022 - 03 - 20
 */
public class ArraryQueue<T> implements Queue<T>{
    private Scquence<T> realQueue;
    private int capacity;
    private int begin = 0;
    private int end = 0;
    public ArraryQueue(int capacity)
    {
        this.capacity = capacity + 1;
        this.realQueue = new Scquence<>(capacity + 1); //建立队列
    }
    @Override
    public boolean enqueue(T content) {
        if(begin == (end + 1) % capacity)
        {
            return false;
        }
        realQueue.insertUnsafe(end ,content);
        end = (end + 1) % capacity;
        return true;
    }

    @Override
    public T dequeue() {
        T value = realQueue.get(begin);
        begin = (begin + 1) % capacity;
        return value;
    }

    @Override
    public int size() {
        return end - begin;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return begin != end;
            }

            @Override
            public T next() {
                return dequeue();
            }
        };
    }
}
