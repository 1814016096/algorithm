package origin.algorithm.linear.array;

import origin.algorithm.linear.ILinear;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author 原初
 * @create 2022 - 03 - 15
 * 顺序表
 */
public final class Scquence<T> implements ILinear<T> {
    T[] values;//数组
    int count;// 长度
    private int capacity;

    public T[] getValues() {
        return values;
    }

    public Scquence(int capacity)
    {
        values = (T[]) new Object[capacity];
        count = 0;
        this.capacity = capacity;
    }
    public Scquence(T ... values)
    {
        this.values = (T[]) new Object[values.length];
        add(values);
    }
    public void add(T ... values)
    {
        for (int i = 0; i < values.length; i++) {
            insert(values[i]);
        }
    }
    public void insertUnsafe(int index, T value) // 不进行任何覆盖操作，只是插入
    {
        if(index >= count && value != null && values[index] == null)
        {
            count++;
        }else if(index < count && value == null && values[index] != null){
            count--;
        }
        values[index] = value;
    }
    public void insert(T value)
    {
        if(count < values.length)
        {
            values[count] = value; //插入尾部
            if(value != null)
            {
                count++;
            }
        }
        else
        {
            T[] temp = (T[]) new Object[(int) (values.length * 2 + 1)];
            for (int i = 0; i < values.length; i++) {
                temp[i] = values[i];
            }
            values = temp;
            temp[count] = value;
            if(value != null)
            {
                count++;
            }
        }
    }
    public void insert(int index, T value)
    {
        if(index > count)
        {
            throw new RuntimeException("越界了");
        }
        if(count < values.length)
        {
            for (int i = count - 1; i >= index; i--) {
                values[i + 1] = values[i];
            }
            values[index] = value;
            if(value != null)
            {
                count++;
            }
        }
        else
        {
            T[] temp = (T[]) new Object[(int) (values.length * 1.5)];
            for (int i = 0; i < values.length; i++) {
                temp[i] = values[i];
            }
            values = temp;
            for (int i = count - 1; i >= index; i--) {
                values[i + 1] = values[i];
            }
            values[index] = value;
            count++;
        }
    }
    public T get(int index)
    {
        return values[index];
    }
    public int get(T obj)
    {
        for (int i = 0; i < count; i++) {
            if(values[i].equals(obj))
            {
                return i;
            }
        }
        return -1;
    }
    public int size()
    {
        return count;
//        int c = 0;
//        for (int i = 0; i < values.length; i++) {
//            if(values[i] != null)
//            {
//                c++;
//            }
//        }
//        return c;
    }
    public void clear()
    {
        count = 0;
    }
    public boolean isEmpty()
    {
        return count == 0;
    }

    @Override
    public String toString() {
        String strCon = "";
        for (int i = 0; i < count; i++) {
            strCon += (i + ":" + values[i] + "\n");
        }
        return strCon;
    }
    public T remove(int index)
    {
        T rom = get(index);
        if(index >= 0 && index < count)
        {
            for (int i = index; i < count - 1; i++) {
                values[i] = values[i + 1];
            }
            count--;
            if(count < values.length / 2)
            {
                T[] temp = (T[]) new Object[values.length / 2];
                for (int i = 0; i < count; i++) {
                    temp[i] = values[i];
                }
                values = temp;
            }
        }
        return rom;
    }
    private class ScqIterator implements Iterator<T>{
        int curosr = 0;
        @Override
        public boolean hasNext() {
            return curosr < count;
        }

        @Override
        public T next() {
            return values[curosr++];
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new ScqIterator();
    }
}
