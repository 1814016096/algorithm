package origin.algorithm.tree.huffman;

import java.util.Arrays;

/**
 * @author 原初
 * @create 2022 - 04 - 17
 */
public class CodeTest {
    public static void main(String[] args) {
        HuffmanCoding coding = new HuffmanCoding("wocwocwoocasocasjcasicuaicbask");
        byte[] encode = coding.encode();
        System.out.println("编码:" + Arrays.toString(encode));
        System.out.println(coding.getKeyMap());
        System.out.println(HuffmanCoding.decode(encode, coding.buildTree(), coding.getLastLength()));
    }
}
