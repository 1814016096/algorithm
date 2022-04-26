package origin.algorithm.stepboard;

import java.util.Arrays;

/**
 * @author 原初
 * @create 2022 - 04 - 25
 */
public class HorseTest {
    public static void main(String[] args) {
        HorseStepBoard horseStepBoard = new HorseStepBoard(8, 0, 0);
        for (int i = 0; i < horseStepBoard.getBoard().length; i++) {
            System.out.println(Arrays.toString(horseStepBoard.getBoard()[i]));
        }
        System.out.println();
        System.out.println(horseStepBoard.isSolve());
    }
}
