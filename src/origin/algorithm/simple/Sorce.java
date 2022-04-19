package origin.algorithm.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author 原初
 * @create 2022 - 04 - 16
 */
public class Sorce {
//    private double maxVal = Double.NEGATIVE_INFINITY;
//    private int maxPos = -1; //最高分的位置和最低分的位置
//    private double minVal = Double.POSITIVE_INFINITY;
//    private int minPos = - 1; //最低分的位置和最低分的位置
    private ArrayList<Double> allSorces;
    /**
     * 参与打分的人数
     * @param count
     */
    public void input(int count)
    {
        allSorces = new ArrayList<>(count);
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            Double sorce = Double.valueOf(scanner.next());
            allSorces.add(sorce);
//            if(maxVal < sorce)
//            {
//                maxPos = allSorces.size() - 1;
//                maxVal = sorce;
//            }
//            if(minVal > sorce) {
//                minPos = allSorces.size() - 1;
//                minVal = sorce;
//            }
        }
    }
    public double getMax()
    {
        return Collections.max(allSorces);
    }
    public double getMin()
    {
        return Collections.min(allSorces);
    }
    public double getAvg()
    {
        double sum = 0;
        boolean max = false;
        boolean min = false;
        for (Double score : allSorces) {
            if(!max && score.equals(getMax())){
                max = true;
                continue;
            }
            if(!min && score.equals(getMin())){
                min = true;
                continue;
            }
            sum += score;
        }
        return sum/(allSorces.size() - 2);
    }
}
