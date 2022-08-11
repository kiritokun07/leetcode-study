package leetcode;

import leetcode.node.ListNode;
import leetcode.node.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 力扣每日一题
 * https://leetcode.cn/problemset/all/
 *
 * @author kirito
 * @desc ...
 * @date 2022-07-31 16:02:08
 */
public class Client {

    Solution solution = new Solution();

    /**
     * 14. 最长公共前缀
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
     * 623. 在二叉树中增加一行
     * https://leetcode.cn/problems/add-one-row-to-tree/
     */
    @Test
    public void no623() {
        int[] root = new int[]{4, 2, 6, 3, 1, 5};
        //数组转二叉树
        TreeNode array2TreeNode = TreeNode.array2TreeNode(root);
        //TreeNode four = new TreeNode(3, null, null);
        //TreeNode five = new TreeNode(1, null, null);
        //TreeNode six = new TreeNode(5, null, null);
        //TreeNode two = new TreeNode(2, four, five);
        //TreeNode three = new TreeNode(6, six, null);
        //TreeNode one = new TreeNode(4, two, three);
        int val = 1;
        int depth = 2;
        TreeNode addOneRow = solution.addOneRow(array2TreeNode, val, depth);
        Assertions.assertEquals(addOneRow.val, 4);
        Assertions.assertEquals(addOneRow.left.val, 1);
        Assertions.assertEquals(addOneRow.right.val, 1);
        Assertions.assertEquals(addOneRow.left.left.val, 2);
        Assertions.assertEquals(addOneRow.right.right.val, 6);
        Assertions.assertEquals(addOneRow.left.left.left.val, 3);
        Assertions.assertEquals(addOneRow.left.left.right.val, 1);
        Assertions.assertEquals(addOneRow.right.right.left.val, 5);
    }

    /**
     * 636. 函数的独占时间
     * https://leetcode.cn/problems/exclusive-time-of-functions/
     */
    @Test
    public void no636() {
        int n1 = 2;
        List<String> logs1 = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        int[] exclusiveTime1 = solution.exclusiveTime(n1, logs1);
        Assertions.assertEquals(exclusiveTime1.length, 2);
        Assertions.assertEquals(exclusiveTime1[0], 3);
        Assertions.assertEquals(exclusiveTime1[1], 4);

        int n2 = 1;
        List<String> logs2 = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
        int[] exclusiveTime2 = solution.exclusiveTime(n2, logs2);
        Assertions.assertEquals(exclusiveTime2.length, 1);
        Assertions.assertEquals(exclusiveTime2[0], 8);

        int n3 = 2;
        List<String> logs3 = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7");
        int[] exclusiveTime3 = solution.exclusiveTime(n3, logs3);
        Assertions.assertEquals(exclusiveTime3.length, 2);
        Assertions.assertEquals(exclusiveTime3[0], 7);
        Assertions.assertEquals(exclusiveTime3[1], 1);

        int n4 = 2;
        List<String> logs4 = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8");
        int[] exclusiveTime4 = solution.exclusiveTime(n4, logs4);
        Assertions.assertEquals(exclusiveTime4.length, 2);
        Assertions.assertEquals(exclusiveTime4[0], 8);
        Assertions.assertEquals(exclusiveTime4[1], 1);

        int n5 = 1;
        List<String> logs5 = Arrays.asList("0:start:0", "0:end:0");
        int[] exclusiveTime5 = solution.exclusiveTime(n5, logs5);
        Assertions.assertEquals(exclusiveTime5.length, 1);
        Assertions.assertEquals(exclusiveTime5[0], 1);
    }

    /**
     * 640. 求解方程
     * https://leetcode.cn/problems/solve-the-equation/
     */
    @Test
    public void no640() {
        Assertions.assertEquals(solution.solveEquation("x+5-3+x=6+x-2"), "x=2");
        Assertions.assertEquals(solution.solveEquation("x=x"), "Infinite solutions");
        Assertions.assertEquals(solution.solveEquation("2x=x"), "x=0");
        Assertions.assertEquals(solution.solveEquation("x=x+2"), "No solution");
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
        TreeNode five = new TreeNode(7, null, null);
        TreeNode six = new TreeNode(-8, null, null);
        TreeNode two = new TreeNode(7, five, six);
        TreeNode three = new TreeNode(0, null, null);
        TreeNode one = new TreeNode(1, two, three);
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

    /**
     * 1408. 数组中的字符串匹配
     * https://leetcode.cn/problems/string-matching-in-an-array/
     */
    @Test
    public void no1408() {
        String[] words1 = new String[]{"mass", "as", "hero", "superhero"};
        List<String> matching1 = solution.stringMatching(words1);
        Assertions.assertEquals(matching1.get(0), "as");
        Assertions.assertEquals(matching1.get(1), "hero");

        String[] words2 = new String[]{"leetcode", "et", "code"};
        List<String> matching2 = solution.stringMatching(words2);
        Assertions.assertEquals(matching2.get(0), "et");
        Assertions.assertEquals(matching2.get(1), "code");

        String[] words3 = new String[]{"blue", "green", "bu"};
        List<String> matching3 = solution.stringMatching(words3);
        Assertions.assertEquals(matching3.size(), 0);
    }

    /**
     * 1413. 逐步求和得到正数的最小值
     * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
     */
    @Test
    public void no1413() {
        int[] nums1 = new int[]{-3, 2, -3, 4, 2};
        int value1 = solution.minStartValue(nums1);
        Assertions.assertEquals(value1, 5);

        int[] nums2 = new int[]{1, 2};
        int value2 = solution.minStartValue(nums2);
        Assertions.assertEquals(value2, 1);

        int[] nums3 = new int[]{1, -2, -3};
        int value3 = solution.minStartValue(nums3);
        Assertions.assertEquals(value3, 5);
    }

    /**
     * 1417. 重新格式化字符串
     * https://leetcode.cn/problems/reformat-the-string/
     */
    @Test
    public void no1417() {
        Assertions.assertEquals(solution.reformat("a0b1c2"),"0a1b2c");
        Assertions.assertEquals(solution.reformat("leetcode"),"");
        Assertions.assertEquals(solution.reformat("1229857369"),"");
        Assertions.assertEquals(solution.reformat("covid2019"),"c2o0v1i9d");
        Assertions.assertEquals(solution.reformat("ab123"),"1a2b3");
    }

}
