package origin.algorithm.graph.digraph;

import java.util.LinkedList;

/**
 * @author 原初
 * @create 2022 - 04 - 07
 * 检测是否有环，有的话就无法进行拓扑排序
 */
public class HasCycle {
    private boolean[] marked;
    private boolean hasCysle;
    private boolean[] searchingVertex; //正在扫描的顶点
    public HasCycle(DiGraph graph) //有向图
    {
        hasCysle = false;
        searchingVertex = new boolean[graph.vertexNum()];
        marked = new boolean[graph.vertexNum()];
        for (int i = 0; i < searchingVertex.length; i++) {
            if(marked[i])
            {
                continue;
            }
            if(dfs(graph, i))
            {
                hasCysle = true;
                break;
            }
        }
    }
    private boolean dfs(DiGraph graph, int vertex) //用dfs检测是不是有环
    {
        if(searchingVertex[vertex]) //有环
        {
            return true;
        }
        marked[vertex] = true;

        searchingVertex[vertex] = true;
        LinkedList<Integer> about = graph.getAbout(vertex); //获取直接相邻顶点
        for (Integer v : about) {
            if(dfs(graph, v))
            {
               return true;
            }
        }
        searchingVertex[vertex] = false;
        return false;
    }
    public boolean hasCycle()
    {
        return hasCysle;
    }
}
