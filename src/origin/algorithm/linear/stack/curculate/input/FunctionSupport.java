package origin.algorithm.linear.stack.curculate.input;

import origin.algorithm.linear.array.Scquence;
import origin.algorithm.linear.stack.ArrayStack;
import origin.algorithm.linear.stack.Stack;
import origin.algorithm.linear.stack.curculate.error.CurException;
import origin.algorithm.linear.stack.curculate.error.ErrorType;

import java.util.HashMap;

/**
 * @author 原初
 * @create 2022 - 03 - 21
 * 函数支持和变量支持
 */
public class FunctionSupport {
    // 括号匹配栈
    Stack<Character> backetStack = new ArrayStack<>(100);
    ErrorType errorType = null;
    Exception errorExcpetion = null;
    HashMap<String, Double> variablesMap = new HashMap<>();
    Scquence<String> variablesList = new Scquence<>(100);
    private void CheckAndAdd(String str, int line) // 倒序检测和泵入变量0000000000000000000000000000000000000
    {
        StringBuilder numStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if(c <= 'z' && c >= 'A')
            {
                numStr.append(c);
            }else if(c == ' ')
            {
                continue;
            }else if(c == '='){
                String var = numStr.toString();
                numStr.delete(0, numStr.length() - 1);
                if(!variablesMap.containsKey(var))
                {
                    variablesList.add(var);
                }
                variablesMap.put(var, null); //泵入
            } else{
                throw new CurException("变量命名错误", "line:"+ line +"pos:" + (str.length() - i));
            }
        }
        String var = numStr.toString();
        numStr.delete(0, numStr.length() - 1);
        if(!variablesMap.containsKey(var))
        {
            variablesList.add(var);
        }
        variablesMap.put(var, null); //泵入
    }
}
