package origin.algorithm.sort.quick;

import origin.algorithm.sort.AbstractSort;

/**
 * @author 原初
 * @create 2022 - 03 - 14
 */
public class QuickSort <T> implements AbstractSort<T> {

    @Override
    public void sort(Comparable<T>... args) {
        sort(args, 0, args.length - 1); // 调用具体的排序方法进行排序
    }
    /**
     *   具体的排序算法，涉及到递归，因此不能用原方法
     */
    public void sort(Comparable<T> [] args, int begin, int end)
    {
        if(begin >= end)
        {
            return; //此时只有一个元素，因此不需要排序
        }
        int mid = part(args, begin, end); // 此时的排好的数的所处的索引
        sort(args, begin, mid - 1);//左侧进行排序
        sort(args, mid + 1, end);// 右侧进行排序

    }
    /**
     *   把数组的元素放到合适的位置
     *   使左边的元素都小于原元素，右边的都大于原元素
     */
    private int part(Comparable<T>[] args, int begin, int end)
    {
        //具体放到正确位置的方法：双指针
        int pre = begin;
        int after = end; //两个指针，从前往后
        Comparable<T> value = args[begin]; //最开始的值，且为需要移动的值
        while(pre < after) // 如果没全部遍历完，就不结束
        {
            while(!isGreat(value, args[after]) && pre < after) // 如果后指针指向的值比value大,就一直循环
            {
                after--;
            }
            while(!isGreat(args[pre], value) && pre < after) //如果前值没有value大，就一直循环
            {
                pre++;
            }
            if(pre < after)
            {
                exchange(args, pre, after); //交换不应该处于该位置的两个值
            }
        }
        exchange(args, begin, pre); //交换最开始和需要定位的值
        return pre; // 返回定位之后的值
    }
}
