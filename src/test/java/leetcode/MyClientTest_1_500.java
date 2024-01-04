package leetcode;

import leetcode.node.ListNode;
import leetcode.node.Trie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kirito
 * @desc ...
 * @date 2022-07-31 16:02:08
 */
public class MyClientTest_1_500 {

    MySolution_1_500 solution = new MySolution_1_500();

    /**
     * 3. 无重复字符的最长子串
     * 简单
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
     */
    @Test
    public void no3() {
        Assertions.assertEquals(solution.lengthOfLongestSubstring("abcabcbb"), 3);
        Assertions.assertEquals(solution.lengthOfLongestSubstring("bbbbb"), 1);
        Assertions.assertEquals(solution.lengthOfLongestSubstring("pwwkew"), 3);
    }

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
     * 19. 删除链表的倒数第 N 个结点
     * 中等
     * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
     */
    @Test
    public void no19() {
        ListNode listNode = solution.removeNthFromEnd(MyUtils.array2ListNode(new Integer[]{1, 2, 3, 4, 5}), 2);
        ListNode listNode2 = solution.removeNthFromEnd(MyUtils.array2ListNode(new Integer[]{1}), 1);
        //System.out.println("listNode.toString() = " + listNode.toString());
    }

    /**
     * 20. 有效的括号
     * 简单
     * https://leetcode.cn/problems/valid-parentheses/
     */
    @Test
    public void no20() {
        Assertions.assertTrue(solution.isValid("()"));
        Assertions.assertTrue(solution.isValid("()[]{}"));
        Assertions.assertFalse(solution.isValid("(]"));
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

    /**
     * 208. 实现 Trie (前缀树)
     * 中等
     * https://leetcode.cn/problems/implement-trie-prefix-tree/
     */
    @Test
    public void no208() {
        Trie trie = new Trie();
        trie.insert("apple");
        Assertions.assertTrue(trie.search("apple"));   // 返回 True
        Assertions.assertFalse(trie.search("app"));     // 返回 False
        Assertions.assertTrue(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        Assertions.assertTrue(trie.search("app"));     // 返回 True
    }

    /**
     * 278. 第一个错误的版本
     * 简单
     * https://leetcode.cn/problems/first-bad-version/
     */
    @Test
    public void no278() {
        Assertions.assertEquals(solution.firstBadVersion(2126753390), 1702766719);
    }

    /**
     * 319. 灯泡开关
     * 中等
     * https://leetcode.cn/problems/bulb-switcher/
     */
    @Test
    public void no319() {
        Assertions.assertEquals(solution.bulbSwitch(3), 1);
        Assertions.assertEquals(solution.bulbSwitch(0), 0);
        Assertions.assertEquals(solution.bulbSwitch(1), 1);
    }

    /**
     * 486. 预测赢家
     * 中等
     * https://leetcode.cn/problems/predict-the-winner/
     */
    @Test
    public void no486() {
        Assertions.assertFalse(solution.PredictTheWinner(new int[]{1, 5, 2}));
        Assertions.assertTrue(solution.PredictTheWinner(new int[]{1, 5, 233, 7}));
    }

}
