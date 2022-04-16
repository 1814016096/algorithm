package origin.algorithm.linear.queue;

import origin.algorithm.linear.linked.SingleLinkedList;

import java.io.Reader;
import java.util.Iterator;

/**
 * @author 原初
 * @create 2022 - 03 - 20
 */
public class LinkedQueue<T> implements Queue<T>{
    private SingleLinkedList.Node<T> first; //首节点
    private SingleLinkedList.Node<T> last; // 尾结点
    private int length;
    @Override
    public boolean enqueue(T content) {
        if(first == null)
        {
            last = first = new SingleLinkedList.Node<>(null, null, null); // 头结点
        }
        SingleLinkedList.Node<T> pointer = last;
        last = new SingleLinkedList.Node<>(content, null, null) ;//单链表
        pointer.setNext(last);
        length++;
        return true;
    }

    @Override
    public T dequeue() {
        T content = first.getNext().getContent();
        first = first.getNext();
        first.setContent(null);
        length--;
        return content;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return first != last;
            }

            @Override
            public T next() {
                return dequeue();
            }
        };
    }
}
