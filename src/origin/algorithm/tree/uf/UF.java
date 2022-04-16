package origin.algorithm.tree.uf;

/**
 * @author 原初
 * @create 2022 - 04 - 02
 * Union Find 并查集
 */
public class UF {
    private int[] groupAndIdentify; //分组和标识
    private int count; //分组个数
    public UF(int count)
    {
        this.count = count;
        groupAndIdentify = new int[count];
        for (int i = 0; i < count; i++) {
            groupAndIdentify[i] = i; //初始每个都是一组
        }
    }
    public int countNum()
    {
        return count;
    }
    public boolean isConnected(int oneValue, int otherValue)
    {
        return groupAndIdentify[oneValue] == groupAndIdentify[otherValue];
    }
    public void union(int oneValue, int otherValue) //两组合并
    {
        int oneIden = groupAndIdentify[oneValue];
        for (int i = 0; i < groupAndIdentify.length; i++) {
            if(groupAndIdentify[i] == oneIden)
            {
                groupAndIdentify[i] = groupAndIdentify[otherValue];
            }
        }
        count--;
    }
}
