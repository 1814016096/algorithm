package origin.algorithm.graph.weight;

import origin.algorithm.graph.weightundi.Side;
import origin.algorithm.linear.stack.LinkedStack;
import origin.algorithm.linear.stack.Stack;
import origin.algorithm.tree.heap.IndexPriorityQueue;

import java.util.LinkedList;

/**
 * @author 原初
 * @create 2022 - 04 - 12
 * Dijkstra算法实现最短路径问题
 */
public class Dijkstra {
    private IndexPriorityQueue<Double> judgeTool; //每次松弛和添加的主要工具
    private DirectSide[] sides; //存最短路径的上一个节点
    public Dijkstra(DirectGraph graph, int root) //从哪个节点开始
    {
        judgeTool = new IndexPriorityQueue<>(graph.vertexSize());
        sides = new DirectSide[graph.vertexSize()];
        judgeTool.insert(0, 0.0);
        while(!judgeTool.isEmpty())
        {
            relax(graph, judgeTool.getMin(), judgeTool.getMinItem());
            judgeTool.deleteMin();
        }
    }
    private void relax(DirectGraph graph, int target, double weight) //松弛技术:传入需要松弛的点
    {
        LinkedList<DirectSide> targetSides = graph.getSide(target);
        for (DirectSide side : targetSides) {
            if(judgeTool.contain(side.getTo()))
            {
                double oldVal = judgeTool.atIndex(side.getTo());
                double newVal = judgeTool.atIndex(side.getFrom()) + side.getWeight();
                if(newVal < oldVal)
                {
                    judgeTool.updateValue(side.getTo(), newVal);
                    sides[side.getTo()] = side;
                }
            }else{
                judgeTool.insert(side.getTo(), side.getWeight() + weight);
                sides[side.getTo()] = side;
            }
        }
    }
    public LinkedList<DirectSide> path(int to)
    {
        LinkedList<DirectSide> path = new LinkedList<>();
        DirectSide side;
        side = sides[to];
        while(side != null)
        {
            path.addLast(side);
            side = sides[side.getFrom()];
        }
        return path;
    }
}
