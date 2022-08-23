package leetcode.node;

/**
 * 栈
 *
 * @author kirito
 * @desc ...
 * @date 2022-08-23 19:22:53
 */
public class MyStack {

    public int[] stack;

    public int head;

    public MyStack(int size) {
        this.stack = new int[size];
        this.head = 0;
    }

    public void push(int val) {
        stack[head] = val;
        ++head;
    }

    public int getTheHead() {
        if (head < 1) {
            return -1;
        }
        return stack[head - 1];
    }

    public int pop() {
        --head;
        return stack[head];
    }

    public boolean isFull() {
        return head >= stack.length;
    }

    public boolean isEmpty() {
        return head == 0;
    }

}
