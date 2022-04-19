package origin.algorithm.tree.avl;

/**
 * @author 原初
 * @create 2022 - 04 - 19
 */
public class AVLTest {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.midTransal(x -> System.out.println(x));
        System.out.println(tree.factor());
    }
}
