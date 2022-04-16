package origin.algorithm.graph.weight;

/**
 * @author 原初
 * @create 2022 - 04 - 12
 */
public class DijkTest {
    public static void main(String[] args) {
        DirectGraph directGraph = new DirectGraph(4);
        directGraph.addSide(new DirectSide(0, 1, 0.1));
        directGraph.addSide(new DirectSide(0, 2, 0.2));
        directGraph.addSide(new DirectSide(0, 3, 0.3));
        directGraph.addSide(new DirectSide(1, 2, 0.1));
//        directGraph.addSide(new DirectSide(1, 3, 0.1));
        directGraph.addSide(new DirectSide(2, 3, 0.05));
        Dijkstra dijkstra = new Dijkstra(directGraph, 0);
        System.out.println(dijkstra.path(3));
    }
}
