package origin.algorithm.hash_table;

/**
 * @author 原初
 * @create 2022 - 04 - 15
 */
public class HashTable<K, V>{
    private Node<K, V>[] lists; //散列表
    private int capacity;
    private int pos(K key)
    {
        return key.hashCode() % capacity;
    }
    /**
     * 初始化
     * @param capacity
     */
    public HashTable(int capacity)
    {
        this.capacity = capacity;
        lists = new LinkedNode[capacity];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedNode<>();
        }
    }

    /**
     * 插入
     * @param key
     * @param value
     */
    public void insert(K key, V value)
    {
        int pos = pos(key); //取模确定位置
        Node<K, V> node = lists[pos].findAndAdd(key);
        node.setValue(value);
    }

    public Node<K, V> delete(K key)
    {
        int pos = pos(key);
        Node<K, V> node = lists[pos].delete(key);
        return node;
    }

    /**
     * 可能出现null
     * @param key
     * @return
     */
    public Node<K, V> find(K key)
    {
        int pos = pos(key);
        Node<K, V> node = lists[pos].find(key);
        return node;
    }
}
