package origin.algorithm.sort.shell;

import java.io.*;

/**
 * @author 原初
 * @create 2022 - 03 - 12
 */
public class TestCreat {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter stream = new OutputStreamWriter(new FileOutputStream("test.txt"));
        for (int i = 0; i < 100000; i++) {
            stream.write(100000 - i + "\n");
        }
    }
}
