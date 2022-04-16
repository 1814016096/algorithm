package origin.algorithm.simple;

import java.util.Scanner;

/**
 * @author 原初
 * @create 2022 - 03 - 21
 */
public class Passworld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = false;
        while(!isTrue)
        {
            System.out.print("\rpassword>");
            String psw = scanner.next();
            Judge judge = new Judge(psw.length());
            for (int i = 0; i < psw.length(); i++) {
                int num = judge.judge(psw.charAt(i), i);
                if(num == -1)
                {
                    System.out.println("length error");
                    break;
                }
                if(num == -2)
                {
                    continue;
                }
                if(num == 0)
                {
                    isTrue = true;
                    break;
                }
                if((num & 1) == 1)
                {
                    System.out.println("up");
                }
                if((num & 2) == 2)
                {
                    System.out.println("low");
                }if((num & 4) == 4)
                {
                    System.out.println("num");
                }
            }
        }
    }
}
class Judge{
    private int up;
    private int low;
    private int number;
    private int length;

    public Judge(int length) {
        this.length = length;
    }
    public int test(char c)
    {
        int num = 0;
        if(up < 2)
        {
            num |= 1;
        }
        if(low < 3)
        {
            num |= 2;
        }
        if(number <= 0)
        {
            num |= 4;
        }
        return num;
    }
    public int judge(char c, int index) // -1代表直接无效 0 代表正确 1、2、4分别代表上述三种情况没达标,-2代表暂时不行
    {
        if(length < 6)
        {
            return -1;
        }
        if(!Character.isUpperCase(c) && !Character.isLowerCase(c) && !Character.isDigit(c)){
            if(index >= length - 1)
            {
                return -1;
            }else{
                return -2;
            }
        }
        if(Character.isUpperCase(c))
        {
            up++;

        }else if(Character.isLowerCase(c))
        {
            low++;
        }if(Character.isDigit(c))
        {
            number++;
        }
        int num = test(c);
        if(num == 0 || index == length - 1)
        {
            return num;
        }
        return -2;
    }
}