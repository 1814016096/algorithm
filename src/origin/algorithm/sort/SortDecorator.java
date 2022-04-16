package origin.algorithm.sort;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author 原初
 * @create 2022 - 03 - 11
 */
public class SortDecorator<T>{
    private AbstractSort<T> content;

    public SortDecorator(AbstractSort<T> content) {
        this.content = content;
    }
    public List<T> sort(boolean isPositive, Comparable<T>... args)
    {
        content.sort(args);
        List temp = Arrays.asList(args);
        if(!isPositive)
        {
            Collections.reverse(temp);
        }
        return temp;
    }

}
