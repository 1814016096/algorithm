package origin.algorithm.tree.bTree;

import origin.algorithm.linear.array.Scquence;

import java.util.ArrayList;

/**
 * @author 原初
 * @create 2022 - 04 - 01
 * B树的结点
 */
public class BNode<K extends Comparable<K>, V> {
    public static class Node<Key, Value> {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }

        public Key getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }
    }

    private Scquence<Node<K, V>> nodes;  //存数值的
    private Scquence<BNode<K, V>> pointers; //存指针的
    private int capacity;

    public BNode(int capacity) {
        nodes = new Scquence<>(capacity);
        pointers = new Scquence<>(capacity + 1);
        this.capacity = capacity;
    }
    public int size()
    {
        return nodes.size();
    }
    public int getCapacity() {
        return capacity;
    }

    public BNode<K, V> getLPointer(int index) {
        return pointers.get(index);
    }

    public BNode<K, V> getRPointer(int index) {
        return pointers.get(index + 1);
    }
    public BNode<K, V> deleteLPointer(int index)
    {
        BNode<K, V> temp = pointers.get(index);
        pointers.insertUnsafe(index, null);
        return temp;
    }
    public BNode<K, V> deleteRPointer(int index)
    {
        BNode<K, V> temp = pointers.get(index + 1);
        pointers.insertUnsafe(index + 1, null);
        return temp;
    }
    public void updateNode(int index, Node<K, V> item)
    {
        nodes.insertUnsafe(index, item);
    }
    public Node<K, V> getNode(int index) {
        return nodes.get(index);
    }
    public void updateLPoint(int index, BNode<K, V> pointer)
    {
        pointers.insertUnsafe(index, pointer);
    }
    public void updateRPoint(int index, BNode<K, V> pointer)
    {
        pointers.insertUnsafe(index + 1, pointer);
    }
    public boolean add(Node<K, V> node)
    {
        nodes.add(node);
        return true;
    }
    public boolean insert(int index, int itemIndex, BNode<K, V> item) //item的第itemIndex项插入
    {
        if (nodes.size() <= capacity) {
            nodes.insertUnsafe(index, item.getNode(itemIndex));
            pointers.insertUnsafe(index, item.getRPointer(itemIndex));
            pointers.insert(index, item.getLPointer(itemIndex));
            return true;
        }
        return false;
    }

    public int find(K key) //二分查找位置
    {
        return find(0, nodes.size(), key);
    }

    private int find(int begin, int end, K key) {
        if (begin >= end) {
            return begin;
        }
        int mid = begin + (end - begin) / 2;
        if(nodes.get(mid) == null)
        {
            return mid;
        }
        if (key.compareTo(nodes.get(mid).getKey()) > 0) {
            return find(mid + 1, end, key);
        } else if (key.compareTo(nodes.get(mid).getKey()) < 0) {
            return find(begin, mid - 1, key);
        } else {
            return mid;
        }
    }
}
