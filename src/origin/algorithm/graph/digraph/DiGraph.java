package origin.algorithm.graph.digraph;

import java.util.LinkedList;
import java.util.logging.Level;

/**
 * @author 原初
 * @create 2022 - 04 - 06
 * 有向图
 */
public class DiGraph {
    private int[] vertexs;//点
    private LinkedList<Integer>[] sides;// 边
    private int count;
    public DiGraph(int number)
    {
        vertexs = new int[number];
        count = 0;
        sides = new LinkedList[number];
        for (int i = 0; i < sides.length; i++) {
            sides[i] = new LinkedList<>();
        }
    }
    public int vertexNum()
    {
        return vertexs.length;
    }
    public int sideNumber()
    {
        return count;
    }
    public void addSide(int from, int to)// from -> to
    {
        var list = sides[from];
        for(var item : list)
        {
            if(to == item)
            {
                return;
            }
        }
        list.addLast(to);
        count++;
    }
    public LinkedList<Integer> getAbout(int vertex)
    {
        return sides[vertex];
    }
    public DiGraph reverse() //反转
    {
        DiGraph reverser = new DiGraph(sides.length);
        for (int i = 0; i < sides.length; i++) {
            for (Integer v : sides[i]) {
                reverser.addSide(v, i);
            }
        }
        return reverser;
    }
}
