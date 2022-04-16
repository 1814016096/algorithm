package origin.algorithm.graph.mst;

import origin.algorithm.graph.weightundi.Side;
import origin.algorithm.graph.weightundi.WeightUndiGraph;

/**
 * @author 原初
 * @create 2022 - 04 - 10
 */
public class KruskalTest {
    public static void main(String[] args) {
        WeightUndiGraph w = new WeightUndiGraph(4);
        w.addEdge(new Side(0, 1, 0.2));
        w.addEdge(new Side(0, 2, 0.1));
        w.addEdge(new Side(0, 3, 0.3));
        w.addEdge(new Side(1, 2, 0.4));
        w.addEdge(new Side(1, 3, 0.5));
        w.addEdge(new Side(2, 3, 0.7));
        Kruskal k = new Kruskal(w);
        System.out.println(k.getPath());
    }
}
