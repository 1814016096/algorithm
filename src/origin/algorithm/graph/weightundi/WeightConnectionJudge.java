package origin.algorithm.graph.weightundi;

import origin.algorithm.linear.stack.LinkedStack;
import origin.algorithm.linear.stack.Stack;

import java.util.LinkedList;


/**
 * @author 原初
 * @create 2022 - 04 - 10
 * 判断加权无向图两个顶点是不是联通
 */
public class WeightConnectionJudge {
    private boolean[] marked;
    private int[] from;
    private int vertex;
    public WeightConnectionJudge(WeightUndiGraph graph, int fromVertex)
    {
        marked = new boolean[graph.vertexSize()];
        from = new int[graph.vertexSize()];
        vertex = fromVertex;
        dfs(graph, fromVertex);
    }
    private void dfs(WeightUndiGraph graph, int fromVertex)
    {
        marked[fromVertex] = true;
        LinkedList<Side> sides = graph.getSide(fromVertex);
        for (Side side : sides) {
            int diff = side.getDiff(fromVertex);
            if(!marked[diff])
            {
                from[diff] = fromVertex; //标记前一个
                dfs(graph, diff);
            }
        }
    }
    public boolean isConnect(int v)
    {
        return marked[v];
    }
    public boolean isConnect(Side s)
    {
        return isConnect(s.getDiff(vertex));
    }
}
