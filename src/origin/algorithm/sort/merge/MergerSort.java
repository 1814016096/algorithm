package origin.algorithm.sort.merge;

import origin.algorithm.sort.AbstractSort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author 原初
 * @create 2022 - 03 - 13
 */
public class MergerSort <T> implements AbstractSort<T>{
    Comparable<T>[] assit;
    ForkJoinPool pool = new ForkJoinPool(); //cpu密集型线程池
    @Override
    public void sort(Comparable<T>... args) {
        assit = new Comparable[args.length]; //建立数组
        sort(args, 0, args.length - 1); // 全部排序
    }

    private void sort(Comparable<T> [] args, int begin, int end)
    {
        // 拆分并合并
        if(begin >= end)
        {
            return; //如果索引相同或倒置，则结束
        }
        int mid = begin + (end - begin) / 2; //防止溢出
        ForkJoinTask<?> part1 = pool.submit(() -> {
            sort(args, begin, mid);
        });
        ForkJoinTask<?> part2 = pool.submit(() -> {
            sort(args, mid + 1, end); //两次排序，相对于只剩一个的时候即为排序结束
        });
        part1.join();
        part2.join(); //多线程工作
        ForkJoinTask<?> merge = pool.submit(() -> {
            merge(args, begin, mid, end); //合并
        });
        merge.join();
    }
    private void merge(Comparable<T>[] args, int begin, int mid, int end)
    {
        //合并两个数组
        //双指针法
        int initbegin = begin;
        int assistpos = begin; //辅助数组的初始位置
        int initmid = mid;
        mid++;
        while(begin <= initmid || mid <= end)
        {
            if(begin > initmid)
            {
                assit[assistpos++] = args[mid++];
                continue;
            }
            if(mid > end)
            {
                assit[assistpos++] = args[begin++];
                continue;
            }
            if(!isGreat(args[begin], args[mid])) //如果没越界且更小
            {
                assit[assistpos++] = args[begin++];
            }else{
                assit[assistpos++] = args[mid++];
            }
        }
        for (int i = initbegin; i <= end; i++) {
            args[i] = assit[i];
        }
    }
}
