package origin.algorithm.graph;

import java.util.LinkedList;

/**
 * @author 原初
 * @create 2022 - 04 - 04
 * Deep First Search 深度优先搜索
 */
public class DFS {
    private boolean[] marked; //是否被遍历
    private int count = 0; //统计连接的顶点数量
    public DFS(UndiGraph graph, int vertex) //遍历
    {
        marked = new boolean[graph.vertexSize()];
        dfs(graph ,vertex); //直接进行
    }
    private void dfs(UndiGraph graph ,int vertex)
    {
        LinkedList<Integer> about = graph.get(vertex);
        marked[vertex] = true;
        count++;
        if(about == null)
        {
            return;
        }else{
            for(var item : about)
            {
                if(!marked[item])
                {
                    dfs(graph, item);
                }
            }
        }
    }
    public int connNum()
    {
        return count;
    }
    public boolean isConnect(int v)
    {
        return marked[v] == true;
    }
    public LinkedList<Integer> connVertexs()
    {
        LinkedList<Integer> vertexs = new LinkedList<>();
        for (int i = 0; i < marked.length; i++) {
            if(marked[i])
            {
                vertexs.addLast(i);
            }
        }
        return vertexs;
    }
}
