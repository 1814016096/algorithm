package origin.algorithm.linear.stack.curculate.input;

import origin.algorithm.linear.stack.curculate.executor.Executor;

import java.io.*;

/**
 * @author 原初
 * @create 2022 - 03 - 21
 */
public class AssignmentReader {
    private Executor executor;
    public AssignmentReader(Executor executor)
    {
        this.executor = executor;
    }
    public void read(String path) {
        try (BufferedReader ir = new BufferedReader
                (new InputStreamReader(
                        new FileInputStream(path), "UTF-8")) ){
            String line = "";
            while ((line = ir.readLine()) != null)
            {
                executor.execute(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
