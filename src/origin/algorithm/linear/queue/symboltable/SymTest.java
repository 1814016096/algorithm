package origin.algorithm.linear.queue.symboltable;

/**
 * @author 原初
 * @create 2022 - 03 - 20
 * 符号表测试
 */
public class SymTest {
    public static void main(String[] args) {
        SymbolTable<String, Integer> test = new SymbolTable<>(15);
        test.put("1", 1);
        test.put("1", 2);
        test.put("2", 1);
        test.put("2", 3);
        test.put("2", 3);
        test.put("2", 3);
        test.put("2", 3);
        test.put("2", 3);
        test.put("2", 10);
        test.put("7", 30);
        System.out.println(test.get("1"));
        System.out.println(test.get("2"));
        System.out.println(test.get("3"));
        System.out.println(test.get("7"));
        System.out.println(test.size());

    }
}
