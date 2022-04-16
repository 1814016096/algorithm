package origin.algorithm.tree.heap;

/**
 * @author 原初
 * @create 2022 - 03 - 28
 * 最小优先队列(其实就是小顶堆改个名字)
 */
public class MinPriorityQueue<T>{
    private Comparable<T>[] heap;
    private int length;

    public MinPriorityQueue(int capacity) {
        heap = new Comparable[capacity + 1]; //废弃0
        length = 0;
    }

    public int size()
    {
        return length;
    }
    public boolean isEmpty()
    {
        return length == 0;
    }
    private void change(int i, int j)
    {
        var temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    private boolean isLess(int pre, int post)
    {
        return heap[pre].compareTo((T)heap[post]) < 0;
    }
    public void insert(Comparable<T> item)
    {
        heap[++length] = item;
        swim(length);
    }
    private void swim(int pos) //上浮算法
    {
        int father = -1;
        while ((father = pos/2) > 0)
        {
            if(isLess(pos, father))
            {
                change(pos, father);
                pos = father;
            }else{
                break;
            }
        }
    }
    public T delMin()
    {
        Comparable item = heap[length];
        Comparable temp = heap[1]; // 返回
        heap[length] = null; //help gc
        heap[1] = item;
        length--;
        sink(1);
        return (T) temp;
    }
    //下沉算法
    private void sink(int pos)
    {
        while(pos * 2 <= length)
        {
            int minPos = -1;
            if(pos * 2 + 1 > length) {
                minPos = pos * 2;
            }else{
                minPos = isLess(pos * 2, pos * 2 + 1) ? pos * 2 : pos * 2 + 1;
            }
            if(isLess(pos, minPos))
            {
                break; //如果已经小了，就结束循环
            }
            change(minPos, pos);
            pos = minPos;
        }
    }
}
