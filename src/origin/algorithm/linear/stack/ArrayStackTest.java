package origin.algorithm.linear.stack;

/**
 * @author 原初
 * @create 2022 - 03 - 18
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<Integer> test = new ArrayStack<>(10);
        for (int i = 0; i < 10; i++) {
            test.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(test.pop()); // ok
        }
    }
}
