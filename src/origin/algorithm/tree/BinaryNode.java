package origin.algorithm.tree;

/**
 * @author 原初
 * @create 2022 - 03 - 23
 * 二叉查找树的节点
 */
public class BinaryNode<K extends Comparable, V>{
    private BinaryNode<K, V> left;
    private BinaryNode<K, V> right;
    private K key;
    private V value;

    @Override
    public String toString() {
        return "BinaryNode{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public BinaryNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<K, V> left) {
        this.left = left;
    }

    public BinaryNode<K, V> getRight() {
        return right;
    }

    public void setRight(BinaryNode<K, V> right) {
        this.right = right;
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

    public BinaryNode(BinaryNode<K, V> left, BinaryNode<K, V> right, K key, V value) {
        this.left = left;
        this.right = right;
        this.key = key;
        this.value = value;
    }
}
