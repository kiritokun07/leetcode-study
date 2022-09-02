package leetcode;

import leetcode.node.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author kirito
 * @desc ...
 * @date 2022-09-01 08:48:49
 */
public class MyClientTest_501_1000 {

    MySolution_501_1000 solution = new MySolution_501_1000();

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
     * @see MyClientTest_501_1000#no998
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
     * 687. 最长同值路径
     */
    @Test
    public void no687() {
        Assertions.assertEquals(solution.longestUnivaluePath(TreeNode.array2TreeNode2(new Integer[]{5, 4, 5, 1, 1, 5})), 2);
        Assertions.assertEquals(solution.longestUnivaluePath(TreeNode.array2TreeNode2(new Integer[]{1, 4, 5, 4, 4, 5})), 2);
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
     * @see MyClientTest_501_1000#no654 最大二叉树
     */
    @Test
    public void no998() {
        Assertions.assertTrue(TreeNode.isEqual(solution.insertIntoMaxTree(TreeNode.array2TreeNode2(new Integer[]{4, 1, 3, null, null, 2}), 5), TreeNode.array2TreeNode2(new Integer[]{5, 4, null, 1, 3, null, null, 2})));
        Assertions.assertTrue(TreeNode.isEqual(solution.insertIntoMaxTree(TreeNode.array2TreeNode2(new Integer[]{5, 2, 4, null, 1}), 3), TreeNode.array2TreeNode2(new Integer[]{5, 2, 4, null, 1, null, 3})));
        Assertions.assertTrue(TreeNode.isEqual(solution.insertIntoMaxTree(TreeNode.array2TreeNode2(new Integer[]{5, 2, 3, null, 1}), 4), TreeNode.array2TreeNode2(new Integer[]{5, 2, 4, null, 1, 3})));
    }

}
