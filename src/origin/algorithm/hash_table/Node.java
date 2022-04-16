package origin.algorithm.hash_table;

/**
 * @author 原初
 * @create 2022 - 04 - 15
 * 节点接口
 */
public interface Node<K, V>{
    /**
     * 根据key找到节点，若不存在，则返回null
     * @param key
     * @return
     */
    Node<K, V> find(K key);

    /**
     * 根据key找到节点，若不存在，则创建一个并返回
     * @param key
     * @return
     */
    Node<K, V> findAndAdd(K key);

    /**
     * 找到并删除并返回节点,若没找到返回null
     * @param key
     * @return
     */
    Node<K, V> delete(K key);
    K getKey();
    V getValue();
    void setValue(V value);
}
