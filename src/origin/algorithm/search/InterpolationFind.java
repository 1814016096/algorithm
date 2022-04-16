package origin.algorithm.search;

/**
 * @author 原初
 * @create 2022 - 04 - 14
 * 插值查找
 */
public class InterpolationFind<T extends Comparable<T>> implements BaseSearch<T>{
    @Override
    public int find(T item, T... arr) {
        int begin = 0;
        int end = arr.length - 1;
        while(begin < end)
        {
            int pos = begin + (end - begin)*(item.compareTo(arr[begin])/arr[end].compareTo(arr[begin]));
            if(pos > end)
            {
                return -1;
            }
            if(arr[pos].compareTo(item) > 0)
            {
                end = pos - 1;
            }else if(arr[pos].compareTo(item) < 0){
                begin = pos + 1;
            }else{
                return pos;
            }
        }
        if(begin > end)
        {
            return -1;
        }
        if(arr[begin].compareTo(item) == 0)
        {
            return begin;
        }
        return -1;
    }
}
