package origin.algorithm.sort;

/**
 * @author 原初
 * @create 2022 - 03 - 11
 */
public interface AbstractSort<T>{
    void sort(Comparable<T> ... args);
    default boolean isGreat(Comparable first, Comparable second)
    {
        return first.compareTo(second) > 0;
    }
    default void exchange(Comparable<T>[] args, int i, int j)
    {
        Comparable<T> temp = args[i];
        args[i] = args[j];
        args[j] = temp;
    }
}
