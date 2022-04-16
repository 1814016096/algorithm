package origin.algorithm.tree;

/**
 * @author 原初
 * @create 2022 - 03 - 23
 */
public class BInaryTest {
    public static void main(String[] args) {
        SearchTree<String, Integer> test = new SearchTree<>();
        test.put("1", 10);
        test.put("2", 100);
        test.put("5", 1000);
        test.put("3", 5000);
        test.put("7", 600);
        test.put("10", 7800);
        test.put("1", 7100);
        System.out.println(test.get("7"));
        test.delete("1");
        System.out.println(test.get("7"));
        System.out.println(test.get("1"));
        test.delete("7");
        System.out.println(test.get("7"));
        System.out.println(test.get("1"));
        System.out.println(test.min());
    }
}
