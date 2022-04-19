package origin.algorithm.tree.avl;

/**
 * @author 原初
 * @create 2022 - 04 - 19
 * AVL树的节点
 */
public class AVLNode<T extends Comparable<T>>{
    private AVLNode<T> left;
    private AVLNode<T> right;
    private T content;
    //求高度
    public int height()
    {
        return Math.max((left == null ? 0 : left.height())
                , (right == null ? 0 : right.height())) + 1;
    }
    public int balanceFactor() //平衡因子 -> 右边大为正
    {
        if(right == null && left == null)
        {
            return 0;
        }
        if(right == null)
        {
            return -left.height();
        }
        if(left == null)
        {
            return right.height();
        }
        return right.height() - left.height();
    }
    public AVLNode(AVLNode<T> left, AVLNode<T> right, T content) {
        this.left = left;
        this.right = right;
        this.content = content;
    }

    public AVLNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
