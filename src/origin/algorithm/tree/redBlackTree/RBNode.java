package origin.algorithm.tree.redBlackTree;

/**
 * @author 原初
 * @create 2022 - 03 - 31
 */
public class RBNode <T>{
    private RBNode<T> LChild;
    private RBNode<T> Rchild;
    private T content;
    private boolean isRed; //是不是红色的

    public RBNode<T> getLChild() {
        return LChild;
    }

    public void setLChild(RBNode<T> LChild) {
        this.LChild = LChild;
    }

    public RBNode<T> getRchild() {
        return Rchild;
    }

    public void setRchild(RBNode<T> rchild) {
        Rchild = rchild;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public RBNode(RBNode<T> LChild, RBNode<T> rchild, T content, boolean isRed) {
        this.LChild = LChild;
        Rchild = rchild;
        this.content = content;
        this.isRed = isRed;
    }

    public RBNode() {
    }
}
