package leetcode;

class MyCircularQueue {

    private final int[] queue;
    private int length;
    private int front;
    private int rear;
    private int size;

    public MyCircularQueue(int k) {
        queue = new int[k];
        length = k;
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        //检查是否已满
        if (isFull()) {
            return false;
        }
        queue[rear] = value;
        ++rear;
        rear = rear % length;
        ++size;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        ++front;
        if (front > length - 1) {
            front = 0;
        }
        --size;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        if (rear - 1 < 0) {
            return queue[length - 1];
        }
        return queue[rear - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == length;
    }

}