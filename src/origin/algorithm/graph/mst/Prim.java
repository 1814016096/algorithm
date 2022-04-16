package origin.algorithm.graph.mst;

import origin.algorithm.graph.weightundi.Side;
import origin.algorithm.graph.weightundi.WeightUndiGraph;
import origin.algorithm.tree.heap.IndexPriorityQueue;

import java.util.LinkedList;

/**
 * @author 原初
 * @create 2022 - 04 - 09
 * Prim算法实现最小生成树
 * 终于明白了
 */
public class Prim {
    private boolean[] marked;
    private Side[] sides; //存树的边的
    private IndexPriorityQueue<Double> compareTool; //其实就是比较用
    public Prim(WeightUndiGraph graph)
    {
        sides = new Side[graph.vertexSize()];
        marked = new boolean[graph.vertexSize()];
        compareTool = new IndexPriorityQueue<>(graph.vertexSize()); //初始化
        compareTool.insert(0, 0.0); //初始化
        while(!compareTool.isEmpty())
        {
            visit(graph, compareTool.deleteMin()); //每次取出最小的边连接的顶点
        }
    }
    private void visit(WeightUndiGraph graph, int vertex) //主要方法
    {
        marked[vertex] = true;
        LinkedList<Side> sides = graph.getSide(vertex);
        for (Side side : sides) {
            if(!marked[side.getDiff(vertex)])
            {
                if(compareTool.contain(side.getDiff(vertex)))
                {
                    if(side.compareTo(this.sides[side.getDiff(vertex)]) < 0)
                    {
                        compareTool.updateValue(side.getDiff(vertex), side.getWeight());
                        this.sides[side.getDiff(vertex)] = side;
                    }

                }else{
                    compareTool.insert(side.getDiff(vertex), side.getWeight());
                    this.sides[side.getDiff(vertex)] = side;
                }
            }
        }
    }
    public LinkedList<Side> getList()
    {
        LinkedList<Side> sides = new LinkedList<>();
        for (Side side : this.sides) {
            sides.addLast(side);
        }
        return sides;
    }
}
