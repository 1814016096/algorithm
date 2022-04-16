package origin.algorithm.simple;

/**
 * @author 原初
 * @create 2022 - 04 - 03
 */
public class Single {
    private static Single obj;
    private Single(){}
    public static Single get()
    {
        if(obj == null)
        {
            obj = new Single();
        }
        return obj;
    }
}
