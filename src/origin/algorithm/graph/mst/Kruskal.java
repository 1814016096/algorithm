package origin.algorithm.graph.mst;

import origin.algorithm.graph.BFS;
import origin.algorithm.graph.UndiGraph;
import origin.algorithm.graph.weightundi.Side;
import origin.algorithm.graph.weightundi.WeightConnectionJudge;
import origin.algorithm.graph.weightundi.WeightUndiGraph;
import origin.algorithm.tree.heap.MinPriorityQueue;
import origin.algorithm.tree.uf.UFTreeWeight;

import java.util.LinkedList;

/**
 * @author 原初
 * @create 2022 - 04 - 10
 * Kruskal算法解决最小生成树
 */
public class Kruskal {
    private MinPriorityQueue<Side> priorityQueue;
    private LinkedList<Side> path;
    private UFTreeWeight connectionJudger;
    public Kruskal(WeightUndiGraph graph){
        //最小生成树
        priorityQueue = new MinPriorityQueue<>(graph.vertexSize() * graph.sideSize());
        path = new LinkedList<>();
        connectionJudger = new UFTreeWeight(graph.vertexSize());
        UndiGraph undiGraph = new UndiGraph(graph.vertexSize());
        for (int i = 0; i < graph.vertexSize(); i++) {
            for (Side side : graph.getSide(i)) {
                priorityQueue.insert(side); //插入所有的
            }
        }
        while(!priorityQueue.isEmpty() && path.size() < graph.vertexSize() - 1){
            Side min = priorityQueue.delMin();
            if(!connectionJudger.isConnected(min.getOneVertex(), min.getOtherVertex()))
            {
                connectionJudger.union(min.getOneVertex(), min.getOtherVertex());
                path.addLast(min);
            }
        }
    }

    public LinkedList<Side> getPath() {
        return path;
    }
}
