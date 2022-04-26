package origin.algorithm.stepboard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 原初
 * @create 2022 - 04 - 25
 * 马踏棋盘算法
 */
public class HorseStepBoard {
    private int step = 1;
    private int[][] board; //棋盘
    public HorseStepBoard(int capacity, int initx, int inity) {
        board = new int[capacity][capacity];
        solve(initx, inity);
    }

    private boolean check(int[][] board, int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        if (x >= board.length || y >= board.length) {
            return false;
        }
        if (board[y][x] != 0) {
            return false;
        }
        return true;
    }

    /**
     * 获取需要遍历的点
     * @return
     */
    private ArrayList<Point> getList(Point point)
    {
        ArrayList<Point> points = new ArrayList<>();
        //走八个方向
        if(check(board, point.x + 2, point.y + 1))
        {
            points.add(new Point(point.x + 2, point.y + 1));
        }
        if(check(board, point.x + 2, point.y - 1))
        {
            points.add(new Point(point.x + 2, point.y - 1));
        }
        if(check(board, point.x + 1, point.y + 2))
        {
            points.add(new Point(point.x + 1, point.y + 2));
        }
        if(check(board, point.x + 1, point.y - 2))
        {
            points.add(new Point(point.x + 1, point.y - 2));
        }
        if(check(board, point.x - 2, point.y + 1))
        {
            points.add(new Point(point.x - 2, point.y + 1));
        }
        if(check(board, point.x - 2, point.y - 1))
        {
            points.add(new Point(point.x - 2, point.y - 1));
        }
        if(check(board, point.x - 1, point.y + 2))
        {
            points.add(new Point(point.x - 1, point.y + 2));
        }
        if(check(board, point.x - 1, point.y - 2))
        {
            points.add(new Point(point.x - 1, point.y - 2));
        }
        return points;
    }
    private void solve(int x, int y) {
        if(board[y][x] != 0)
        {
            return;
        }
        board[y][x] = step++; //代表第几步
        ArrayList<Point> list = getList(new Point(x, y));
        //贪心算法选择下一次要可以走步数最少的来进行优先递归
        Collections.sort(list, (pre, post) -> {
            ArrayList<Point> preList = getList(new Point(pre.x, pre.y)); //前者能遍历到的点
            ArrayList<Point> postList = getList(new Point(post.x, post.y)); //后者能遍历到的点
            return preList.size() - postList.size();
        });
        for (int i = 0; i < list.size(); i++) {
            solve(list.get(i).x, list.get(i).y);
        }
        if(!isSolve())//回溯
        {
            board[y][x] = 0;
            step--;
        }
        return;
    }

    public int[][] getBoard() {
        return board;
    }
    public boolean isSolve()
    {
        return step == board.length * board[0].length + 1;
    }
}
