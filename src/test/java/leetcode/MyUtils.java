package leetcode;

import leetcode.node.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kirito
 * @desc ...
 * @date 2022-08-05 10:55:43
 */
public class MyUtils {

    /**
     * 数组转二叉树
     *
     * @param nums
     * @return
     */
    public static TreeNode array2TreeNode(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        TreeNode[] treeNodes = new TreeNode[nums.length];
        //通过下标判断父节点
        for (int i = 0; i < nums.length; i++) {
            //第i个数字
            int num = nums[i];
            TreeNode treeNode = new TreeNode(num, null, null);
            //TODO 获取其与父节点的关联，父节点下标是多少，它是父节点的左子树还是右子树

            treeNodes[i] = treeNode;
        }
        return treeNodes[0];
    }

    /**
     * 二叉树
     * 4
     * 2     6
     * 3  1   5
     */
    @Test
    public void testArray2TreeNode() {
        int[] root = new int[]{4, 2, 6, 3, 1, 5};
        TreeNode array2TreeNode = array2TreeNode(root);

        TreeNode four = new TreeNode(3, null, null);
        TreeNode five = new TreeNode(1, null, null);
        TreeNode six = new TreeNode(5, null, null);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode three = new TreeNode(6, six, null);
        TreeNode one = new TreeNode(4, two, three);

        //判断array2TreeNode和one一样
        Assertions.assertEquals(array2TreeNode.val, one.val);
        Assertions.assertEquals(array2TreeNode.left.val, one.left.val);
        Assertions.assertEquals(array2TreeNode.right.val, one.right.val);
        Assertions.assertEquals(array2TreeNode.left.left.val, one.left.left.val);
        Assertions.assertEquals(array2TreeNode.left.right.val, one.left.right.val);
        Assertions.assertEquals(array2TreeNode.right.left.val, one.right.left.val);
    }

}
