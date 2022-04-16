package origin.algorithm.graph;

/**
 * @author 原初
 * @create 2022 - 04 - 04
 * 无向图测试
 */
public class UndiTest {
    public static void main(String[] args) {
        UndiGraph g = new UndiGraph(10);
        g.addSide(1, 2);
        g.addSide(2, 5);
        g.addSide(1, 3);
        g.addSide(1, 4);
        System.out.println(g.get(1));
    }
}
