package origin.algorithm.graph.digraph;

import origin.algorithm.graph.UndiGraph;

/**
 * @author 原初
 * @create 2022 - 04 - 07
 */
public class HasCycleTest {
    public static void main(String[] args) {
        DiGraph undiGraph = new DiGraph(10);
        undiGraph.addSide(1, 3);
        undiGraph.addSide(3, 5);
        undiGraph.addSide(5, 9);
        undiGraph.addSide(9, 8);
        undiGraph.addSide(8, 3);
        System.out.println(new HasCycle(undiGraph).hasCycle());
    }
}
