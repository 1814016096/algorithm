package origin.algorithm.linear.stack.curculate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 原初
 * @create 2022 - 03 - 19
 */
public class TransformUtils {
    private static Map<Character, Integer> priority = new HashMap<>();
    public static double getResult(double firstNumber, double secondNumber, Character operator)
    {
        switch (operator)
        {
            case '*':
                return firstNumber * secondNumber;
            case '/':
                return firstNumber / secondNumber;
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
        }
       throw new RuntimeException("输入错误");
    }
    public static void setPriority(char operator, int pri)
    {
        priority.put(operator, pri);
    }
    public static int getPriority(char operator)
    {
        return priority.get(operator);
    }
}
