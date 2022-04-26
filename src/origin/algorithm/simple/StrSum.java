package origin.algorithm.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * @author 
 * @create 2022 - 04 - 
 * 字符统计
 */
public class StrSum {
    public static<T> void sum(Consumer<Map.Entry<T, Integer>> consumer, T ... context){
        HashMap<T, Integer> map = new HashMap<>();
        for (T t : context) {
            if(map.containsKey(t))
            {
                map.put(t, map.get(t) + 1);
            }else{
                map.put(t, 1);
            }
        }
        for (Map.Entry<T, Integer> t : map.entrySet()) {
            consumer.accept(t);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        sum(new Consumer<Map.Entry<Integer, Integer>>() {
            @Override
            public void accept(Map.Entry<Integer, Integer> integerEntry) {
                if(integerEntry.getValue() > 1)
                {
                    arr.add(integerEntry.getKey());
                }
            }
        }, 1, 1, 2, 3, 4, 5, 7, 7, 5, 5);
        System.out.println(arr);
    }
}
