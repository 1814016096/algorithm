package origin.algorithm.tree.huffman;

import origin.algorithm.tree.heap.MinPriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 原初
 * @create 2022 - 04 - 17
 * 哈夫曼编码
 */
public class HuffmanCoding {
    private MinPriorityQueue<HuffmanNode> priorityQueue; //最小优先队列
    private String content;
    private Map<Character, String> keyMap; //映射表
    private HuffmanNode<Character> root;
    private double compressionRatio = 0; //压缩率
    private byte lastLength = 0;

    public byte getLastLength() {
        return lastLength;
    }

    //根据内容编码
    public HuffmanCoding(String content) {
        Map<Character, Integer> chars = check(content);
        queueInit(chars);
        this.content = content;
    }

    public Map<Character, String> getKeyMap() {
        return keyMap;
    }

    /**
     * 编码
     *
     * @return
     */
    public byte[] encode() {
        buildTree();
        buildMap(); //生成映射表
        StringBuilder bytes = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            bytes.append(keyMap.get(content.charAt(i)));
        }
        return toByte(bytes.toString());
    }

    public byte[] toByte(String content) {
        byte[] bytes = new byte[((content.length() + 7) / 8)];
        int count = 0;
        for (int i = 0; i < content.length(); i += 8) {
            if ((i + 8) >= content.length()) {
                lastLength = (byte) content.substring(i).length();
                bytes[count++] = Byte.parseByte(content.substring(i), 2);
            } else {
                bytes[count++] = (byte) Integer.parseInt(content.substring(i, i + 8), 2);
            }
        }
        return bytes;
    }

    public static String toString(int length, byte b) {
        int temp = 256 | b; //扩充位数
        String str = Integer.toBinaryString(temp);
        return str.substring(str.length() - length);
    }

    public static String decode(byte[] code, HuffmanNode<Character> node, byte length) {
        HuffmanNode<Character> pointer = node;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < code.length - 1; i++) {
            builder.append(toString(8, code[i]));
        }
        builder.append(toString(length, code[code.length - 1]));
        StringBuilder Strbuilder = new StringBuilder();
        for (int i = 0; i < builder.length(); i++) {
            Integer curr = Integer.parseInt(builder.substring(i, i + 1));
            if (curr == 0) {
                pointer = pointer.getLeft();
            } else {
                pointer = pointer.getRight();
            }
            if (pointer.getData() != null) {
                Strbuilder.append(pointer.getData());
                pointer = node;
            }
        }
        return Strbuilder.toString();
    }

    /**
     * 生成映射表
     */
    private void buildMap() {
        if (keyMap == null) {
            keyMap = new HashMap<>();
            preTransal(root, new StringBuilder());
        }
    }

    /**
     * 前序遍历的变长编码
     *
     * @param code
     */
    private void preTransal(HuffmanNode<Character> root, StringBuilder code) {
        // 自己
        if (root.getData() != null) {
            keyMap.put(root.getData(), code.toString());
            return;
        }
        code.append("0"); //左是0
        preTransal(root.getLeft(), code);
        code.delete(code.length() - 1, code.length());
        code.append("1"); //右是1
        preTransal(root.getRight(), code);
        code.delete(code.length() - 1, code.length());
    }

    /**
     * 生成哈夫曼树
     *
     * @return
     */
    public HuffmanNode<Character> buildTree() {
        if (root == null) {
            while (priorityQueue.size() > 1) {
                HuffmanNode left = priorityQueue.delMin();
                HuffmanNode right = priorityQueue.delMin();
                HuffmanNode<Character> parent = new HuffmanNode<>(left.getValue()
                        + right.getValue(), left, right);
                priorityQueue.insert(parent);
            }
            root = priorityQueue.delMin();
        }
        return root;
    }

    /**
     * 初始化最小优先队列
     *
     * @param chars
     */
    private void queueInit(Map<Character, Integer> chars) {
        priorityQueue = new MinPriorityQueue<>(chars.size());
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            HuffmanNode<Character> node = new HuffmanNode<>(entry.getValue(), null,
                    null, entry.getKey());
            priorityQueue.insert(node);
        }
        return;
    }

    /**
     * 根据content来扫一遍权值
     *
     * @param content
     * @return
     */
    private Map<Character, Integer> check(String content) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < content.length(); i++) {
            if (map.containsKey(content.charAt(i))) {
                map.put(content.charAt(i)
                        , map.get(content.charAt(i)) + 1);
            } else {
                map.put(content.charAt(i), 1); //没有就设置为一个
            }
        }
        return map;
    }
}
