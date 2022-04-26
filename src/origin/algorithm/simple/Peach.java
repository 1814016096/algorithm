package origin.algorithm.simple;

/**
 * @author 原初
 * @create 2022 - 04 - 19
 */
public class Peach {
    /**
     * 第n天的桃子数量
     */
    public static int getPeach(int day, int lastDay)
    {
        //如果到了最后一天
        if(day == lastDay)
        {
            //全部吃完
            return 0;
        }
        //这一天是后一天桃子数量的一个多两倍
        return (getPeach(day + 1, lastDay) + 1) * 2;
    }
}
