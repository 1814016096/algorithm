package origin.algorithm.linear.linked;

/**
 * @author 原初
 * @create 2022 - 03 - 18
 * 约瑟夫问题的测试
 */
public class JosephTest {
    public static void main(String[] args) {
        CircleTrain circleTrain = new CircleTrain(41, 2);
        System.out.println(circleTrain.getResult());
    }
}
