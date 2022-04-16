package origin.algorithm.tree.redBlackTree;

/**
 * @author 原初
 * @create 2022 - 03 - 31
 */
public class RedBlockTree<T extends Comparable<T>>{
    private RBNode<T> root;
    private RBNode<T> adjust1(RBNode<T> first) //左边两个连续的节点都是红色的跳转
    {
        RBNode<T> root = first;
        RBNode<T> midTemp;
        if(first != null && (midTemp = first.getLChild() )!= null)
        {
            RBNode<T> endTemp;
            if((endTemp = midTemp.getLChild()) != null)
            {
                if(endTemp.isRed() && midTemp.isRed())
                {
                    midTemp.setRed(first.isRed());
                    first.setRed(true);
                    RBNode<T> midNode = midTemp.getRchild();
                    midTemp.setRchild(first);
                    first.setLChild(midNode);
                    root = midTemp;
                }
            }
        }
        return root;
    }
    private RBNode<T> adjust2(RBNode<T> first) //右边是红色节点的跳转
    {
        RBNode<T> root = first;
        RBNode<T> midTemp;
        if(first != null && (midTemp = first.getRchild()) != null)
        {
            if(midTemp.isRed())
            {
                midTemp.setRed(first.isRed());
                first.setRed(true);
                RBNode<T> temp = midTemp.getLChild();
                first.setRchild(temp);
                midTemp.setLChild(first);
                root = midTemp;
            }
        }
        return root;
    }
    public String find(T content)
    {
        StringBuilder str = new StringBuilder();
        find(root, content, str);
        return str.toString();
    }
    private void find(RBNode<T> node ,T content,StringBuilder str)
    {
        if(node == null)
        {
            str.append(" null");
            return;
        }
        if(node.isRed() && node != root)
        {
            str.append("*");
        }
        if(content.compareTo(node.getContent()) > 0)
        {
            str.append("R");
            find(node.getRchild(), content, str);
        }else if(content.compareTo(node.getContent()) < 0) {
            str.append("L");
            find(node.getLChild(), content, str);
        }else{
            str.append(" finded");
            return;
        }
    }
    public int size()
    {

        if(root == null)
        {
            return 0;
        }
        int count = 1;
        RBNode<T> temp = root;
        while (temp.getLChild() != null)
        {
            temp = temp.getLChild();
            if(!temp.isRed())
            {
                count++;
            }
        }
        return count;
    }
    private RBNode<T> colorReverse(RBNode<T> first) //颜色反转
    {
        RBNode<T> lChild;
        RBNode<T> rChild;
        if(first != null &&
                (lChild = first.getLChild()) != null &&
                (rChild = first.getRchild()) != null)
        {
            if(lChild.isRed() && rChild.isRed())
            {
                lChild.setRed(false);
                rChild.setRed(false);
                first.setRed(!first.isRed());
            }
        }
        return first;
    }
    public void insert(T content)
    {
        root = insert(root, content);
        RBNode<T> tempRoot = new RBNode<>(null, root, null, false);
        tempRoot.setRchild(root);
        tempRoot.setRchild(adjust1(tempRoot.getRchild()));
        tempRoot.setRchild(colorReverse(tempRoot.getRchild()));
        tempRoot.setRchild(adjust2(tempRoot.getRchild()));
        root = tempRoot.getRchild();
    }
    private RBNode<T> insert(RBNode<T> node, T content)
    {
        if(node == null)
        {
            return new RBNode<>(null, null, content, true);
        }
        if(content.compareTo(node.getContent()) > 0)
        {
            node.setRchild(insert(node.getRchild(), content));
            node.setRchild(adjust1(node.getRchild()));
            node.setRchild(colorReverse(node.getRchild()));
            node.setRchild(adjust2(node.getRchild()));
        }
        else if(content.compareTo(node.getContent()) < 0)
        {
            node.setLChild(insert(node.getLChild(), content));
            node.setLChild(adjust1(node.getLChild()));
            node.setLChild(colorReverse(node.getLChild()));
            node.setLChild(adjust2(node.getLChild()));
        }
        return node;
    }
}
