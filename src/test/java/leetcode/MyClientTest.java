package leetcode;

import leetcode.node.ListNode;
import leetcode.node.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
public class MyClientTest {

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
        Integer[] root = new Integer[]{4, 2, 6, 3, 1, 5};
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

        int n6 = 3;
        List<String> logs6 = Arrays.asList("0:start:0", "0:end:0", "1:start:1", "1:end:1", "2:start:2", "2:end:2", "2:start:3", "2:end:3");
        int[] exclusiveTime6 = solution.exclusiveTime(n6, logs6);
        Assertions.assertEquals(exclusiveTime6.length, 3);
        Assertions.assertEquals(exclusiveTime6[0], 1);
        Assertions.assertEquals(exclusiveTime6[1], 1);
        Assertions.assertEquals(exclusiveTime6[2], 2);
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
     * 641. 设计循环双端队列
     * https://leetcode.cn/problems/design-circular-deque/
     */
    @Test
    public void no641() {
        int k = 3;
        MyCircularDeque myCircularDeque = new MyCircularDeque(k);
        Assertions.assertTrue(myCircularDeque.insertLast(1));
        Assertions.assertTrue(myCircularDeque.insertLast(2));
        Assertions.assertTrue(myCircularDeque.insertFront(3));
        Assertions.assertFalse(myCircularDeque.insertFront(4));
        Assertions.assertEquals(myCircularDeque.getRear(), 2);
        Assertions.assertTrue(myCircularDeque.isFull());
        Assertions.assertTrue(myCircularDeque.deleteLast());
        Assertions.assertTrue(myCircularDeque.insertFront(4));
        Assertions.assertEquals(myCircularDeque.getFront(), 4);
    }

    /**
     * 654. 最大二叉树
     * https://leetcode.cn/problems/maximum-binary-tree/
     *
     * @see MyClientTest#no998
     */
    @Test
    public void no654() {
        //需要写个二叉树转数组？
        //或者写个判断treeNode相等的方法
        Assertions.assertTrue(TreeNode.isEqual(solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}), TreeNode.array2TreeNode2(new Integer[]{6, 3, 5, null, 2, 0, null, null, 1})));
        Assertions.assertTrue(TreeNode.isEqual(solution.constructMaximumBinaryTree(new int[]{3, 2, 1}), TreeNode.array2TreeNode2(new Integer[]{3, null, 2, null, 1})));
    }

    /**
     * 655. 输出二叉树
     * https://leetcode.cn/problems/print-binary-tree/
     */
    @Test
    public void no655() {
        List<List<String>> listList = solution.printTree(TreeNode.array2TreeNode2(new Integer[]{1, 2}));
        List<List<String>> listList2 = solution.printTree(TreeNode.array2TreeNode2(new Integer[]{1, 2, 3, null, 4}));
    }

    /**
     * 658. 找到 K 个最接近的元素
     * https://leetcode.cn/problems/find-k-closest-elements/
     */
    @Test
    public void no658() {
        Assertions.assertEquals(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3).toString(), "[1, 2, 3, 4]");
        Assertions.assertEquals(solution.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1).toString(), "[1, 2, 3, 4]");
    }

    /**
     * 662. 二叉树最大宽度
     * https://leetcode.cn/problems/maximum-width-of-binary-tree/
     */
    @Test
    public void no662() {
        Assertions.assertEquals(solution.widthOfBinaryTree(TreeNode.array2TreeNode2(new Integer[]{1, 3, 2, 5, 3, null, 9})), 4);
        Assertions.assertEquals(solution.widthOfBinaryTree(TreeNode.array2TreeNode2(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, 7})), 7);
        Assertions.assertEquals(solution.widthOfBinaryTree(TreeNode.array2TreeNode2(new Integer[]{1, 3, 2, 5})), 2);
        Assertions.assertEquals(solution.widthOfBinaryTree(TreeNode.array2TreeNode2(new Integer[]{1, null, 2})), 1);
        Assertions.assertEquals(solution.widthOfBinaryTree(TreeNode.array2TreeNode2(new Integer[]{-64, 12, 18, -4, -53, null, 76, null, -51, null, null, -93, 3, null, -31, 47, null, 3, 53, -81, 33, 4, null, -51, -44, -60, 11, null, null, null, null, 78, null, -35, -64, 26, -81, -31, 27, 60, 74, null, null, 8, -38, 47, 12, -24, null, -59, -49, -11, -51, 67, null, null, null, null, null, null, null, -67, null, -37, -19, 10, -55, 72, null, null, null, -70, 17, -4, null, null, null, null, null, null, null, 3, 80, 44, -88, -91, null, 48, -90, -30, null, null, 90, -34, 37, null, null, 73, -38, -31, -85, -31, -96, null, null, -18, 67, 34, 72, null, -17, -77, null, 56, -65, -88, -53, null, null, null, -33, 86, null, 81, -42, null, null, 98, -40, 70, -26, 24, null, null, null, null, 92, 72, -27, null, null, null, null, null, null, -67, null, null, null, null, null, null, null, -54, -66, -36, null, -72, null, null, 43, null, null, null, -92, -1, -98, null, null, null, null, null, null, null, 39, -84, null, null, null, null, null, null, null, null, null, null, null, null, null, -93, null, null, null, 98})), 169);
        Assertions.assertEquals(solution.widthOfBinaryTree(TreeNode.array2TreeNode2(new Integer[]{1, 1, 1, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, null, 1, 1, null, 1, null, 1, null, 1, null, 1, null})), 2147483645);
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
     * 946. 验证栈序列
     * https://leetcode.cn/problems/validate-stack-sequences/
     */
    @Test
    public void no946() {
        Assertions.assertTrue(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        Assertions.assertFalse(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    /**
     * 998. 最大二叉树 II
     * https://leetcode.cn/problems/maximum-binary-tree-ii/
     *
     * @see MyClientTest#no654 最大二叉树
     */
    @Test
    public void no998() {
        Assertions.assertTrue(TreeNode.isEqual(solution.insertIntoMaxTree(TreeNode.array2TreeNode2(new Integer[]{4, 1, 3, null, null, 2}), 5), TreeNode.array2TreeNode2(new Integer[]{5, 4, null, 1, 3, null, null, 2})));
        Assertions.assertTrue(TreeNode.isEqual(solution.insertIntoMaxTree(TreeNode.array2TreeNode2(new Integer[]{5, 2, 4, null, 1}), 3), TreeNode.array2TreeNode2(new Integer[]{5, 2, 4, null, 1, null, 3})));
        Assertions.assertTrue(TreeNode.isEqual(solution.insertIntoMaxTree(TreeNode.array2TreeNode2(new Integer[]{5, 2, 3, null, 1}), 4), TreeNode.array2TreeNode2(new Integer[]{5, 2, 4, null, 1, 3})));
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
     * 1224. 最大相等频率
     * https://leetcode.cn/problems/maximum-equal-frequency/
     * 需要优化时间复杂度
     */
    @Test
    public void no1224() {
        Assertions.assertEquals(solution.maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5}), 7);
        Assertions.assertEquals(solution.maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5}), 13);
        Assertions.assertEquals(solution.maxEqualFreq(new int[]{10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6}), 8);
        Assertions.assertEquals(solution.maxEqualFreq(new int[]{1, 1}), 2);
        Assertions.assertEquals(solution.maxEqualFreq(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}), 9);
        Assertions.assertEquals(solution.maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}), 7);
    }

    /**
     * 1282. 用户分组
     * https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
     */
    @Test
    public void no1282() {
        int[] groupSizes1 = {3, 3, 3, 3, 3, 1, 3};
        assertGroupPeople(groupSizes1);
        int[] groupSizes2 = {2, 1, 3, 3, 3, 2};
        assertGroupPeople(groupSizes2);
    }

    /**
     * 验证这个数组的每个元素所在的list的大小都等于以数字为下表的原数组的值
     *
     * @param groupSizes 数组大小
     */
    public void assertGroupPeople(int[] groupSizes) {
        List<List<Integer>> peopleListList = solution.groupThePeople(groupSizes);
        for (List<Integer> peopList : peopleListList) {
            int size = peopList.size();
            for (Integer peop : peopList) {
                Assertions.assertEquals(groupSizes[peop], size);
            }
        }
    }

    /**
     * 1302. 层数最深叶子节点的和
     * https://leetcode.cn/problems/deepest-leaves-sum/
     */
    @Test
    public void no1302() {
        //array2TreeNode方法需要支持传null
        TreeNode treeNode1 = TreeNode.array2TreeNode2(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8});
        Assertions.assertEquals(solution.deepestLeavesSum(treeNode1), 15);
        TreeNode treeNode2 = TreeNode.array2TreeNode(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5});
        Assertions.assertEquals(solution.deepestLeavesSum(treeNode2), 19);
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
        assertReformat("a0b1c2");
        Assertions.assertEquals(solution.reformat("leetcode"), "");
        Assertions.assertEquals(solution.reformat("1229857369"), "");
        assertReformat("covid2019");
        assertReformat("ab123");
    }

    /**
     * assert：排序等于原字符串排序，且交替是字母或字符串
     *
     * @param input 输入字符串
     */
    public void assertReformat(String input) {
        String output = solution.reformat(input);
        char[] inputArr = input.toCharArray();
        Arrays.sort(inputArr);
        char[] outputArr = output.toCharArray();
        Arrays.sort(outputArr);
        Assertions.assertEquals(Arrays.toString(inputArr), Arrays.toString(outputArr));
        //是否是字母
        if (output.length() < 1) {
            return;
        }
        boolean flag = Solution.isAlphabet(output.charAt(0));
        for (int i = 1; i < output.length(); i++) {
            if (flag) {
                Assertions.assertTrue(Solution.isNumber(output.charAt(i)));
                flag = false;
            } else {
                Assertions.assertTrue(Solution.isAlphabet(output.charAt(i)));
                flag = true;
            }
        }
    }

    /**
     * 1422. 分割字符串的最大得分
     * https://leetcode.cn/problems/maximum-score-after-splitting-a-string/
     */
    @Test
    public void no1422() {
        Assertions.assertEquals(solution.maxScore("011101"), 5);
        Assertions.assertEquals(solution.maxScore("00111"), 5);
        Assertions.assertEquals(solution.maxScore("1111"), 3);
        Assertions.assertEquals(solution.maxScore("00"), 1);
    }

    /**
     * 1450. 在既定时间做作业的学生人数
     * https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/
     */
    @Test
    public void no1450() {
        Assertions.assertEquals(solution.busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4), 1);
        Assertions.assertEquals(solution.busyStudent(new int[]{4}, new int[]{4}, 4), 1);
        Assertions.assertEquals(solution.busyStudent(new int[]{4}, new int[]{4}, 5), 0);
        Assertions.assertEquals(solution.busyStudent(new int[]{1, 1, 1, 1}, new int[]{1, 3, 2, 4}, 7), 0);
        Assertions.assertEquals(solution.busyStudent(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10}, 5), 5);
    }

    /**
     * 1455. 检查单词是否为句中其他单词的前缀
     * https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
     */
    @Test
    public void no1455() {
        Assertions.assertEquals(solution.isPrefixOfWord("i love eating burger", "burg"), 4);
        Assertions.assertEquals(solution.isPrefixOfWord("this problem is an easy problem", "pro"), 2);
        Assertions.assertEquals(solution.isPrefixOfWord("i am tired", "you"), -1);
        Assertions.assertEquals(solution.isPrefixOfWord("i use triple pillow", "pill"), 4);
        Assertions.assertEquals(solution.isPrefixOfWord("i dumb", "jiezcqu"), -1);
        Assertions.assertEquals(solution.isPrefixOfWord("b bu bur burg burger", "burg"), 4);
    }

    /**
     * 1460. 通过翻转子数组使两个数组相等
     * https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
     */
    @Test
    public void no1460() {
        Assertions.assertTrue(solution.canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
        Assertions.assertTrue(solution.canBeEqual(new int[]{7}, new int[]{7}));
        Assertions.assertFalse(solution.canBeEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11}));
    }

    /**
     * 1464. 数组中两元素的最大乘积
     * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
     */
    @Test
    public void no1464() {
        Assertions.assertEquals(solution.maxProduct(new int[]{3, 4, 5, 2}), 12);
        Assertions.assertEquals(solution.maxProduct(new int[]{1, 5, 4, 5}), 16);
        Assertions.assertEquals(solution.maxProduct(new int[]{3, 7}), 12);
    }

    /**
     * 1470. 重新排列数组
     * https://leetcode.cn/problems/shuffle-the-array/
     */
    @Test
    public void no1470() {
        Assertions.assertEquals(Arrays.toString(solution.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)), "[2, 3, 5, 4, 1, 7]");
        Assertions.assertEquals(Arrays.toString(solution.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)), "[1, 4, 2, 3, 3, 2, 4, 1]");
        Assertions.assertEquals(Arrays.toString(solution.shuffle(new int[]{1, 1, 2, 2}, 2)), "[1, 2, 1, 2]");
    }

    /**
     * 1656. 设计有序流
     * https://leetcode.cn/problems/design-an-ordered-stream/
     */
    @Test
    public void no1656() {
        OrderedStream orderedStream = new OrderedStream(5);
        Assertions.assertEquals(orderedStream.insert(3, "ccccc").size(), 0);
        Assertions.assertEquals(orderedStream.insert(1, "aaaaa").get(0), "aaaaa");
        List<String> bbbbb = orderedStream.insert(2, "bbbbb");
        Assertions.assertEquals(bbbbb.get(0), "bbbbb");
        Assertions.assertEquals(bbbbb.get(1), "ccccc");
        Assertions.assertEquals(orderedStream.insert(5, "eeeee").size(), 0);
        List<String> ddddd = orderedStream.insert(4, "ddddd");
        Assertions.assertEquals(ddddd.get(0), "ddddd");
        Assertions.assertEquals(ddddd.get(1), "eeeee");
    }

}
