package origin.algorithm.linear.linked;

import origin.algorithm.linear.ILinear;

import java.util.Iterator;

/**
 * @author 原初
 * @create 2022 - 03 - 16
 * 单向链表
 */
public class SingleLinkedList <T> implements ILinear<T> {
    private int length = 0; //个数
    Node<T> first; //第一个元素

    public Node<T> getFirst() {
        return first;
    }

    private class linkedItera implements Iterator<T>{
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < length;
        }

        @Override
        public T next() {
            return position(index++).getContent();
        }
    }
    public void reverse() //反转链表
    {
        /*
        if(length <= 1) //只有一个元素或者没有元素，则无需反转
        {
            return;
        }
        Node<T> backPoint = null;
        Node<T> prePonit = first;
        Node<T> secondPoint = first.getNext(); //俩指针
        while ((backPoint = secondPoint.getNext()) != null)
        {
            secondPoint.setNext(prePonit);
            prePonit = secondPoint;
            secondPoint = backPoint;
        }
        //最后一个元素交换
        secondPoint.setNext(prePonit);
        first = secondPoint; //指向最后一个元素
         */


        //递归方法
        if(length <= 1) //只有一个元素或者没有元素，则无需反转
        {
            return;
        }
        reverse(first, first.getNext());
    }
    public boolean isRing()
    {
        Node<T> slow = first;
        Node<T> fast = first;// 快慢指针
        while(true)
        {
            fast = fast.getNext();
            if(fast == slow)
            {
                return true;
            }else if(fast == null)
            {
                return false;
            }
            fast = fast.getNext();
            if(fast == slow)
            {
                return true;
            }else if(fast == null)
            {
                return false;
            }
            slow = slow.getNext(); // 慢指针移动
        }
    }

    public static <T> Node<T> getRingFirst(Node<T> first)
    {
        Node<T> slow = first;
        Node<T> fast = first;// 快慢指针
        boolean isRing = false;
        while(fast != null && fast.getNext() != null)
        {
            fast = first.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow)
            {
                isRing = true;
                break;
            }
        }
        if(!isRing)
        {
            return null; //不是环
        }
        slow = first; //重新定义
        while(slow != fast)
        {
            slow = slow.getNext();
            fast = fast.getNext(); //有理论依据
        }
        return fast;
    }
    public static <T> boolean isRing(Node<T> first)
    {
        Node<T> slow = first;
        Node<T> fast = first;// 快慢指针
        while(true)
        {
            fast = fast.getNext();
            if(fast == slow)
            {
                return true;
            }else if(fast == null)
            {
                return false;
            }
            fast = fast.getNext();
            if(fast == slow)
            {
                return true;
            }else if(fast == null)
            {
                return false;
            }
            slow = slow.getNext(); // 慢指针移动
        }
    }
    private void reverse(Node<T> pre, Node<T> curr)
    {
        if(pre == first)
        {
            Node<T> temp = pre.getNext();
            pre.setNext(null);
        }
        if(curr.getNext() != null)
        {
            reverse(curr, curr.getNext());
        }else{
            first = curr;
        }
        curr.setNext(pre); // ok

    }
    //快慢指针
    private Node<T> slowAndFast()
    {
        Node<T> slow = first;
        Node<T> fast = first;
        while((fast = moveFast(fast)) != null)
        {
            slow = moveSlow(slow);
        }
        return slow;
    }
    public T getMiddle()
    {
        return slowAndFast().getContent();
    }
    private Node<T> moveSlow(Node<T> slow)
    {
        return slow.getNext();
    }
    private Node<T> moveFast(Node<T> fast)
    {
        if(fast.getNext() != null)
        {
            fast = fast.getNext();
        }
        if(fast.getNext() != null)
        {
            fast = fast.getNext();
            return fast;
        }
        return null;
    }
    public void insert(int index, T content)
    {
        Node<T> pointer = position(index - 1);
        if(pointer == null) //最初索引
        {
            Node<T> newNode = new Node<>(content, first, null); //指向前面一个元素
            first = newNode;
            return;
        }
        Node<T> newNode = new Node<>(content, pointer.getNext(), null); //指向前面一个元素
        pointer.setNext(newNode);
        length++;
    }
    public void insert(T content)
    {
        Node<T> pointer = first;
        if(first == null)
        {
            first = new Node<>(content, null, null); // 单向链表没有前置指针
            length++;
            return;
        }
        for (int i = 1; i < length; i++) {
            pointer = pointer.getNext(); //接着
        }
        pointer.setNext(new Node<>(content, null, null));
        length++;
    }


    public void clear()
    {
        first = null; // 断掉指针
        length = 0;
    }
    public boolean isEmpty()
    {
        return length <= 0;
    }

    @Override
    public int size() {
        return length;
    }

    private Node<T> position(int index)//定位
    {
        if(index < 0)
        {
            return null;
        }
        if(index >= length)
        {
            throw new RuntimeException("索引越界");
        }
        Node<T> pointer = first;
        for (int i = 0; i < index; i++) {
            pointer = pointer.getNext();// 指针前进
        }
        return pointer;
    }
    public T get(int index)
    {
        Node<T> pointer = position(index);
        return pointer.getContent(); // 返回
    }
    public T remove(int index)
    {
        Node<T> pointer = position(index - 1);
        if(pointer == null) //最初索引
        {
            pointer = first;
            T content = first.getContent();
            first = first.getNext();
            pointer.setNext(null); // 断开
            length--;
            return content;
        }
        Node<T> target = null;
        if((target = pointer.getNext()) != null)
        {
            T temp = target.getContent(); //记录
            pointer.setNext(null); // 断开链接
            length--;
            return temp;
        }
        throw new RuntimeException("索引越界");
    }
    public int indexOf(T target)
    {
        int index = -1;
        Node<T> pointer = first;
        while (pointer != null)
        {
            if(pointer.getContent().equals(target))
            {
                return ++index;
            }
            ++index; // 找过了的加上
            pointer = pointer.getNext(); //下一个
        }
        return -1; // 没找到
    }

    public static class Node<T> {
        // 节点
        private T content;
        private Node<T> next; //下一个元素
        private Node<T> pre; //前一个元素

        public Node(T content, Node<T> next, Node<T> pre) {
            this.content = content;
            this.next = next;
            this.pre = pre;
        }

        public Node<T> getPre() {
            return pre;
        }

        public void setPre(Node<T> pre) {
            this.pre = pre;
        }

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new linkedItera();
    }
}

