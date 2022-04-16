package origin.algorithm.tree.heap;

/**
 * @author 原初
 * @create 2022 - 03 - 28
 * 索引优先队列
 */
public class IndexPriorityQueue<T>{
    private Comparable<T>[] source; //没经过排序的原数组
    private int[] indexHeap; //储存索引的堆
    private int[] assist; //上面两个数组的辅助数组(翻译数组?)
    private int length;
    public IndexPriorityQueue(int capacity) {
        source = new Comparable[capacity + 1];
        indexHeap = new int[capacity + 1];
        assist = new int[capacity + 1];
        length = 0;
    }
    public void insert(int index, Comparable<T> t)
    {
        source[index] = t;
        indexHeap[++length] = index; //记录索引
        assist[index] = length; //辅助记录
        swim(length); //上浮
    }
    public int size()
    {
        return length;
    }
    public boolean isEmpty()
    {
        return length == 0;
    }
    public boolean contain(int k)
    {
        return source[k] != null;
    }
    public boolean updateValue(int index, Comparable<T> item)
    {
        if(!contain(index))
        {
            return false;
        }
        source[index] = item;
        int father = getHeapIndex(index) / 2;
        if(isLess(getHeapIndex(index), father))
        {
            swim(getHeapIndex(index));
        }else{
            sink(getHeapIndex(index));
        }
        return true;
    }
    public int miniIndex()
    {
        return getIndex(1);
    }
    public T atIndex(int index)
    {
        return (T) source[index];
    }
    private int findEnd(int heapIndex)
    {
        while(heapIndex * 2 + 1 <= length)
        {
            heapIndex = heapIndex * 2 + 1;
        }
        if(heapIndex * 2 <= length)
        {
            heapIndex = heapIndex * 2;
        }
        return heapIndex;
    }
    public T delete(int index)
    {
        int heapIndex = getHeapIndex(index);
        Comparable<T> resource = source[index];
        source[index] = null;
        int minIndex = getIndex(length); //获得最小值
        assist[minIndex] = heapIndex; //指向改变
        assist[index] = 0;
        indexHeap[heapIndex] = minIndex;
        length--;
        swim(heapIndex);
        sink(heapIndex);
        return (T) resource;
    }
    public int deleteMin()
    {
        //找到索引，取出元素
        int index = getIndex(1);
        T temp = (T) source[index];
        source[index] = null;
        indexHeap[1] = indexHeap[length--];
        sink(1);
        return index;
    }
    public int getMin()
    {
        //找到索引，取出元素
        int index = getIndex(1);
        return index;
    }
    public T getMinItem()
    {
        //找到索引，取出元素
        int index = getIndex(1);
        T temp = (T) source[index];
        return temp;
    }
    private int getIndex(int heapIndex)
    {
        return indexHeap[heapIndex];
    }
    //根据堆数组寻找原数组的内容
    private Comparable<T> getItem(int heapIndex)
    {
        int index = indexHeap[heapIndex];
        return source[index];
    }
    //根据原数组找堆数组
    private int getHeapIndex(int index)
    {
        return assist[index];
    }
    //堆数组的上浮算法
    private void swim(int heapIndex)
    {
        int father = -1;
        while((father = heapIndex / 2) > 0)
        {
            if(isLess(heapIndex, father))
            {
                change(heapIndex, father);
                heapIndex = father;
            }else {
                break;
            }
        }
    }
    //堆数组的下沉算法
    private void sink(int heapIndex)
    {
        while (heapIndex * 2 <= length)
        {
            int minHeapIndex = -1;
            if(heapIndex * 2 + 1 > length)
            {
                minHeapIndex = heapIndex * 2;
            }else{
                minHeapIndex = isLess(heapIndex * 2,
                        heapIndex * 2 + 1) ? heapIndex * 2 : heapIndex * 2 + 1;
            }
            if(isLess(minHeapIndex, heapIndex))
            {
                change(minHeapIndex, heapIndex);
                heapIndex = minHeapIndex;
            }else{
                break;
            }
        }
    }

    private boolean isLess(int heapIdexPre, int heapIndexPost)
    {
        if(getItem(heapIdexPre) == null)
        {
            return false;
        }
        return getItem(heapIdexPre).compareTo((T) getItem(heapIndexPost)) < 0;
    }
    private void change(int heapIndexPre, int heapIndexPost)
    {
        int indexPre = getIndex(heapIndexPre);
        int indexPost = getIndex(heapIndexPost);
        //1.换heap的值
        int heaptemp = indexHeap[heapIndexPre];
        indexHeap[heapIndexPre] = indexHeap[heapIndexPost];
        indexHeap[heapIndexPost] = heaptemp;
        //2.换assist的值
        int temp = assist[indexPre];
        assist[indexPre] = assist[indexPost];
        assist[indexPost] = temp;
    }
}
