package origin.algorithm.tree.uf;

/**
 * @author 原初
 * @create 2022 - 04 - 03
 */
public class UFTreeTest {
    public static void main(String[] args) {
        UFTree ufTree = new UFTree(10);
        ufTree.union(1, 3);
        ufTree.union(3, 5);
        ufTree.union(5, 4);
        ufTree.union(4, 1);
        System.out.println(ufTree.isConnected(1, 4));
        System.out.println(ufTree.isConnected(1, 9));
    }
}
