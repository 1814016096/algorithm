package origin.algorithm.tree.huffman;

/**
 * @author 原初
 * @create 2022 - 04 - 16
 */
public class HuffmanTreeTest {
    public static void main(String[] args) {
        HuffmanTree tree = new HuffmanTree(1,5,7,9,5,7,15,11);
        tree.coding();
        tree.preTravel( x -> System.out.println(x));
    }
}
