package origin.algorithm.search;

/**
 * @author 原初
 * @create 2022 - 04 - 13
 * 二分查找: 迭代实现
 */
public class BinarySearch<T extends Comparable<T>> implements BaseSearch<T>{
    @Override
    public int find(T item, T... arr) {
        int begin = 0;
        int end = arr.length - 1;
        while(begin < end)
        {
            int mid = begin + (end - begin)/2;
            if(arr[mid].compareTo(item) > 0)
            {
                end = mid - 1;
            }else if(arr[mid].compareTo(item) < 0){
                begin = mid + 1;
            }else{
                return mid;
            }
        }
        if(arr[begin].compareTo(item) == 0)
        {
            return begin;
        }
        return -1;
    }
}
