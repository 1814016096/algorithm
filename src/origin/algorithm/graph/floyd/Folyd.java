package origin.algorithm.graph.floyd;

import origin.algorithm.graph.UndiGraph;
import origin.algorithm.graph.weightundi.WeightUndiGraph;

/**
 * @author 原初
 * @create 2022 - 04 - 25
 * 弗洛伊德算法解决最短路径问题
 */
public class Folyd {
//    WeightUndiGraph graph; //散列表
    public static int getWeight(int weight)
    {
        return weight == -1 ? 65535 : weight;
    }
    public Folyd(ArrayGraph graph)
    {
        //首先是中间节点的遍历
        for (int center = 0; center < graph.getSide().length; center++) {
            for (int start = 0; start < graph.getSide().length; start++) { //出发节点的遍历
                for (int end = 0; end < graph.getSide().length; end++) {//到达节点的遍历
                    int wieght = getWeight(graph.getWeight()[start][center])
                            + getWeight(graph.getWeight()[center][end]); //从开始到中间的权值加上从中间到末尾的权值
                    if(wieght < getWeight(graph.getWeight()[start][end]))
                    {
                        graph.getWeight()[start][end] = wieght;
                        graph.getSide()[start][end] = graph.getSide()[center][end];
                    }
                }
            }
        }
    }

}
