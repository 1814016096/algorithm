package origin.algorithm.linear.stack;

import origin.algorithm.linear.array.Scquence;

import java.util.Iterator;

/**
 * @author 原初
 * @create 2022 - 03 - 18
 * 栈的顺序表实现方式
 */
public class ArrayStack<T> implements Stack<T>{
    private Scquence<T> realStack;
    private int capacity;
    public ArrayStack(int capacity)
    {
        realStack = new Scquence<>(capacity);
        this.capacity = capacity;
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
        if(realStack.size() <= capacity)
        {
            realStack.insert(content);
            return true;
        }
        return false;
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
