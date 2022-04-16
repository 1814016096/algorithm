package origin.algorithm.search;

import java.util.ArrayList;

/**
 * @author 原初
 * @create 2022 - 04 - 13
 * 查找的接口
 */
public interface BaseSearch<T>{
    int find(T item, T ... arr);
    default ArrayList<Integer> findAll(T item, T ... arr)
    {
        int index = find(item, arr);
        ArrayList<Integer> arrIndex = new ArrayList<>();
        for (int i = index - 1; i >= 0; i--) {
            if(arr[i].equals(item))
            {
                arrIndex.add(i);
            }else{
                break;
            }
        }
        if(index >= 0)
        {
            arrIndex.add(index);
        }else{
            return null;
        }
        for (int i = index + 1; i < arr.length; i++) {
            if(arr[i].equals(item))
            {
                arrIndex.add(i);
            }else{
                break;
            }
        }
        return arrIndex;
    }
}
