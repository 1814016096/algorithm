package origin.algorithm.graph.digraph;

import origin.algorithm.graph.DeepFirrstPath;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 原初
 * @create 2022 - 04 - 07
 * 拓扑排序
 */
public class DeepFirstOrder {
    private DiGraph graph;
    private boolean[] marked;
    public DeepFirstOrder(DiGraph graph)
    {
        this.graph = graph;
        marked = new boolean[graph.vertexNum()];
    }
    private void dfs(DiGraph graph, int vertex, Stack<Integer> stack)
    {
        marked[vertex] = true;
        LinkedList<Integer> list = graph.getAbout(vertex);
        for (Integer v : list) {
            if(!marked[v])
            {
                dfs(graph, v, stack);
            }
        }
        stack.push(vertex);
    }
    public Stack<Integer> getOrder() // 排序
    {
        if(new HasCycle(graph).hasCycle())
        {
            return null;
        }
        Stack<Integer> order = new Stack<>();
        for (int i = 0; i < graph.vertexNum(); i++) {
            if(!marked[i])
            {
                dfs(this.graph, i, order); //依次排序
            }
        }
        return order;
    }
}
