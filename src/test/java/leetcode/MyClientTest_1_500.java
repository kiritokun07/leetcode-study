package leetcode;

import leetcode.node.ListNode;
import leetcode.node.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author kirito
 * @desc ...
 * @date 2022-07-31 16:02:08
 */
public class MyClientTest_1_500 {

    MySolution_1_500 solution = new MySolution_1_500();

    /**
     * 14. 最长公共前缀
     * 简单
     * https://leetcode.cn/problems/longest-common-prefix/
     */
    @Test
    public void no14() {
        String[] s = {"ab", "a"};
        String s1 = solution.longestCommonPrefix(s);
        System.out.println(s1);
    }

    /**
     * 83. 删除排序链表中的重复元素
     * 简单
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
     */
    @Test
    public void no83() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);

        solution.printNode(l1);
//        printNode(l2);
        ListNode result = solution.deleteDuplicates(l1);
        solution.printNode(result);
    }

}
