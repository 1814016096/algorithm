package origin.algorithm.tree;

import origin.algorithm.linear.queue.ArraryQueue;
import origin.algorithm.linear.queue.LinkedQueue;
import origin.algorithm.linear.queue.Queue;

import javax.sound.midi.Sequence;
import javax.swing.tree.TreeNode;
import java.util.logging.Level;

/**
 * @author 原初
 * @create 2022 - 03 - 23
 * 二叉查找树
 */
public class SearchTree<K extends Comparable, V>{
    private BinaryNode<K, V> root;
    public void put(K key, V value)
    {
        root = put(root,key, value);
    }
    private BinaryNode<K, V> put(BinaryNode<K, V> root, K key, V value)
    {
        if(root == null)
        {
            return new BinaryNode<>(null, null, key, value);
        }
        if(key.compareTo(root.getKey()) > 0)
        {
            root.setRight(put(root.getRight(), key, value));
        }
        else if(key.compareTo(root.getKey()) == 0)
        {
            root.setValue(value);
        }else{
            root.setLeft(put(root.getLeft(), key, value));
        }
        return root;
    }
    public void delete(K key)
    {
        BinaryNode node = null;
        if((node = get(key)) == null)
        {
            return;
        }else{
            root = delete(root, key);
        }
    }
    public BinaryNode<K, V> max()
    {
        return findRight(root);
    }
    public BinaryNode<K, V> min()
    {
        return findLeft(root);
    }
    private BinaryNode<K, V> findLeft(BinaryNode<K, V> node)
    {
        if(node == null)
        {
            return node;
        }
        while(node.getLeft() != null)
        {
            node = node.getLeft();
        }
        return node;
    }
    private BinaryNode<K, V> findRight(BinaryNode<K, V> node)
    {
        if(node == null)
        {
            return node;
        }
        while(node.getRight() != null)
        {
            node = node.getRight();
        }
        return node;
    }
    private BinaryNode<K, V> findsubLeft(BinaryNode<K, V> node)
    {
        if(node == null)
        {
            return node;
        }
        while(node.getLeft().getLeft()!= null)
        {
            node = node.getLeft();
        }
        return node;
    }
    private BinaryNode<K, V> delete(BinaryNode<K, V> curr, K key)
    {
        if(curr == null)
        {
            return null;
        }
        int cmp = key.compareTo(curr.getKey());
        if(cmp > 0)
        {
            curr.setRight(delete(curr.getRight(), key));
            return curr;
        }
        else if(cmp < 0)
        {
            curr.setLeft(delete(curr.getLeft(), key));
            return curr;
        }
        else
        {
            if(curr.getLeft() == null)
            {
                return curr.getRight();
            }
            if(curr.getRight() == null)
            {
                return curr.getLeft();
            }
            BinaryNode<K, V> subleft = findsubLeft(curr);
            BinaryNode<K, V> left = subleft.getLeft();
            left.setLeft(curr.getRight());
            left.setRight(curr.getRight());
            subleft.setLeft(null);
            return left;
        }
    }
    public BinaryNode<K, V> get(K key)
    {
        return get(root, key);
    }
    private BinaryNode<K, V> get(BinaryNode<K, V> root, K key)
    {
        if(root == null)
        {
            return root;
        }
        if(key.compareTo(root.getKey()) > 0)
        {
            return get(root.getRight(), key);
        }
        else if(key.compareTo(root.getKey()) == 0)
        {
            return root;
        }else{
            return get(root.getLeft(), key);
        }
    }
    public Queue<K> preTraversal()
    {
        Queue<K> keys = new LinkedQueue<>();
        preTraversal(root, keys);
        return keys;
    }
    private void preTraversal(BinaryNode<K, V> root, Queue<K> keys)
    {
        // 前序遍历
        if(root == null)
        {
            return;
        }
        keys.enqueue(root.getKey());// 自己
        preTraversal(root.getLeft(), keys); //左子树
        preTraversal(root.getRight(), keys); //右子树
    }

    public Queue<K> midTraversal()
    {
        Queue<K> keys = new LinkedQueue<>();
        midTraversal(root, keys);
        return keys;
    }
    private void midTraversal(BinaryNode<K, V> root, Queue<K> keys)
    {
        // 中序遍历
        if(root == null)
        {
            return;
        }
        preTraversal(root.getLeft(), keys); //左子树
        keys.enqueue(root.getKey());// 自己
        preTraversal(root.getRight(), keys); //右子树
    }
    public Queue<K> postTraversal()
    {
        Queue<K> keys = new LinkedQueue<>();
        postTraversal(root, keys);
        return keys;
    }
    private void postTraversal(BinaryNode<K, V> root, Queue<K> keys)
    {
        // 后序遍历
        if(root == null)
        {
            return;
        }
        preTraversal(root.getLeft(), keys); //左子树
        preTraversal(root.getRight(), keys); //右子树
        keys.enqueue(root.getKey());// 自己
    }

    public Queue<K> sequenceTraversal()
    {
        //层序遍历
        if (root == null)
        {
            return null;
        }
        Queue<K> result = new LinkedQueue<>(); // 结果
        Queue<BinaryNode<K, V>> process = new LinkedQueue<>();
        process.enqueue(root); //先把根节点入队
        while (!process.isEmpty())
        {
            BinaryNode<K, V> node = process.dequeue();
            if(node.getLeft() != null)
            {
                process.enqueue(node.getLeft());
            }
            if(node.getRight() != null)
            {
                process.enqueue(node.getRight()); // 把左右结点入队
            }
            result.enqueue(node.getKey());
        }
        return result;
    }
    //最大深度
    public int maxDepth()
    {
        return maxDepth(root);
    }
    private int maxDepth(BinaryNode<K, V> node)
    {
        if(node == null)
        {
            return 0;
        }
        int left = maxDepth(node.getLeft()); // 左边的高度
        int right = maxDepth(node.getRight());// 右边的高度
        return left > right ? left + 1: right + 1; //返回较大值 + 1
    }
}
