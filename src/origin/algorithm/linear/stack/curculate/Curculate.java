package origin.algorithm.linear.stack.curculate;

import origin.algorithm.linear.stack.ArrayStack;
import origin.algorithm.linear.stack.Stack;

import java.util.List;
import java.util.Map;

/**
 * @author 原初
 * @create 2022 - 03 - 19
 * 栈实现计算器
 */
public class Curculate {
    private Stack<Double> numberStack = new ArrayStack<>(1000); // 数字栈
    private Stack<Character> operatorStack = new ArrayStack<>(100); //符号栈
    private String formula;


    public void setFormula(String formula) {

        this.formula = formula;
    }

    public Curculate(String formula)
    {
        TransformUtils.setPriority(')', 100);
        TransformUtils.setPriority('+', 0);
        TransformUtils.setPriority('-', 0);
        TransformUtils.setPriority('(', -1);
        TransformUtils.setPriority('*', 1);
        TransformUtils.setPriority('/', 1); //设置优先级
        this.formula = formula;
    }

    public double getResult(Map<String, Double> variables)
    {
        char [] strList = formula.toCharArray();
        int pointer = 0; //指针
        String number = "";
        for(int i = 0; i < strList.length; i++)
        {
            // 提取数字
            char val =  strList[i];
            if(val == ' ')
            {
                continue;
            }
            if(val <= 'z' && val >= 'A')
            {
                StringBuilder temp = new StringBuilder();
                while (i < formula.length() && formula.charAt(i) >= 'A' && formula.charAt(i) <= 'z')
                {
                    val = formula.charAt(i);
                    temp.append(val);
                    i++;
                }
                i--;
                String str = temp.toString();
                numberStack.push(variables.get(str));
                continue;
            }
            if((val <= '9' && val >= '0') || (val == '.' && !"".equals(number)))
            {
                number += val;
            }else{
                if(!"".equals(number))
                {
                    double num = Double.parseDouble(number);
                    numberStack.push(num);
                    number = "";
                }
                if(val == '(')
                {
                    operatorStack.push(val);
                    continue;
                }
                if(operatorStack.isEmpty())
                {
                    operatorStack.push(val);
                }else{
                    if(TransformUtils.getPriority(val) > TransformUtils.getPriority(operatorStack.show()))
                    {
                        boolean isRBacket = false;
                        isRBacket = val == ')';
                        while (isRBacket)
                        {
                            Character operator = operatorStack.pop();
                            if(operator == '(')
                            {
                                break;
                            }
                            double first = numberStack.pop();
                            double second = numberStack.pop();
                            numberStack.push(TransformUtils.getResult(second, first, operator));//计算并压栈
                        }
                        if(!isRBacket)
                        {
                            operatorStack.push(val); //放置
                        }
                    }else {

//                        isRBacket = operatorStack.show() == ')';


                        Character operator = operatorStack.pop();
                        double first = numberStack.pop();
                        double second = numberStack.pop();
                        numberStack.push(TransformUtils.getResult(second, first, operator));

                        operatorStack.push(val);
                        continue;
                    }
                }
                number = "";
            }
        }
        int i = 0;
        if(!"".equals(number))
        {
            double num = Double.parseDouble(number);
            numberStack.push(num);
            number = "";
        }
        while(numberStack.size() != 1)
        {
            Character operator = operatorStack.pop();
            if(operator == ')')
            {
                continue;
            }
            double first = numberStack.pop();
            double second = numberStack.pop();

            numberStack.push(TransformUtils.getResult(second, first, operator));//计算并压栈
        }
        double result = numberStack.pop();
        return result;
    }

    public double getResult() {
        char [] strList = formula.toCharArray();
        int pointer = 0; //指针
        String number = "";
        for(char val : strList)
        {
            // 提取数字
            if(val == ' ')
            {
                continue;
            }
            if((val <= '9' && val >= '0') || (val == '.' && !"".equals(number)))
            {
                number += val;
            }else{
                if(!"".equals(number))
                {
                    double num = Double.parseDouble(number);
                    numberStack.push(num);
                    number = "";
                }
                if(val == '(')
                {
                    operatorStack.push(val);
                    continue;
                }
                if(operatorStack.isEmpty())
                {
                    operatorStack.push(val);
                }else{
                    if(TransformUtils.getPriority(val) > TransformUtils.getPriority(operatorStack.show()))
                    {
                        boolean isRBacket = false;
                        isRBacket = val == ')';
                        while (isRBacket)
                        {
                            Character operator = operatorStack.pop();
                            if(operator == '(')
                            {
                                break;
                            }
                            double first = numberStack.pop();
                            double second = numberStack.pop();
                            numberStack.push(TransformUtils.getResult(second, first, operator));//计算并压栈
                        }
                        if(!isRBacket)
                        {
                            operatorStack.push(val); //放置
                        }
                    }else {

//                        isRBacket = operatorStack.show() == ')';


                            Character operator = operatorStack.pop();
                            double first = numberStack.pop();
                            double second = numberStack.pop();
                            numberStack.push(TransformUtils.getResult(second, first, operator));

                        operatorStack.push(val);
                        continue;
                    }
                }
                number = "";
            }
        }
        int i = 0;
        if(!"".equals(number))
        {
            double num = Double.parseDouble(number);
            numberStack.push(num);
            number = "";
        }
        while(numberStack.size() != 1)
        {
            Character operator = operatorStack.pop();
            if(operator == ')')
            {
                continue;
            }
            double first = numberStack.pop();
            double second = numberStack.pop();

            numberStack.push(TransformUtils.getResult(second, first, operator));//计算并压栈
        }
        double result = numberStack.pop();
        return result;
    }
    private static String transform(int begin, char[] fomula) // 需要大改
    {
        String number = "";
        Stack<Character> operatorStack = new ArrayStack<>(100);
        Stack<String> tempStack = new ArrayStack<>(200);
        for (int i = begin; i < fomula.length; i++) {
            if(fomula[i] == '(')
            {
                operatorStack.push('(');
                continue;
            }
            if(fomula[i] == ' ')
            {
                continue;
            }
            if(fomula[i] == ')')
            {
                if(!"".equals(number))
                {
                    double num = Double.parseDouble(number);
                    tempStack.push(num + "");
                    number = "";
                }
                while(!operatorStack.isEmpty() && operatorStack.show() != '(')
                {
                    tempStack.push(operatorStack.pop() + "");
                }
                if(!operatorStack.isEmpty())
                {
                    operatorStack.pop(); //泵出(
                }
                continue;
            }
            if((fomula[i] <= '9' && fomula[i] >= '0') || (fomula[i] == '.' && !"".equals(number))) {
                number += fomula[i];
            }else{
                if(!"".equals(number))
                {
                    double num = Double.parseDouble(number);
                    tempStack.push(num + "|");
                    number = "";
                }
                if(operatorStack.isEmpty())
                {
                    operatorStack.push(fomula[i]);
                }else{
                    if(TransformUtils.getPriority(fomula[i]) >
                            TransformUtils.getPriority(operatorStack.show()))
                    {
                        operatorStack.push(fomula[i]); //入栈
                    }else{
                        while(!operatorStack.isEmpty() && operatorStack.show() != '(' && TransformUtils.getPriority(fomula[i]) <=
                                TransformUtils.getPriority(operatorStack.show()))
                        {
                            tempStack.push(operatorStack.pop() + "|");
                        }
                        operatorStack.push(fomula[i]);
                    }
                }
            }
        }
        if(!"".equals(number))
        {
            double num = Double.parseDouble(number);
            tempStack.push(num + "|");
            number = "";
        }
        while(!operatorStack.isEmpty())
        {
            tempStack.push(operatorStack.pop() + "");
        }
        StringBuilder result = new StringBuilder();
        Stack<String> tempStackTemp = new ArrayStack<>(200);
        while(!tempStack.isEmpty())
        {
            tempStackTemp.push(tempStack.pop()); //反转
        }
        while (!tempStackTemp.isEmpty())
        {
            String popitem = tempStackTemp.pop();
            if(popitem.equals("+") || popitem.equals("-") || popitem.equals("*") || popitem.equals("/"))
            {
                result.append(popitem + "|");
            }else{
                result.append(popitem);
            }
        }
        return result.toString();
    }
    public String transform() //转换为逆波兰表达式
    {
        char[] fomula = this.formula.toCharArray();

        return transform(0, fomula);
    }
}
