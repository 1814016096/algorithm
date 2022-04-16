package origin.algorithm.hash_table;

/**
 * @author 原初
 * @create 2022 - 04 - 15
 */
public class HashTest {
    public static void main(String[] args) {
        HashTable<Integer, String> table = new HashTable<>(20);
        table.insert(1, "1");
        table.insert(2, "2");
        table.insert(21, "21");
        table.insert(22, "22");
        table.insert(23, "23");
        System.out.println(table.find(1));
//        table.delete(1);
        table.insert(1, "100");
        System.out.println(table.find(1));
    }
}
