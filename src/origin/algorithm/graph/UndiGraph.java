package origin.algorithm.graph;

import origin.algorithm.linear.queue.ArraryQueue;
import origin.algorithm.linear.queue.LinkedQueue;
import origin.algorithm.linear.queue.Queue;

import java.util.LinkedList;

/**
 * @author 原初
 * @create 2022 - 04 - 04
 */
public class UndiGraph{

    private int count;
    private LinkedList<Integer>[] nodes;
    public UndiGraph(int capacity)
    {
        nodes = new LinkedList[capacity];
        count = 0;
    }
    public int vertexSize()
    {
        return nodes.length;
    }
    public int SideSize()
    {
        return count;
    }
    public void addSide(int v, int w)
    {
        if(nodes[v] == null)
        {
            nodes[v] = new LinkedList<>();
            nodes[v].addLast(w);
        }
        if(nodes[w] == null)
        {
            nodes[w] = new LinkedList<>();
            nodes[w].addLast(v);
        }
        for (Integer integer : nodes[v]) {
            if(integer == w)
            {
                return;
            }
        }
        nodes[v].addLast(w);
        nodes[w].addLast(v);
        return;
    }
    public LinkedList<Integer> get(int v)
    {
        return nodes[v];
    }
}
