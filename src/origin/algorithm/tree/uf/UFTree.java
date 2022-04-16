package origin.algorithm.tree.uf;

/**
 * @author 原初
 * @create 2022 - 04 - 03
 * 并查集的树实现
 */
public class UFTree {
    private int[] groupAndIdentify; //分组和标识
    private int count; //分组个数
    public UFTree(int count)
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
        int father1 = groupAndIdentify[oneValue];
        while(father1 != oneValue)
        {
            oneValue = father1;
            father1 = groupAndIdentify[oneValue];
        }
        int father2 = groupAndIdentify[otherValue];
        while(father2 != otherValue)
        {
            otherValue = father2;
            father2 = groupAndIdentify[otherValue];
        }
        return father1 == father2;
    }
    public void union(int oneValue, int otherValue) //两组合并
    {
        if(isConnected(oneValue, otherValue))
        {
            return;
        }
        groupAndIdentify[oneValue] = otherValue; //树
        count--;
    }
}
