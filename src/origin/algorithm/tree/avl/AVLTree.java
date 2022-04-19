package origin.algorithm.tree.avl;

import java.util.function.Consumer;

/**
 * @author 原初
 * @create 2022 - 04 - 19
 * AVL平衡树
 */
public class AVLTree<T extends Comparable<T>>{
    AVLNode<T> root;
    public int factor()
    {
        return root.balanceFactor();
    }
    public void insert(T value)
    {
        root = insert(root, value);
    }
    private AVLNode<T> insert(AVLNode<T> node, T value)
    {
        if(node == null)
        {
            return new AVLNode<>(null, null, value);
        }
        if(value.compareTo(node.getContent()) > 0){
            node.setRight(insert(node.getRight(), value));
        }else if(value.compareTo(node.getContent()) < 0){
            node.setLeft(insert(node.getLeft(), value));
        }else{
            node.setContent(value);
        }
        //调整
        if(node.getRight() != null && node.getRight().balanceFactor() < 0)
        {
            node.setRight(rightfy(node.getRight()));
        }
        if(node.getLeft() != null && node.getLeft().balanceFactor() > 0)
        {
            node.setLeft(leftfy(node.getLeft()));
        }
        if(node.balanceFactor() > 1) //右边比左边大
        {
            node = leftfy(node);
        }else if(node.balanceFactor() < -1){
            node = rightfy(node);
        }
        return node;
    }

    private AVLNode<T> rightfy(AVLNode<T> node) {
        AVLNode<T> left = node.getLeft();
        node.setLeft(left.getRight());
        left.setRight(node);
        return left;
    }

    private AVLNode<T> leftfy(AVLNode<T> node) {
        AVLNode<T> right = node.getRight();
        node.setRight(right.getLeft());
        right.setLeft(node);
        return right;
    }
    //中序遍历
    public void midTransal(Consumer<T> todo)
    {
        midTransal(root, todo);
    }
    private void midTransal(AVLNode<T> node, Consumer<T> todo)
    {
        if(node == null)
        {
            return;
        }
        midTransal(node.getLeft(), todo);
        todo.accept(node.getContent());
        midTransal(node.getRight(), todo);
    }
}
