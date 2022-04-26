package origin.algorithm.kmp;

/**
 * @author 原初
 * @create 2022 - 04 - 22
 */
public class KMP {
    /**
     * 匹配子串的位置
     * @param str
     * @param child
     * @return
     */
    public static int match(String str, String child){
        int[] next = next(child);//求next数列
        for (int i = 0, j = 0; i < str.length();) {
            while (j < child.length() && i < str.length() && str.charAt(i) != child.charAt(j))
            {
                i++;
            }
            while (j < child.length() && i < str.length() && str.charAt(i) == child.charAt(j))
            {
                i++;
                j++;
            }
            if(j == child.length())
            {
                return i - j;
            }else{
                i -= next[j - 1];
                j = j - next[j - 1];
            }
        }
        return -1;
    }
    private static int[] next(String str) //求next的算法
    {
        if(str == null || str.isBlank())
        {
            return null;
        }
        int[] next = new int[str.length()]; //next数组
        next[0] = -1;
        if(str.length() == 1)
        {
            return next;
        }
        for (int i = 2; i < next.length; i++) {
            int pos = i - 1; //获取到最大的前后缀匹配的前缀的最后一个位置
            while(pos > 0 && str.charAt(next[pos]) != str.charAt(i)) //直到相等
            {
                pos = next[pos] - 1;
            }
            if(pos == -1)
            {
                next[i] = 0;
            }else{
                next[i] = next[pos] + 1;
            }
        }
        return next;
    }
}
