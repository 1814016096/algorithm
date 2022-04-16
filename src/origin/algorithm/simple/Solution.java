package origin.algorithm.simple;

import java.util.LinkedHashMap;

public class Solution {
    static LinkedHashMap<Integer, String> map;

    static {
        map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(4, "IV");
        map.put(1, "I");
        map.put(5, "V");
    }


    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        for (var set : map.entrySet()) {
            while(num - set.getKey() >= 0)
            {
                builder.append(set.getValue());
                num -= set.getKey();
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(9));
    }
}