package origin.algorithm.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 原初
 * @create 2022 - 04 - 06
 * 深度优先路径查找
 */
public class DeepFirrstPath {
    int thisVertex;
    private boolean[] marked; //是否被遍历
    private int[] from; //from表，存为上一个相连的路径
    private int count = 0; //统计连接的顶点数量
    public DeepFirrstPath(UndiGraph graph, int vertex) //遍历
    {
        marked = new boolean[graph.vertexSize()];
        from = new int[graph.vertexSize()];
        thisVertex = vertex;
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
                    from[item] = vertex;
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
    public Stack<Integer> pathVertexs(int target) // 查找路径
    {
        if(!isConnect(target))
        {
            return null;
        }else{
            Stack<Integer> vertexs = new Stack<>();
            while(thisVertex != target)
            {
                vertexs.push(target);
                target = from[target];
            }
            vertexs.push(thisVertex);
            return vertexs;
        }
    }

}
