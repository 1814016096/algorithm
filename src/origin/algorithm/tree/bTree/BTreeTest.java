package origin.algorithm.tree.bTree;

/**
 * @author 原初
 * @create 2022 - 04 - 02
 */
public class BTreeTest {
    public static void main(String[] args) {
        BTree<Integer, Integer> test = new BTree<>(10);
        for (int i = 10000; i > 0; i--) {
            test.insert(i, 100 - i);
        }
        System.out.println(test.find(300));
    }
}
