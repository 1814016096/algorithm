package origin.algorithm.linear.stack;

import origin.algorithm.linear.array.Scquence;
import origin.algorithm.linear.linked.SingleLinkedList;

import java.util.Iterator;

/**
 * @author 原初
 * @create 2022 - 03 - 18
 */
public class LinkedStack<T> implements Stack<T> {
    private SingleLinkedList<T> realStack;

    public LinkedStack() {
        realStack = new SingleLinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return realStack.size() == 0;
    }

    @Override
    public int size() {
        return realStack.size();
    }

    @Override
    public T pop() {
        return realStack.remove(realStack.size() - 1);
    }

    @Override
    public boolean push(T content) {
        realStack.insert(content);
        return true;
    }

    @Override
    public T show() {
        return realStack.get(realStack.size() - 1);
    }

    @Override
    public void clear() {
        realStack.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public T next() {
                return pop();
            }
        };
    }
}
