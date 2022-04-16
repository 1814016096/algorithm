package origin.algorithm.linear.stack.curculate;

/**
 * @author 原初
 * @create 2022 - 03 - 20
 */
public class VariableTest {
    public static void main(String[] args) {
        VariableFormulaSupport support = new VariableFormulaSupport();
//        System.out.println(support.isAssignment("axx= t= 1000 + 100*(3000)"));
//        System.out.println(support.isAssignment("x = 1 + axx"));
//        System.out.println(support.isAssignment("c - y = 1"));
//        System.out.println(support.isAssignment("1"));
//        System.out.println(support.assignmentPos("a=c=1"));
        support.isAssignment("axx= t= 1000 + 100*(3000)");
        support.print("axx + 5 * t");
//        System.out.println(support.getVariables());
    }
}
