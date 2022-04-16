package origin.algorithm.linear.linked;

import origin.algorithm.linear.ILinear;

/**
 * @author 原初
 * @create 2022 - 03 - 16
 */
public class LinkedTest {
    public static void main(String[] args) {
        SingleLinkedList<Integer> test = new SingleLinkedList<>();
        test.insert(10);
        test.insert(120);
        test.insert(30);
        test.insert(40);
        test.insert(20);
        test.insert(10);
        test.insert(0, 100);
        test.insert(6, 100);
        test.remove(6);

        for(var inner : test)
        {
            System.out.println(inner);
        }
        System.out.println();
        test.reverse();
        System.out.println(test.isRing());
//        for(var inner : test)
//        {
//            System.out.println(inner);
//        }
        System.out.println();
        System.out.println(SingleLinkedList.getRingFirst(test.getFirst()));
//        System.out.println(test.getMiddle());
    }


}
