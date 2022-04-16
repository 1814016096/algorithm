package origin.algorithm.linear.stack.curculate.input;

import origin.algorithm.linear.stack.curculate.VariableFormulaSupport;
import origin.algorithm.linear.stack.curculate.error.ErrorType;
import origin.algorithm.linear.stack.curculate.executor.Executor;

/**
 * @author 原初
 * @create 2022 - 03 - 21
 */
public class RunExecutor implements Executor {
    VariableFormulaSupport var = new VariableFormulaSupport();


    @Override
    public void execute(String assignment) {
        if(assignment.charAt(0) == '(')
        {
            var.print(assignment.substring(1, assignment.length() - 1));
        }else{
            if(var.assignmentPos(assignment) != -1)
            {
                var.isAssignment(assignment);
            }
        }
    }

    @Override
    public boolean isError() {
        return false;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }
}
