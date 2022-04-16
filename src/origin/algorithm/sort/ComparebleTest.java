package origin.algorithm.sort;

/**
 * @author 原初
 * @create 2022 - 03 - 11
 */
public class ComparebleTest implements Comparable<ComparebleTest>{
    int num;

    public ComparebleTest() {
    }

    public ComparebleTest(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ComparebleTest{" +
                "num=" + num +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(ComparebleTest o) {
        //这样
        return this.num - o.num;
    }
}
