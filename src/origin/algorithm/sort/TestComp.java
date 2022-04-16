package origin.algorithm.sort;

/**
 * @author 原初
 * @create 2022 - 03 - 11
 */
public class TestComp {
    public static Comparable getMax(Comparable t1, Comparable t2, Comparable ... args)
    {
        Comparable test = t1.compareTo(t2) >= 0 ? t1 : t2;
        if(args != null)
        {
            for(var vari : args)
            {
                if(test.compareTo(vari) < 0)
                {
                    test = vari;
                }
            }
        }
        return test;
    }

    public static void main(String[] args) {
        System.out.println(getMax(new ComparebleTest(10), new ComparebleTest(20), new ComparebleTest(30)));
    }
}
