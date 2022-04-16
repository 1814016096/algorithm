package origin.algorithm.sort.shell;

import origin.algorithm.sort.SortDecorator;
import origin.algorithm.sort.insert.InsertSort;
import origin.algorithm.sort.merge.MergerSort;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 原初
 * @create 2022 - 03 - 12
 */
public class ShellTest {
    static ArrayList<Integer> getArray() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        String inner;
        ArrayList<Integer> arr = new ArrayList<>();
        while((inner = reader.readLine()) != null)
        {
            arr.add(Integer.parseInt(inner));
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        test2();
    }
    public static void test2() throws IOException {
        SortDecorator<Integer> sortor = new SortDecorator<>(new ShellSort<>());
        long begin;
        ArrayList<Integer> array = getArray();
        Integer[] integers = new Integer[array.size()];
        array.toArray(integers);
        begin = System.currentTimeMillis();
        sortor.sort(true, integers);
        System.out.println(System.currentTimeMillis() - begin); // 获取间隔

        array = getArray(); //希尔和归并
        array.toArray(integers);
        SortDecorator<Integer> soteor1 = new SortDecorator<>(new MergerSort<>());
        begin = System.currentTimeMillis();
        soteor1.sort(true, integers);
        System.out.println(System.currentTimeMillis() - begin); // 获取间隔

    }
    public static void test1() throws IOException {
        SortDecorator<Integer> sortor = new SortDecorator<>(new ShellSort<>());
        long begin;
        ArrayList<Integer> array = getArray();
        Integer[] integers = new Integer[array.size()];
        array.toArray(integers);
        begin = System.currentTimeMillis();
        sortor.sort(true, integers);
        System.out.println(System.currentTimeMillis() - begin); // 获取间隔
        Integer[] integers1 = new Integer[array.size()];

        ArrayList<Integer> array1 = getArray();
        array1.toArray(integers1);
        begin = System.currentTimeMillis();
        SortDecorator<Integer> sortor1 = new SortDecorator<>(new InsertSort<>()); //插入排序
        System.out.println(System.currentTimeMillis() - begin); // 获取间隔1
    }


}
