package origin.algorithm.linear.stack.curculate.executor;

import origin.algorithm.linear.stack.curculate.error.ErrorType;

/**
 * @author 原初
 * @create 2022 - 03 - 21
 */
public interface Executor {
    void execute(String assignment);
    boolean isError();
    ErrorType getErrorType();
}
