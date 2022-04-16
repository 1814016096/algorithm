package origin.algorithm.linear.stack.curculate.error;

/**
 * @author 原初
 * @create 2022 - 03 - 23
 */
public class CurException extends RuntimeException{
    private String position;
    public CurException(String str, String position)
    {
        super(str);
        this.position = position;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + position;
    }
}
