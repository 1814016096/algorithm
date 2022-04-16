package origin.algorithm.tree;

import origin.algorithm.linear.queue.Queue;

/**
 * @author 原初
 * @create 2022 - 03 - 25
 */
public class TraversalTest {
    public static void main(String[] args) {
        SearchTree<String, Integer> test = new SearchTree<>();
        test.put("1", 10);
        test.put("2", 100);
        test.put("5", 1000);
        test.put("3", 5000);
        test.put("7", 600);
        test.put("10", 7800);
        test.put("1", 7100);
        //前序
        Queue<String> pre = test.preTraversal();
        for(var content : pre)
        {
            System.out.println(content);
        }
        System.out.println();
        //中序
        Queue<String> mid = test.midTraversal();
        for(var content : mid)
        {
            System.out.println(content);
        }
        System.out.println();
        //层序
        Queue<String> scq = test.sequenceTraversal();
        for(var content : scq)
        {
            System.out.println(content);
        }
        // 最大深度
        System.out.println();
        System.out.println(test.maxDepth());
    }
}
