package origin.algorithm.linear.linked;

/**
 * @author 原初
 * @create 2022 - 03 - 18
 * 循环链表：为约瑟夫问题创建
 */

public class CircleTrain {
    private int finalExit = -1; //最后退出的那个人的编号
    private volatile boolean isOver = false;
    private int length = 0;
    public CircleTrain(int number, int interval)
    {
        // 建立循环链表
        new Thread(() ->{
            SingleLinkedList.Node<Integer> train = build(number);
            while (length != 1)
            {
                for (int i = 0; i < interval - 1; i++) {
                    train = train.getNext(); //前进这么多
                }
                System.out.println(train.getNext().getContent() + "自杀了");
                train.setNext(train.getNext().getNext()); //去掉
                train = train.getNext();
                length--;
            }
            finalExit = train.getContent();
            isOver = true;
            synchronized (this)
            {
                this.notifyAll();
            }
        }).start();
    }
    public int getResult()
    {
        if(!isOver)
        {
            synchronized (this)
            {
                if(!isOver)
                {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return finalExit;
    }
    private SingleLinkedList.Node<Integer> build(int number)
    {
        SingleLinkedList.Node<Integer> first = new SingleLinkedList.Node<>(1, null, null); //第一个节点
        SingleLinkedList.Node<Integer> pointer = first;
        pointer.setNext(first); //指向自己
        length++;
        for (int i = 1; i < number; i++) {

            pointer.setNext(new SingleLinkedList.Node<>(i + 1, first, null)); //单向指针
            pointer = pointer.getNext();
            length++; // 移动并记录
        }
        return first;
    }
}
