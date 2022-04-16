package origin.algorithm.recursion;

/**
 * @author 原初
 * @create 2022 - 03 - 22
 */
public class MazeTest {
    public static void main(String[] args) {
        Maze maze = new Maze(25);
        System.out.println(maze.search(1, 1)); //从最开始找
        maze.print();
    }
}
