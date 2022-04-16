package origin.algorithm.graph;

import origin.algorithm.linear.queue.LinkedQueue;
import origin.algorithm.linear.queue.Queue;

import java.util.LinkedList;

/**
 * @author 原初
 * @create 2022 - 04 - 05
 * 广度优先搜索
 */
public class BFS {
    private boolean[] marked; //是否被遍历
    private int count = 0; //统计连接的顶点数量
    Queue<Integer> vertexQueue; //广度优先搜索的辅助队列
    public BFS(UndiGraph graph, int vertex) //遍历
    {
        marked = new boolean[graph.vertexSize()];
        vertexQueue = new LinkedQueue<>();
        bfs(graph ,vertex); //直接进行
    }
    private void bfs(UndiGraph graph ,int vertex)
    {
        LinkedList<Integer> about = graph.get(vertex);
        marked[vertex] = true;
        count++;
        vertexQueue.enqueue(vertex);
        while (!vertexQueue.isEmpty())
        {
            LinkedList<Integer> temp = graph.get(vertexQueue.dequeue());
            for(Integer v : temp)
            {
                if(!marked[v])
                {
                    vertexQueue.enqueue(v);
                    marked[v] = true;
                    count++;
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
