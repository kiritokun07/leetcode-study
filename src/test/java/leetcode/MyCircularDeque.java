package leetcode;

/**
 * 双端队列
 */
class MyCircularDeque {

    private final int[] queue;
    private final int length;
    private int front;
    private int rear;
    private int size;

    /**
     * 构造函数,双端队列最大为 k
     * 初始开头和结尾指针都指向0
     *
     * @param k
     */
    public MyCircularDeque(int k) {
        queue = new int[k];
        length = k;
        front = 0;
        rear = 0;
        size = 0;
    }

    /**
     * 将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false
     *
     * @param value
     * @return
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        queue[front] = value;
        ++front;
        front = front % length;
        ++size;
        return true;
    }

    /**
     * 将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false
     *
     * @param value
     * @return
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        --rear;
        if (rear < 0) {
            rear = length - 1;
        }
        queue[rear] = value;
        ++size;
        return true;
    }

    /**
     * 从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false
     *
     * @return
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        --front;
        if (front < 0) {
            front = length - 1;
        }
        --size;
        return true;
    }

    /**
     * 从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false
     *
     * @return
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        ++rear;
        rear = rear % length;
        --size;
        return true;
    }

    /**
     * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1
     *
     * @return
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front - 1 < 0 ? length - 1 : front - 1];
    }

    /**
     * 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1
     *
     * @return
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }

    /**
     * 若双端队列为空，则返回 true ，否则返回 false
     *
     * @return
     */
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * 若双端队列满了，则返回 true ，否则返回 false
     *
     * @return
     */
    public boolean isFull() {
        return size == length;
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */