package origin.algorithm.tree.uf;

/**
 * @author 原初
 * @create 2022 - 04 - 02
 */
public class UFtest {
    public static void main(String[] args) { //并查集
        UF uf = new UF(10);
        System.out.println(uf.isConnected(1, 5));
        uf.union(1, 5);
        uf.union(5, 7);
        uf.union(7, 4);
        System.out.println(uf.isConnected(1,4));
    }
}
