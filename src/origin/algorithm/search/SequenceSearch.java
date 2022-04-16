package origin.algorithm.search;

/**
 * @author 原初
 * @create 2022 - 04 - 13
 * 顺序查找
 */
public class SequenceSearch<T> implements BaseSearch<T> {
    //顺序查找 最简单的查找
    @Override
    public int find(T item, T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(item))
            {
                return i;
            }
        }
        return -1;
    }


}
