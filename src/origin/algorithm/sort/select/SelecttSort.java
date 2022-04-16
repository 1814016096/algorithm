package origin.algorithm.sort.select;

import origin.algorithm.sort.AbstractSort;

/**
 * @author 原初
 * @create 2022 - 03 - 11
 * 选择排序
 */
public class SelecttSort<T> implements AbstractSort<T> {
    @Override
    public void sort(Comparable<T>... args) {
        //选择排序
        for (int i = args.length - 1; i > 0; i--) {
            int max = 0;
            for (int j = 0; j < i + 1; j++) {
                if(!isGreat(args[max], args[j]))
                {
                    max = j; // 更改位置
                }
            }
            exchange(args, i, max); // 交换位置
        }
    }
}
