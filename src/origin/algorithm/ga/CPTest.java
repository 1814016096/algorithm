package origin.algorithm.ga;

/**
 * @author 原初
 * @create 2022 - 04 - 23
 */
public class CPTest {
    public static void main(String[] args) {
        CoveringProblems cp = new CoveringProblems();
        cp.insertRegion("1");
        cp.insertRegion("2");
        cp.insertRegion("3");
        cp.insertRegion("4");
        cp.insertStation(new Station("1站", "1", "2"));
        cp.insertStation(new Station("2站", "2", "3", "4"));
        cp.insertStation(new Station("3站", "3", "4"));
        System.out.println(cp.greedy());
    }
}
