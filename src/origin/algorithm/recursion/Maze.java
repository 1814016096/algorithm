package origin.algorithm.recursion;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 原初
 * @create 2022 - 03 - 22
 * 递归解决迷宫问题
 * 规定 : 0 代表地面 1 代表墙 2代表走过 3代表不通
 */
public class Maze {
    int resultX;
    int resultY;
    int[][] maze;
    public Maze(int wallnum) // 生成迷宫
    {
        Random random = new Random();
        maze = new int[10][10]; //10 x 10迷宫
        resultX = random.nextInt(8) + 1;
        resultY = random.nextInt(8) + 1;
        for (int i = 0; i < wallnum; i++) {
            maze[random.nextInt(8) +1][random.nextInt(8) +1] = 1; // 随机生成十个墙壁
        }
        for (int i = 0; i < 10; i++) {
            maze[0][i] = 1;
            maze[9][i] = 1; //四周的墙壁
        }
        for (int i = 0; i < 10; i++) {
            maze[i][0] = 1;
            maze[i][9] = 1; //四周的墙壁
        }
    }
    public Maze() // 生成迷宫
    {
        Random random = new Random();
        maze = new int[10][10]; //10 x 10迷宫
        resultX = random.nextInt(8) + 1;
        resultY = random.nextInt(8) + 1;
        for (int i = 0; i < 10; i++) {
            maze[random.nextInt(8) +1][random.nextInt(8) +1] = 1; // 随机生成十个墙壁
        }
        for (int i = 0; i < 10; i++) {
            maze[0][i] = 1;
            maze[9][i] = 1; //四周的墙壁
        }
        for (int i = 0; i < 10; i++) {
            maze[i][0] = 1;
            maze[i][9] = 1; //四周的墙壁
        }
    }
    public void print()
    {
        System.out.println("x=" + resultX + " y=" + resultY);
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(maze[i]));
        }
    }
    public boolean search(int beginX, int beginY) //开始的位置
    {
        if (beginX == resultX && beginY == resultY)
        {
            maze[resultY][resultX] = 2;
            return true; //这是走通了
        }
        if(maze[beginY][beginX] == 0)
        {
            maze[beginY][beginX] = 2; //表示走过
            if(search(beginX, beginY + 1)) //先向下走
            {
                return true; //走通了自然返回true
            }else if(search(beginX + 1, beginY)) //向右
            {
                return true;
            }else if(search(beginX, beginY - 1)) //向上
            {
                return true;
            }else if(search(beginX - 1, beginY))
            {
                return true; //向左
            }else{
                maze[beginY][beginX] = 3; //都没走通
                return false;
            }
        }else{ //无论是墙，还是走过的路，还是走不通的路，都应该返回
            return false;
        }
    }

}
