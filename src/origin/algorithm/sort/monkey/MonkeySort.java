package origin.algorithm.sort.monkey;

import origin.algorithm.sort.AbstractSort;

import java.util.Random;

/**
 * @author 原初
 * @create 2022 - 03 - 15
 * 猴子排序
 */
public class MonkeySort<T> implements AbstractSort<T> {
    private boolean isSorted(Comparable<T> [] args)
    {
        for (int i = 0; i < args.length - 1; i++) {
            if(isGreat(args[i], args[i + 1]))
            {
                return false;
            }
        }
        return true;
    }
    @Override
    public void sort(Comparable<T>... args) {
        //猴子随机排序
        Random random = new Random();// 随机
        while (!isSorted(args))
        {
            for (int i = 0; i < args.length * 2; i++) {
                int index1 = random.nextInt(args.length);
                int index2 = random.nextInt(args.length);
                exchange(args, index1, index2); //交换
            }
        }
    }
}
