package origin.algorithm.tree.uf;

/**
 * @author 原初
 * @create 2022 - 04 - 03
 * 对UF的进一步优化
 */
public class UFTreeWeight {
    private int[] groupAndIdentify; //分组和标识
    private int count; //分组个数
    private int[] size; //大小
    public UFTreeWeight(int count)
    {
        this.count = count;
        groupAndIdentify = new int[count];
        for (int i = 0; i < count; i++) {
            groupAndIdentify[i] = i; //初始每个都是一组
        }
        size = new int[count];
    }
    public int countNum()
    {
        return count;
    }
    public int find(int value)
    {
        int father = groupAndIdentify[value];
        while(father != value)
        {
            value = father;
            father = groupAndIdentify[value];
        }
        return father;
    }
    public boolean isConnected(int oneValue, int otherValue)
    {
        int r1 = find(oneValue);
        int r2 = find(otherValue);
        return r1 == r2;
    }
    public void union(int oneValue, int otherValue) //两组合并
    {
        int root1 = find(oneValue);
        int root2 = find(otherValue);
        if(root1 == root2)
        {
            return;
        }
        if(size[root1] > size[root2])
        {
            groupAndIdentify[root2] = root1;
            size[root1] += size[root2] + 1;
        }else{
            groupAndIdentify[root1] = root2;
            size[root2] += size[root1] + 1;
        }
        count--;
    }
}
