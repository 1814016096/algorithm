package origin.algorithm.recursion;

import java.util.Arrays;

/**
 * @author 原初
 * @create 2022 - 03 - 22
 * 八皇后问题
 */
public class EightQueens {
    private int [][] result; //题解，每一列代表一个结果
    private int count = 0;
    private int [] tempResult = new int[8];

    public int getCount() {
        return count;
    }

    public int[][] getResult() {
        return result;
    }

    public EightQueens()
    {
        result = new int[100][8]; //每一行代表一次回溯成功
    }
    private boolean canSettle(int one, int other) //是否会冲突 ,第几个解决方案
    {
        if(tempResult[other] == tempResult[one])
        {
            return false;
        }
        int posx = tempResult[other];
        int posy = other;
        int x = tempResult[one];
        int y = one;
        while (x < 8 && y < 8)
        {
            if(x == posx && y == posy)
            {
                return false;
            }
            x++;
            y++;
        }
        x = tempResult[one];
        y = one;
        while(x < 8 && y >= 0)
        {
            if(x == posx && y == posy)
            {
                return false;
            }
            x++;
            y--;
        }
        x = tempResult[one];
        y = one;
        while(x >= 0 && y >= 0)
        {
            if(x == posx && y == posy)
            {
                return false;
            }
            x--;
            y--;
        }
        x = tempResult[one];
        y = one;
        while(x >= 0 && y < 8)
        {
            if(x == posx && y == posy)
            {
                return false;
            }
            x--;
            y++;
        }// 判断四角
        return true;
    }
    public void solve(int count) //第几个皇后 是否可以放置
    {
        if(count >= 8) //边界条件
        {
            result[this.count++] = Arrays.copyOf(tempResult, tempResult.length);
            return;
        }
        if(count == 0)
        {
            for (int i = 0; i < 8; i++) {
                tempResult[0] = i;
                solve(1);
            }
            return;
        }
        boolean canSettle = true;
        for (int j = 0; j < 8; j++) {
            tempResult[count] = j;
            for (int i = 0; i < count; i++) {
                canSettle = canSettle(i, count);
                if(!canSettle)
                {
                    break;
                }
            }
            if(canSettle)
            {
                solve(count + 1);
            }
        }
        tempResult[count] = 0;
    }
}
