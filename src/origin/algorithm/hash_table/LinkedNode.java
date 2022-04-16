package origin.algorithm.hash_table;

/**
 * @author 原初
 * @create 2022 - 04 - 15
 */
public class LinkedNode<K, V> implements Node<K, V>{
    private K key;
    private V value;
    private LinkedNode<K, V> next;

    @Override
    public String toString() {
        return "LinkedNode{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public void setValue(V value) {
        this.value = value;
    }

    public LinkedNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public LinkedNode() {
    }

    @Override
    public K getKey() {
        return key;
    }
    @Override
    public V getValue() {
        return value;
    }

    @Override
    public Node<K, V> find(K key) {
        LinkedNode<K ,V> pointer = this;
        while(pointer != null)
        {
            if(key.equals(pointer.key))
            {
                break;
            }
            pointer = pointer.next;
        }
        return pointer;
    }

    @Override
    public Node<K, V> findAndAdd(K key) {
        LinkedNode<K ,V> pointer = this;
        while(pointer.next != null)
        {
            if(key.equals(pointer.key))
            {
                return pointer;
            }
            pointer = pointer.next;
        }
        if(key.equals(pointer.key))
        {
            return pointer;
        }
        pointer.next = new LinkedNode<>();
        pointer.next.key = key;
        return pointer.next;
    }
//    注，无法删除自身
    @Override
    public Node<K, V> delete(K key) {
        LinkedNode<K ,V> pointer = this.next;
        LinkedNode<K ,V> pre = this;
        while (pointer != null)
        {
            if(key.equals(pointer.key))
            {
                pre.next = pointer.next;
                pointer.next = null;
                return pointer;
            }
            pre = pointer;
            pointer = pointer.next;
        }
        return null;
    }
}
