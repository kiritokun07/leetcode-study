package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    @Test
    public void test101() {
        String[] s = {"ab", "a"};
        String s1 = solution.longestCommonPrefix(s);
        System.out.println(s1);
    }

}
