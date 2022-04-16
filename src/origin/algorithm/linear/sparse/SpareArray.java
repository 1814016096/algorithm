package origin.algorithm.linear.sparse;

/**
 * @author 原初
 * @create 2022 - 03 - 21
 * 稀疏数组
 */
public class SpareArray<T>{
    private int length;
    private int height;
    private int count;
    private int[][] infos;
    private T[] spareArray;
    private int pos = 0;

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getCount() {
        return count;
    }

    public SpareArray(int length, int height, int count) {
        this.length = length;
        this.height = height;
        this.count = count;
        infos = new int[count][2];
        spareArray = (T[])new Object[count];
    }
    public int[] getInfo(int index)
    {
        int[] info = new int[2];
        info[0] = infos[index][0];
        info[1] = infos[index][1];
        return info;
    }
    public T getContent(int index)
    {
        return spareArray[index];
    }
    public void set(int x, int y, T content)
    {
        infos[pos][0] = x;
        infos[pos][1] = y;
        spareArray[pos++] = content;
    }
}
