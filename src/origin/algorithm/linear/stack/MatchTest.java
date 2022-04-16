package origin.algorithm.linear.stack;

/**
 * @author 原初
 * @create 2022 - 03 - 18
 */
public class MatchTest {
    public static void main(String[] args) {
        BacketMatch match = new BacketMatch("(()(12))", true); // ok
        System.out.println(match.isTrue());
    }
}
