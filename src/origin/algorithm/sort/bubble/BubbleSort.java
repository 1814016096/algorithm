package origin.algorithm.sort.bubble;

import origin.algorithm.sort.AbstractSort;

/**
 * @author 原初
 * @create 2022 - 03 - 11
 * 冒泡排序
 */
public class BubbleSort<T> implements AbstractSort<T> {
    @Override
    public void sort(Comparable<T>... args) {
        for (int i = args.length - 1; i > 0; i--) { // 第一层循环代表要比较次数的最大索引(第一次最大索引是长度减一)
            for (int j = 0; j < i - 1; j++) {// (第二层循环代表从第一个到最后一个的每次比较（-1是因为j+1）)
                if(isGreat(args[j], args[j + 1]))
                {
                    exchange(args, j, j + 1);
                }
            }
        }
    }
}
