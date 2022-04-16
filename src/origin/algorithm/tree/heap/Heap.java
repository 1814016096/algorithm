package origin.algorithm.tree.heap;

/**
 * @author 原初
 * @create 2022 - 03 - 26
 * 堆(基于数组和树的数据结构)
 */
public class Heap <T>{
    private int length;
    private Comparable<T>[] tree;

    public Heap(int capacity) {
        this.tree = new Comparable[capacity - 1]; // 废弃0位置
        length = 0;
    }
    public int size()
    {
        return length;
    }
    public T delMax()
    {
        Comparable<T> right = tree[length];
        Comparable<T> temp = tree[1];
        tree[length--] = null; //help gc
        tree[1] = right; //删掉第一个元素
        sink(1); //下沉使得堆有序
        return (T)temp;
    }

    private void sink(int n) //下沉n位置的元素
    {
        while (n * 2 <= length)
        {
            int greater = isLess(n * 2, n * 2 + 1) ? n * 2 + 1 : n * 2; // 子节点的中较大的
            if(isLess(n, greater)) // 更小的话
            {
                change(n, greater);
                n = greater;
            }else {
                break;
            }
        }

    }
    public void insert(Comparable<T> content)
    {
        tree[++length] = content; //先放入
        swim(length); // 上浮算法
    }

    //堆的上浮算法
    private void swim(int pos)
    {
        int father = pos / 2;
        while (father != 0)
        {
            if(isLess(father, pos))
            {
                change(father, pos);
                pos = father;
                father = pos / 2;
            }else{
                return; // 如果更大（或相同），则上浮,否则就结束
            }
        }
    }
    private void change(int i, int j)
    {
        Comparable<T> temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }
    private boolean isLess(int i, int j)
    {
        if(j > length)
        {
            return false;
        }
        return tree[i].compareTo((T)tree[j]) < 0;
    }

}
