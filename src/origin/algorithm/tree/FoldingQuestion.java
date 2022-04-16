package origin.algorithm.tree;

import origin.algorithm.linear.array.Scquence;

/**
 * @author 原初
 * @create 2022 - 03 - 26
 * 折纸问题的解决方案
 */
public class FoldingQuestion {
    public Scquence<String> getResult(int n)
    {
        BinaryNode<String, Object> res = build(n);
        Scquence<String> realRes = new Scquence<>();
        midTraversal(res, realRes);
        return realRes;
    }
    private void midTraversal(BinaryNode<String, Object> res, Scquence<String> contain)
    {
        if(res == null)
        {
            return;
        }
        midTraversal(res.getLeft(), contain);
        contain.add(res.getKey());
        midTraversal(res.getRight(), contain);
    }
    public BinaryNode<String, Object> build(int n)
    {
        return build("down", n);
    }
    private BinaryNode<String, Object> build(String downOrUp, int n)
    {
        if(n <= 0)
        {
            return null;
        }
        BinaryNode<String, Object> node = new BinaryNode<>(null, null,downOrUp, null);
        node.setLeft(build("down", n - 1));
        node.setRight(build("up", n - 1));
        return node;
    }
}
