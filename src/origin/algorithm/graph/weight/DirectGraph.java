package origin.algorithm.graph.weight;

import java.util.LinkedList;

/**
 * @author 原初
 * @create 2022 - 04 - 11
 * 稼轩有向图
 */
public class DirectGraph {
    private int sideNum;
    private LinkedList<DirectSide>[] sides; //邻接表

    public DirectGraph(int capacity) {
        sides = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            sides[i] = new LinkedList<>();
        }
    }
    public void addSide(DirectSide side)
    {
        int from = side.getFrom();
        for (DirectSide s : sides[from]) {
            if(s.equals(side))
            {
                s.setWeight(side.getWeight());
                return;
            }
        }
        sides[from].addLast(side);
        sideNum++;
    }
    public int sideSize()
    {
        return sideNum;
    }
    public int vertexSize()
    {
        return sides.length;
    }
    public LinkedList<DirectSide> getSide(int vertex)
    {
        return sides[vertex];
    }
    public LinkedList<DirectSide> getSide()
    {
        LinkedList<DirectSide> sides = new LinkedList<>();
        for (LinkedList<DirectSide> side : this.sides) {
            sides.addAll(side);
        }
        return sides;
    }
}
