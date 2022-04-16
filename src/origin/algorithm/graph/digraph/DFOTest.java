package origin.algorithm.graph.digraph;

/**
 * @author 原初
 * @create 2022 - 04 - 07
 */
public class DFOTest {
    public static void main(String[] args) {
        DiGraph undiGraph = new DiGraph(10);
        undiGraph.addSide(1, 3);
        undiGraph.addSide(3, 5);
        undiGraph.addSide(5, 9);
        undiGraph.addSide(9, 8);
//        undiGraph.addSide(8, 3);
        System.out.println(new DeepFirstOrder(undiGraph).getOrder());
    }
}
