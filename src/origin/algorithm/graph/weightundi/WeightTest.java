package origin.algorithm.graph.weightundi;

/**
 * @author 原初
 * @create 2022 - 04 - 08
 */
public class WeightTest {
    public static void main(String[] args) {
        WeightUndiGraph wug = new WeightUndiGraph(10);
        wug.addEdge(new Side(1, 3, 1));
        wug.addEdge(new Side(3, 5, 1));
        wug.addEdge(new Side(5, 7, 1));
        wug.addEdge(new Side(7, 9, 1));
        wug.addEdge(new Side(9, 1, 1));
        wug.addEdge(new Side(1, 2, 1));
        wug.addEdge(new Side(2, 7, 1));
        wug.addEdge(new Side(7, 4, 1));
        wug.addEdge(new Side(4, 8, 1));
        wug.addEdge(new Side(8, 4, 1));
        wug.addEdge(new Side(1, 1, 1));
        System.out.println(wug.sideSize());
    }
}
