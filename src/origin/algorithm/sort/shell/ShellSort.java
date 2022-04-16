package origin.algorithm.sort.shell;

import origin.algorithm.sort.AbstractSort;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 原初
 * @create 2022 - 03 - 12
 */
public class ShellSort<T> implements AbstractSort<T> {
    ExecutorService pool; // 线程池
    private void insertSort(Comparable<T>[] args, int begin, int step) // 特定步长下的插入排序
    {
        for (int i = begin; i + step < args.length; i += step) { //从开始位置，每次加步长个值
            Comparable<T> insertObj = args[i + step]; // 下一个元素
            for (int j = i; j >= begin; j -= step) { //j取到索引外的后一个元素，之后与前面有序的元素进行比较
                if(isGreat(insertObj, args[j])) //如果大于
                {
                    break;
                }else{
                    exchange(args, j + step, j); //交换
                }
            }
        }
    }
    private int initShell(Comparable<T>[] args) //计算初始步长
    {
        int step = 1;
        while(step < args.length / 2)
        {
            step = step * 2 + 1;
        }
        return step;
    }
    @Override
    public void sort(Comparable<T>... args){
        // 多线程下的希尔排序
        pool = Executors.newFixedThreadPool(args.length > 15 ? 15 : args.length); //最多15线程
        int step = initShell(args);
        while (step >= 1)
        {
            CountDownLatch count = new CountDownLatch(step); //step次倒计时
            for (int i = 0; i < step; i++) {// 最开始的元素
                int j = i;
                int stepfinal = step;
                pool.execute(() ->{
                    insertSort(args, j, stepfinal); //每个不同的组用不同线程计算
                    count.countDown();
                });
            }
            try {
                count.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            step /= 2;
        }
        pool.shutdown();
    }
}
