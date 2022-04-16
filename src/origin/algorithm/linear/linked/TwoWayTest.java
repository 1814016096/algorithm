package origin.algorithm.linear.linked;

import origin.algorithm.linear.ILinear;

/**
 * @author 原初
 * @create 2022 - 03 - 16
 * 双向链表测试
 */
public class TwoWayTest {
    public static void main(String[] args) {
        ILinear<Integer> test = new TwoWayLinkedList<>();
        test.insert(10);
        test.insert(20);
        test.insert(30);
        test.insert(40);
        test.insert(20);
        test.insert(10);
        test.insert(4, 100);
        test.remove(6);
//        test.insert(0, 100);
//        test.insert(6, 100);
//        test.remove(6);

        for(var inner : test)
        {
            System.out.println(inner);
        }
    }
}
