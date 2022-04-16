package origin.algorithm.linear.linked;

import origin.algorithm.linear.ILinear;

import java.util.Iterator;

/**
 * @author 原初
 * @create 2022 - 03 - 16
 * 双向链表
 */
public class TwoWayLinkedList<T> implements ILinear<T> {
    SingleLinkedList.Node<T> first; // 第一个
    SingleLinkedList.Node<T> last;// 最后一个
    int length = 0; //方便减少运算
    public TwoWayLinkedList()
    {
        last = first = new SingleLinkedList.Node<>(null, null, null); //头节点
    }
    @Override
    public void insert(T value) {
        SingleLinkedList.Node<T> newNode = new SingleLinkedList.Node<>(value, first, last); //插入
        first.setPre(newNode);
        last.setNext(newNode);
        last = newNode;
        last.setNext(first);
        if(length == 0)
        {
            first.setNext(newNode);
        }
        length++;
    }
    private boolean fromHead(int index)
    {
        return index <= length / 2;
    }
    private SingleLinkedList.Node<T> position(int index, boolean fromHead)
    {
        if(index < -1 || index > length - 1) // -1 代表头指针
        {
            throw new RuntimeException("数组越界");
        }
        if(fromHead)
        {
            SingleLinkedList.Node<T> pointer = first;
            for (int i = 0; i <= index; i++) {
                pointer = pointer.getNext();
            }
            return pointer;
        }else {
            SingleLinkedList.Node<T> pointer = last;
            int backIndex = length - index;
            for (int i = 0; i < backIndex - 1; i++) {
                pointer = pointer.getPre();
            }
            return pointer;
        }

    }
    @Override
    public void insert(int index, T value) {
        SingleLinkedList.Node<T> position = position(index, fromHead(index));
        SingleLinkedList.Node<T> newNode = new SingleLinkedList.Node<>(value, position.getNext(), position);
        position.setNext(newNode);
        newNode.getNext().setPre(newNode);
        length++;
    }

    @Override
    public T get(int index) {
        return position(index, fromHead(index)).getContent();
    }

    @Override
    public T remove(int index) {
        SingleLinkedList.Node<T> position = position(index, fromHead(index));
        SingleLinkedList.Node<T> back = position.getPre(); // 上一个节点
        back.setNext(position.getNext());
        position.getNext().setPre(back);
        position.setPre(null);
        position.setNext(null);
        T content = position.getContent();
        position.setContent(null);
        last = back;
        length--;
        return content;
    }

    @Override
    public void clear() {
        last = first;
        first.setNext(null);
        first.setPre(null);
    }

    @Override
    public boolean isEmpty() {
        return length <= 0;
    }

    @Override
    public int size() {
        return length;
    }

    private class TwoWayIterator implements Iterator<T> {
        SingleLinkedList.Node<T> position = first;
        @Override
        public boolean hasNext() {
            return position.getNext() != first;
        }

        @Override
        public T next() {
            position = position.getNext();
            return position.getContent();
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new TwoWayIterator();
    }

}
