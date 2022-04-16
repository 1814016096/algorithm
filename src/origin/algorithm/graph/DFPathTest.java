package origin.algorithm.graph;

/**
 * @author 原初
 * @create 2022 - 04 - 06
 * 路径查找测试
 */
public class DFPathTest {
    public static void main(String[] args) {
        UndiGraph undiGraph = new UndiGraph(10);
        undiGraph.addSide(1, 3);
        undiGraph.addSide(3, 5);
        undiGraph.addSide(5, 9);
        undiGraph.addSide(8, 7);
        DeepFirrstPath dfs = new DeepFirrstPath(undiGraph, 1);
        System.out.println(dfs.pathVertexs(9));
        System.out.println(dfs.isConnect(8));
        System.out.println(dfs.isConnect(3));
    }
}
