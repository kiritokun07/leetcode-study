package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 测试
 *
 * @author kirito
 * @desc ...
 * @date 2022-07-31 16:02:08
 */
public class Client {

    Solution solution = new Solution();

    @Test
    public void test100() {
        Solution.ListNode l1 = new Solution.ListNode(1);
        l1.next = new Solution.ListNode(1);
        l1.next.next = new Solution.ListNode(3);
        l1.next.next.next = new Solution.ListNode(3);
        l1.next.next.next.next = new Solution.ListNode(4);
        l1.next.next.next.next.next = new Solution.ListNode(4);
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);

        solution.printNode(l1);
//        printNode(l2);
        Solution.ListNode result = solution.deleteDuplicates(l1);
        solution.printNode(result);
    }

    /**
     * 622. 设计循环队列
     * https://leetcode.cn/problems/design-circular-queue/
     */
    @Test
    public void no622() {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        Assertions.assertTrue(circularQueue.enQueue(1)); // 返回 true
        Assertions.assertTrue(circularQueue.enQueue(2)); // 返回 true
        Assertions.assertTrue(circularQueue.enQueue(3)); // 返回 true
        Assertions.assertFalse(circularQueue.enQueue(4)); // 返回 false，队列已满
        Assertions.assertEquals(circularQueue.Rear(), 3); // 返回 3
        Assertions.assertTrue(circularQueue.isFull()); // 返回 true
        Assertions.assertTrue(circularQueue.deQueue()); // 返回 true
        Assertions.assertTrue(circularQueue.enQueue(4)); // 返回 true
        Assertions.assertEquals(circularQueue.Rear(), 4); // 返回 4
    }

    @Test
    public void temp() {
        String s = "abcd";
        int length = s.length();
        int i = 2;
        String tempS = s.substring(i, length) + s.substring(0, i);
        System.out.println("tempS = " + tempS);
    }

    /**
     * 899. 有序队列
     * https://leetcode.cn/problems/orderly-queue/
     */
    @Test
    public void no899() {
        Assertions.assertEquals(solution.orderlyQueue("cba", 1), "acb");
        Assertions.assertEquals(solution.orderlyQueue("baaca", 3), "aaabc");
    }

    /**
     * 1161. 最大层内元素和
     * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
     */
    @Test
    public void no1161() {
        Solution.TreeNode five = new Solution.TreeNode(7, null, null);
        Solution.TreeNode six = new Solution.TreeNode(-8, null, null);
        Solution.TreeNode two = new Solution.TreeNode(7, five, six);
        Solution.TreeNode three = new Solution.TreeNode(0, null, null);
        Solution.TreeNode one = new Solution.TreeNode(1, two, three);
        int maxLevelSum = solution.maxLevelSum(one);
        System.out.println("maxLevelSum = " + maxLevelSum);
        Assertions.assertEquals(maxLevelSum, 2);
    }

    /**
     * 1331. 数组序号转换
     * https://leetcode.cn/problems/rank-transform-of-an-array/
     */
    @Test
    public void no1331() {
        int[] arr = {40, 10, 10, 20, 30};
        int[] transform = solution.arrayRankTransform(arr);
        System.out.println("transform = " + Arrays.toString(transform));
        //预期结果：[5,1,1,3,4]
    }

    /**
     * 1374. 生成每种字符都是奇数个的字符串
     * https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/
     */
    @Test
    public void no1374() {
        int n = 4;
        String generateTheString = solution.generateTheString(n);
        System.out.println("generateTheString = " + generateTheString);
    }

    /**
     * 1403. 非递增顺序的最小子序列
     * https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/
     */
    @Test
    public void no1403() {
        int[] nums = new int[]{4, 3, 10, 9, 8};
        List<Integer> subsequence = solution.minSubsequence(nums);
        Assertions.assertEquals(subsequence.get(0), 10);
        Assertions.assertEquals(subsequence.get(1), 9);
        int[] nums2 = new int[]{4, 4, 7, 6, 7};
        List<Integer> subsequence2 = solution.minSubsequence(nums2);
        Assertions.assertEquals(subsequence2.get(0), 7);
        Assertions.assertEquals(subsequence2.get(1), 7);
        Assertions.assertEquals(subsequence2.get(2), 6);
    }

    @Test
    public void test101() {
        String[] s = {"ab", "a"};
        String s1 = solution.longestCommonPrefix(s);
        System.out.println(s1);
    }

}
