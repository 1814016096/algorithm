package origin.algorithm.graph;

/**
 * @author 原初
 * @create 2022 - 04 - 05
 */
public class BFSTest {
    public static void main(String[] args) {
        UndiGraph undiGraph = new UndiGraph(10);
        undiGraph.addSide(1, 3);
        undiGraph.addSide(3, 5);
        undiGraph.addSide(5, 9);
        undiGraph.addSide(8, 7);
        BFS dfs = new BFS(undiGraph, 1);
        System.out.println(dfs.connVertexs());
        System.out.println(dfs.isConnect(8));
        System.out.println(dfs.isConnect(3));
    }
}
