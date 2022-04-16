package origin.algorithm.linear.stack.curculate;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 原初
 * @create 2022 - 03 - 20
 * 带变量的计算器
 */
public class VariableFormulaSupport {
    private HashMap<String, Double> variables = new HashMap<>(); //变量
    Curculate cur = new Curculate(null);
    public enum FormulaStatus{ // 变量的三种状态
        CORRECT,
        UNCERTAIN,
        ERROR
    }
    public void print(String formula)
    {
        cur.setFormula(formula);
        System.out.println(cur.getResult(variables));
    }
    public HashMap<String, Double> getVariables() {
        return variables;
    }
    public int assignmentPos(String formula)
    {
        FormulaStatus formulaStatus = FormulaStatus.CORRECT;
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/' ||(c <= '9' && c >= '0'))
            {
                if(formulaStatus == FormulaStatus.CORRECT)
                {
                    return i;
                }
                return -1;
            }else if(c >= 'A' && c <= 'z'){
                StringBuilder temp = new StringBuilder();
                int count = 0;
                while (c >= 'A' && c <= 'z')
                {
                    temp.append(c);
                    c = formula.charAt(++i);
                    count++;
                }
                --i;

                String str = temp.toString();
                if(variables.containsKey(str))
                {
                    return i -= count;
                }
                formulaStatus = FormulaStatus.UNCERTAIN;
            }else if(c == '=') {
                if(formulaStatus == FormulaStatus.UNCERTAIN)
                {
                    formulaStatus = FormulaStatus.CORRECT;
                }else {
                    return -1;
                }
            }
        }
        return -1;
    }
    public boolean isAssignment(String formula)
    {

        FormulaStatus formulaStatus = FormulaStatus.CORRECT; //需要改进
        ArrayList<String> variablesList = new ArrayList<>();
        boolean isVar = false;
        int varLen = 0;
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/' ||(c <= '9' && c >= '0'))
            {
                if(formulaStatus == FormulaStatus.CORRECT)
                {
                    if(isVar)
                    {
                        i -= varLen;
                    }
                    cur.setFormula(formula.substring(i));
                    double result = cur.getResult(variables);
                    for(var val : variablesList)
                    {
                        variables.put(val, result);
                    }
                    return true;
                }
                return false;
            }else if(c >= 'A' && c <= 'z'){
                StringBuilder temp = new StringBuilder();
                while (i < formula.length() && c >= 'A' && c <= 'z')
                {
                    temp.append(c);
                    c = formula.charAt(++i);
                }
                i--;
                String str = temp.toString();
                if(variables.containsKey(str))
                {
                    formulaStatus = FormulaStatus.CORRECT;
                    isVar = true;
                    varLen = str.length();
                    continue;
                }
                variablesList.add(str);
                variables.put(str, null);
                formulaStatus = FormulaStatus.UNCERTAIN;
            }else if(c == '=') {
                if(formulaStatus == FormulaStatus.UNCERTAIN)
                {
                    formulaStatus = FormulaStatus.CORRECT;
                }else {
                    return false;
                }
            }
        }
        return false;
    }
}
