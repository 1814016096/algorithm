package origin.algorithm.sort.insert;

import origin.algorithm.sort.AbstractSort;

/**
 * @author 原初
 * @create 2022 - 03 - 12
 * 插入排序
 */
public class InsertSort <T> implements AbstractSort<T> {
    @Override
    public void sort(Comparable<T>... args) {
        for (int i = 0; i < args.length - 1; i++) { //维持的索引处于的位置
            Comparable<T> insertObj = args[i + 1]; // 要插入的对象
            for (int j = i; j >= 0; j--) { //一直遍历到0
                if(isGreat(insertObj, args[j])) {
                    break; // 如果大了，就停
                }else {
                    exchange(args, j, j + 1); //否则就交换
                }
            }
        }
    }
}
