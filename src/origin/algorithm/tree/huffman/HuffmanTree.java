package origin.algorithm.tree.huffman;

import origin.algorithm.tree.heap.MinPriorityQueue;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author 原初
 * @create 2022 - 04 - 16
 * 哈夫曼树的实现
 */
public class HuffmanTree{
    private MinPriorityQueue<HuffmanNode> priorityQueue;
    private HuffmanNode root;
    public HuffmanTree(int ... items) {
        this.priorityQueue = new MinPriorityQueue<>(items.length);

        for (int item : items) {
            HuffmanNode huffmanNode = new HuffmanNode(item, null, null);
            priorityQueue.insert(huffmanNode);
        }
    }
    public HuffmanNode coding() //编码(只能一次)
    {
        if(root == null)
        {
            while (priorityQueue.size() > 1)
            {
                HuffmanNode left = priorityQueue.delMin();
                HuffmanNode right = priorityQueue.delMin();// 最小的两个
                HuffmanNode parent = new HuffmanNode(left.getValue() + right.getValue()
                        , left, right);//生成根
                priorityQueue.insert(parent);
            }
            root = priorityQueue.delMin();
        }
        return root;
    }
    public void preTravel(Consumer<HuffmanNode> consumer) //前序遍历
    {
        preTravel(consumer, root);
    }
    public void preTravel(Consumer<HuffmanNode> consumer, HuffmanNode node) //前序遍历
    {
        if(node == null)
        {
            return;
        }
        if(node.getLeft() == null && null == node.getRight())
        {
            consumer.accept(node);
        }

        preTravel(consumer, node.getLeft());
        preTravel(consumer, node.getRight());
    }
}
