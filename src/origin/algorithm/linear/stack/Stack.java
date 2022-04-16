package origin.algorithm.linear.stack;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * @author 原初
 * @create 2022 - 03 - 18
 * 虚拟的栈
 */
public interface Stack<T> extends Iterable<T> {
    boolean isEmpty();
    int size();
    T pop(); // 弹栈
    boolean push(T content); //压栈
    T show(); //查看栈顶
    void clear();
}
