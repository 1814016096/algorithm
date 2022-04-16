package origin.algorithm.linear.sparse;

import origin.algorithm.linear.linked.TwoWayLinkedList;

import java.util.LinkedList;

/**
 * @author 原初
 * @create 2022 - 03 - 21
 * 稀疏数组
 */
public class SpareArrayUtils {
    static class Pos{
        int x;
        int y;

        @Override
        public String toString() {
            return "Pos{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static<T> SpareArray<T> toSpare(T[][] normalArray, T defaultVal)
    {
        TwoWayLinkedList<T> list = new TwoWayLinkedList<>();
        TwoWayLinkedList<Pos> posList = new TwoWayLinkedList<>();
        for (int i = 0; i < normalArray.length; i++) {
            for (int j = 0; j < normalArray[i].length; j++) {
                if(normalArray[i][j] == null || normalArray[i][j].equals(defaultVal))
                {
                    continue;
                }else{
                    list.insert(normalArray[i][j]);
                    Pos pos = new Pos(i, j);
                    posList.insert(pos);
                }
            }
        }
        SpareArray<T> spareArray = new SpareArray<T>(normalArray[0].length, normalArray.length, list.size());
        while (!posList.isEmpty()){
            Pos pos = posList.remove(0);
            T content = list.remove(0);
            spareArray.set(pos.x, pos.y, content);
        }
        return spareArray;
    }
    public static<T> T[][] toNormal(SpareArray<T> array)
    {
        T[][] normal = (T[][] )new Object[array.getHeight()][array.getLength()];
        for (int i = 0; i < array.getCount(); i++)
        {
            normal[array.getInfo(i)[0]][array.getInfo(i)[1]] = array.getContent(i);
        }
        return normal;
    }
}
