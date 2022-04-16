package origin.algorithm.linear.array;

/**
 * @author 原初
 * @create 2022 - 03 - 15
 * 线性表的测试
 */
public class ScqTest {
    public static void main(String[] args) {
        Scquence<Integer> scq = new Scquence<>(1,2,3,5,8,4,1,6,7,9);
        scq.insert(4,9);
        scq.insert(4,9);
        scq.insert(4,9);
        scq.insert(4,9);
        scq.insert(4,9);
        scq.insert(4,9);
        scq.insert(4,9);
//        System.out.println(scq);
        for(var test : scq)
        {
            System.out.println(test);
        }
    }
}
