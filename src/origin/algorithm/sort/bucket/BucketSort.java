package origin.algorithm.sort.bucket;

import origin.algorithm.sort.AbstractSort;
import origin.algorithm.sort.pojo.Dividable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 原初
 * @create 2022 - 03 - 15
 * 桶排序
 */
public class BucketSort <T> implements AbstractSort<T>{
    AbstractSort<T> sortor; // 桶中的排序方式
    public BucketSort(AbstractSort<T> sortor)
    {
        this.sortor = sortor;
    }
    private int getValue(Comparable<T> arg) //获得数值
    {
        if(arg instanceof Number) // 数值类型
        {
            return ((Number)arg).intValue();
        }
        if(arg instanceof Dividable)
        {
            return ((Dividable)arg).getDivide(); //获取细分值
        }
        throw new RuntimeException("无法细分");
    }
    private int[] getExtreme(Comparable<T>[] args)// 获取极值
    {
        int max = getValue(args[0]);
        int min = getValue(args[0]);
        int [] extrValue = new int[2]; // 最小值第一个，最大值第二个
        for(var value : args)
        {
            int intValue = getValue(value);
            if(isGreat(intValue, max))
            {
                max = intValue;
            }
            if(isGreat(min, intValue))
            {
                min = intValue;
            }
        }
        extrValue[0] = min;
        extrValue[1] = max;
        return extrValue;
    }
    @Override
    public void sort(Comparable<T>... args) {
        int[] extreme = getExtreme(args);
        LinkedList<Comparable<T>> [] buckets = new LinkedList[(extreme[1] - extreme[0])/2 + 1];// 桶
        for (int i = 0; i < args.length; i++) {
            int pos = (getValue(args[i]) - extreme[0])/2; //如此定位
            if(buckets[pos] == null)
            {
                buckets[pos] = new LinkedList<Comparable<T>>(); //延迟创建
            }
            buckets[pos].addLast(args[i]);
        }
        // 对每个桶进行排序
        int count = 0;
        for(var bucket : buckets)
        {
            if(bucket != null)
            {
                Comparable<T>[] temp = new Comparable[bucket.size()];
                bucket.toArray(temp);
                sortor.sort(temp);
                for (int i = count; i < count + temp.length; i++) {
                    args[i] = temp[i - count]; //赋值
                }
                count += temp.length;
            }
        }
    }
}
