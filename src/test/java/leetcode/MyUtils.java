package leetcode;

import leetcode.node.ListNode;
import org.junit.jupiter.api.Assertions;

/**
 * 我的工具类
 *
 * @author kirito
 * @desc ...
 * @date 2022-09-14 08:45:22
 */
public class MyUtils {

    private static final double e = 1e-5;

    public static void doubleEqual(double result, double predict) {
        Assertions.assertTrue(Math.abs(result - predict) <= e);
    }

    public static ListNode array2ListNode(Integer[] arr) {
        ListNode head = new ListNode(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; --i) {
            ListNode node = new ListNode(arr[i]);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static boolean listNodeEqual(ListNode list1, ListNode list2) {
        while (true) {
            if (list1 == null && list2 == null) {
                return true;
            }
            if (list1 != null && list2 == null) {
                return false;
            }
            if (list1 == null) {
                return false;
            }
            if (list1.val != list2.val) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
    }

}
