package origin.algorithm.tree.bTree;

/**
 * @author 原初
 * @create 2022 - 04 - 02
 * B树实现
 */
public class BTree<K extends Comparable<K>, V>{
    private BNode<K, V> root;
    public BTree(int capacity)
    {
        root = new BNode<>(capacity + 1);
    }
    private BNode<K, V> promote(BNode<K, V> origin)
    {
        int mid = origin.getCapacity()/2; //此为提升的位置
        BNode<K, V> newNode = new BNode<K, V>(origin.getCapacity());
        newNode.add(origin.getNode(mid));
        origin.updateNode(mid, null);
        BNode<K, V> rightNode = new BNode<K, V>(origin.getCapacity()); //右边的新建
        for (int i = mid + 1; i < origin.getCapacity(); i++) {
            rightNode.add(origin.getNode(i));
            rightNode.updateLPoint(i - mid - 1, origin.deleteLPointer(i));
            origin.updateNode(i, null); //有很高风险bug
        }
        rightNode.updateRPoint(rightNode.size() - 1, origin.deleteRPointer(origin.getCapacity() - 1));
        newNode.updateLPoint(0 ,origin);
        newNode.updateRPoint(0 ,rightNode);
        return newNode;
    }
    public void insert(K key, V value)
    {
        root = insert(root, key, value);
    }
    private void insertItem(BNode<K, V> node, int index, K key, V value)
    {
        for (int i = node.size() - 1; i >= index; i--) {
            node.updateNode(i + 1, node.getNode(i));
        }
        node.updateNode(index, new BNode.Node<>(key, value));
    }
    private BNode<K ,V> insert(BNode<K, V> node, K key, V value)
    {
        if(node == null)
        {
            return null;
        }
        int index = node.find(key);
        BNode<K, V> temp = null;
        if(node.getNode(index) == null)//有问题
        {
            temp = insert(node.getLPointer(index), key, value);
            if(temp != node.getLPointer(index) && temp != null)
            {
                node.insert(index, 0, temp);
            }else if(temp == null){
                node.updateNode(index, new BNode.Node<>(key, value));
            }else {
                node.updateLPoint(index, temp);
            }
            if(node.getCapacity() == node.size())
            {
                node =  promote(node);
            }
            return node;
        }
        if(key.compareTo(node.getNode(index).getKey()) > 0)
        {
            temp = insert(node.getRPointer(index), key, value);
            if(temp != node.getRPointer(index) && temp != null)
            {
                node.insert(index, 0, temp);
            }else{
                node.updateRPoint(index, temp);
            }

        }else if(key.compareTo(node.getNode(index).getKey()) < 0){
            temp = insert(node.getLPointer(index), key, value);
            if(temp != node.getLPointer(index) && temp != null)
            {
                node.insert(index, 0, temp);
            }else{
                node.updateLPoint(index, temp);
            }
            node.updateLPoint(index, temp);
        }else{
            node.updateNode(index, new BNode.Node<>(key, value));
            return node;
        }
        if(temp == null)
        {
            insertItem(node, index, key, value);
        }
        if(node.getCapacity() == node.size())
        {
            node = promote(node);
        }
        return node;
    }
    public BNode.Node<K ,V> find(K key)
    {
        return find(root, key);
    }
    private BNode.Node<K ,V> find(BNode<K, V> from, K key)
    {
        int index = from.find(key);
        if(from.getNode(index) == null)
        {
            if(from.getLPointer(index) != null)
            {
                return find(from.getLPointer(index), key);
            }
            return null;
        }
        if(key.compareTo(from.getNode(index).getKey()) > 0)
        {
            return find(from.getRPointer(index), key);
        }else if(key.compareTo(from.getNode(index).getKey()) < 0){
            return find(from.getLPointer(index), key);
        }else{
            return from.getNode(index);
        }
    }
}
