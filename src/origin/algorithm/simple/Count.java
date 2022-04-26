package origin.algorithm.simple;

import java.io.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author 原初
 * @create 2022 - 04 - 23
 * 统计代码量
 */
public class Count {
    public static int readFile(String path, Function<File, Integer> operation)
    {
        int count = 0;
        File currfile = new File(path);
        for (File file : currfile.listFiles()) {
            if(file.isDirectory())
            {
                count += readFile(file.getAbsolutePath(), operation);
            }else{
                count += operation.apply(file);
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int count = Count.readFile(args[0], x -> {
            if(x.getPath().indexOf(".java") == -1)
            {
                return 0;
            }
            int coutLine = 0;
            try (BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(x)))) {
                while (r.readLine() != null) {
                    coutLine++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return coutLine;
        });
        System.out.println(count);
    }
}
