package origin.algorithm.linear.queue.symboltable;

import origin.algorithm.linear.array.Scquence;

import java.math.BigInteger;

/**
 * @author 原初
 * @create 2022 - 03 - 20
 * 基于顺序的，二分查找的符号表
 */
public class SymbolTable<K extends Comparable, V>{
    public class Entry<K, V>{
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    private Scquence<Entry<K, V>> realTable; // 符号表
    private int capacity;
    private int find(K key) // 二分查找
    {
        return find(key, 0, realTable.size());
    }
    private int find(K key, int begin, int end) //经典二分查找算法
    {
        if(begin >= end)
        {
            return begin;
        }
        int middle = (begin + end) / 2;
        if(realTable.get(middle).key.compareTo(key) > 0)
        {
            return find(key, begin, middle - 1);
        }else if(realTable.get(middle).key.compareTo(key) == 0)
        {
            return middle;
        }
        return find(key, middle + 1, end);
    }

    public SymbolTable(int capacity) {
        realTable = new Scquence<>(capacity);
        this.capacity = capacity;
    }
    public boolean put(K key, V value)
    {
        if(size() >= capacity)
        {
            return false;
        }
        int pos = find(key);
        if(realTable.get(pos) != null && realTable.get(pos).key.compareTo(key) == 0)
        {
            realTable.get(pos).value = value;
            return true;
        }
        realTable.insert(pos, new Entry<>(key, value));
        return true;
    }
    public V get(K key)
    {
        int pos = find(key);
        if(realTable.get(pos) != null && realTable.get(pos).key.compareTo(key) == 0)
        {
            return realTable.get(pos).getValue();
        }
        return null; //没找到
    }
    public int size()
    {
        return realTable.size();
    }
    public boolean isEmpty()
    {
        return size() == 0;
    }
}
