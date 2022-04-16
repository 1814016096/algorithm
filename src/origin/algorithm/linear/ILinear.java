package origin.algorithm.linear;

/**
 * @author 原初
 * @create 2022 - 03 - 16
 * 抽象线性表接口
 *
 */
public interface ILinear<T> extends Iterable<T>{
    void insert(T value);
    void insert(int index, T value);
    T get(int index);
    T remove(int index);
    void clear();
    boolean isEmpty();
    int size();
}
