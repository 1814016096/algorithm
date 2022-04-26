package origin.algorithm.graph.floyd;

/**
 * @author 原初
 * @create 2022 - 04 - 25
 */
public class FolydTest {
    public static void main(String[] args) {
        int[][] ints = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ints[i][j] = Math.abs(i - j);
            }
        }
        ints[2][4] = -1;
        ints[4][2] = -1;
        ints[1][4] = -1;
        ints[4][1] = -1;
        ArrayGraph arrayGraph = new ArrayGraph(ints);
        arrayGraph.show();
        new Folyd(arrayGraph);
        System.out.println();
        arrayGraph.show();
    }
}
