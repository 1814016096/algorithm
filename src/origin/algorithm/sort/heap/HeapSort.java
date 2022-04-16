package origin.algorithm.sort.heap;

import origin.algorithm.linear.array.Scquence;
import origin.algorithm.sort.AbstractSort;
import origin.algorithm.tree.heap.Heap;

import java.util.Arrays;

/**
 * @author 原初
 * @create 2022 - 03 - 27
 */
public class HeapSort<T> implements AbstractSort<T> {
    private void sink(Comparable<T>[] args, int range) // 0 - range做下沉
    {
        for (int i = range; i > 0; i--) {
            sink(i, args, args.length);
        }
    }
    private void sink(int i, Comparable<T>[] comparables, int limit) //下沉一个, i比索引大一个
    {
        int lChild = i * 2;
        int rChild = i * 2 + 1;
        while(lChild <= limit)
        {
            if(rChild > limit)
            {
                if(isGreat(comparables[i - 1], comparables[lChild - 1]))
                {
                    exchange(comparables,lChild - 1, i - 1);
                }
                break;
            }
            int minIndex = isGreat(comparables[lChild - 1], comparables[rChild - 1]) ? rChild : lChild;
            if(isGreat(comparables[i - 1], comparables[minIndex - 1]))
            {
                exchange(comparables,minIndex - 1, i - 1);
            }
            i = minIndex;
            lChild = i * 2;
            rChild = i * 2 + 1;
        }
    }
    private Comparable<T> delMin(Comparable<T>[] args, int count) //删掉最大元素
    {
        Comparable<T> temp = args[0];
        Comparable<T> first = args[count];
        args[count] = null;
        args[0] = first;
        sink(1, args, count);
        return temp;
    }
    private void sort(Comparable<T>[] args, Comparable<T>[] sogfted) //排序
    {
        int count = args.length;
        while (count > 0)
        {
            sogfted[sogfted.length - count] = delMin(args ,--count);
        }
    }
    @Override
    public void sort(Comparable<T>... args) {
        //args就可以看成一个堆
//        Scquence<Comparable<T>> ts = new Scquence(args);
        int maxSort = args.length / 2; //最大的分支结点
        sink(args, maxSort);
        Comparable<T>[] softArrs = new Comparable[args.length];
        sort(args, softArrs);
        for (int i = 0; i < softArrs.length; i++) {
            args[i] = softArrs[i];
        }
        return;
    }
}
