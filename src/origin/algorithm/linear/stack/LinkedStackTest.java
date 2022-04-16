package origin.algorithm.linear.stack;

/**
 * @author 原初
 * @create 2022 - 03 - 18
 */
public class LinkedStackTest {
    public static void main(String[] args) {
        LinkedStack<Integer> test = new LinkedStack<>();
        for (int i = 0; i < 10; i++) {
            test.push(i);
        }
        for(int i : test)
        {
            System.out.println(i);
        }
    }
}
