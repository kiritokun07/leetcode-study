package leetcode.node;

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
public class MyLinkedList {

    private int size;
    private final ListNode headNode;

    public MyLinkedList() {
        headNode = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode temp = headNode;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        ListNode temp = headNode;
        for (int i = 0; i < index; i++) {
            if (temp.next == null) {
                return;
            }
            temp = temp.next;
        }
        ListNode insertNode = new ListNode(val);
        insertNode.next = temp.next;
        temp.next = insertNode;
        ++size;
    }

    public void deleteAtIndex(int index) {
        ListNode temp = headNode;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
            if (temp.next == null) {
                return;
            }
        }
        temp.next = temp.next.next;
        --size;
    }
}