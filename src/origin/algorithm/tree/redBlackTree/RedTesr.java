package origin.algorithm.tree.redBlackTree;

/**
 * @author 原初
 * @create 2022 - 03 - 31
 * 红黑树测试
 */
public class RedTesr {
    public static void main(String[] args) {
        RedBlockTree<Integer> tree = new RedBlockTree<>();
        tree.insert(1);
        tree.insert(10);
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);
        tree.insert(724);
        tree.insert(4120);
        tree.insert(420);
        tree.insert(41);
        tree.insert(412);
        tree.insert(410010);
        tree.insert(7);
        tree.insert(2);
        System.out.println(tree.size());
        System.out.println(tree.find(4100));
    }
}
