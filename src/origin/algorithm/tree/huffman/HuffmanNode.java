package origin.algorithm.tree.huffman;

/**
 * @author 原初
 * @create 2022 - 04 - 16
 */
public class HuffmanNode<T> implements Comparable<HuffmanNode>{
    private Integer value;
    private HuffmanNode left;
    private HuffmanNode right; //左右孩子
    private T data;

    public HuffmanNode(Integer value, HuffmanNode left, HuffmanNode right, T data) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public HuffmanNode(Integer value, HuffmanNode left, HuffmanNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public HuffmanNode() {
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                '}';
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.value.compareTo(o.getValue());
    }
}
