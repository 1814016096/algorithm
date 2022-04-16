package origin.algorithm.graph.weightundi;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author 原初
 * @create 2022 - 04 - 08
 * 加权无向图
 */
public class WeightUndiGraph {
    private LinkedList<Side>[] vertex; //顶点散列表
    private int sideNum; // 边的数量

    public WeightUndiGraph(int capacity) {
        vertex = new LinkedList[capacity];
        sideNum = 0;
        for (int i = 0; i < vertex.length; i++) {
            vertex[i] = new LinkedList<>(); //初始化每个
        }
    }
    public int sideSize()
    {
        return sideNum;
    }
    public int vertexSize()
    {
        return vertex.length;
    }
    public void addEdge(Side s)
    {
        if(s.getOtherVertex() == s.getOneVertex())
        {
            return;
        }
        int oneVertex = s.getOneVertex();
        int otherVertex = s.getOtherVertex();
        for (Side about : vertex[oneVertex]) {
            int to = about.getOneVertex() == oneVertex ? about.getOtherVertex() : about.getOneVertex();
            if(to == otherVertex)
            {
                return;
            }
        }
        sideNum++;
        vertex[oneVertex].addLast(s);
        vertex[otherVertex].addLast(s);
    }
    public LinkedList<Side> getSide(int vertex)
    {
        return this.vertex[vertex];
    }
    public LinkedList<Side> getSide()
    {
        LinkedList<Side> allSide = new LinkedList<>();
        for (int i = 0; i < vertex.length; i++) {
            LinkedList<Side> sides = vertex[i];
            for (Side side : sides) {
                if(Math.max(side.getOtherVertex(), side.getOneVertex()) == i)
                {
                    allSide.addLast(side);
                }
            }
        }
        return allSide;
    }
}
