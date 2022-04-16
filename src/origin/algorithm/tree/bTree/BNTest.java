package origin.algorithm.tree.bTree;

/**
 * @author 原初
 * @create 2022 - 04 - 01
 */
public class BNTest {
    public static void main(String[] args) {
        BNode<Integer, String> b1 = new BNode<>(10);
        for (int i = 0; i < 10; i++) {
            BNode<Integer, String> temp = new BNode<>(10);
            for (int j = 0; j < 10; j++) {
                temp.add(new BNode.Node<>(j, "1"));
                temp.updateLPoint(j, new BNode<>(10));
                temp.updateRPoint(j, new BNode<>(10));
            }
            b1.add(new BNode.Node<>(i, "0"));
            b1.updateLPoint(i, temp);

        }
        BNode<Integer, String> temp = new BNode<>(10);
        for (int j = 0; j < 10; j++) {
            temp.add(new BNode.Node<>(j, "1"));
            temp.updateLPoint(j, new BNode<>(10));
            temp.updateRPoint(j, new BNode<>(10));
        }
        b1.updateRPoint(9, temp); // 暂时ok
        System.out.println(b1.find(9));
    }
}
