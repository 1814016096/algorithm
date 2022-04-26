package origin.algorithm.graph.floyd;

import java.util.Arrays;

/**
 * @author 原初
 * @create 2022 - 04 - 24
 * 二维数组无向图
 */
public class ArrayGraph {
    private int[][] weight; //内容代表权(-1代表没有直接相邻)
    private int[][] side; //代表横轴代表点的前面的一个点

    public int[][] getWeight() {
        return weight;
    }

    public int[][] getSide() {
        return side;
    }

    public ArrayGraph(int[][] weight)
    {
        this.weight = weight;
        this.side = new int[weight.length][weight[0].length];
        //初始化
        for (int i = 0; i < this.side.length; i++) {
            for (int j = 0; j < this.side[i].length; j++) {
                side[i][j] = i;
            }
        }
    }
    public void show(){
        for (int i = 0; i < weight.length; i++) {
            System.out.println(Arrays.toString(weight[i]));
        }
        System.out.println();
        for (int i = 0; i < side.length; i++) {
            System.out.println(Arrays.toString(side[i]));
        }
    }
}
