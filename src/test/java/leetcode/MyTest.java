package leetcode;

import leetcode.node.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kirito
 * @desc ...
 * @date 2022-08-05 17:29:08
 */
public class MyTest {

    /**
     * 二叉树
     * ----4
     * --2     6
     * 3  1   5
     */
    @Test
    public void testArray2TreeNode() {
        Integer[] root = new Integer[]{4, 2, 6, 3, 1, 5};
        TreeNode array2TreeNode = TreeNode.array2TreeNode(root);

        TreeNode four = new TreeNode(3, null, null);
        TreeNode five = new TreeNode(1, null, null);
        TreeNode six = new TreeNode(5, null, null);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode three = new TreeNode(6, six, null);
        TreeNode one = new TreeNode(4, two, three);

        //判断array2TreeNode和one一样
        assert array2TreeNode != null;
        Assertions.assertEquals(array2TreeNode.val, one.val);
        Assertions.assertEquals(array2TreeNode.left.val, one.left.val);
        Assertions.assertEquals(array2TreeNode.right.val, one.right.val);
        Assertions.assertEquals(array2TreeNode.left.left.val, one.left.left.val);
        Assertions.assertEquals(array2TreeNode.left.right.val, one.left.right.val);
        Assertions.assertEquals(array2TreeNode.right.left.val, one.right.left.val);
    }

    @Test
    public void testEqual() {
        Integer[] root = new Integer[]{4, 2, 6, 3, 1, 5};
        TreeNode array2TreeNode = TreeNode.array2TreeNode(root);
        TreeNode four = new TreeNode(3, null, null);
        TreeNode five = new TreeNode(1, null, null);
        TreeNode six = new TreeNode(5, null, null);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode three = new TreeNode(6, six, null);
        TreeNode one = new TreeNode(4, two, three);

        Assertions.assertTrue(TreeNode.isEqual(array2TreeNode, one));
    }

    @Test
    public void testHeight() {
        Assertions.assertEquals(TreeNode.getHeight(TreeNode.array2TreeNode(new Integer[]{1, 2})), 1);
        Assertions.assertEquals(TreeNode.getHeight(TreeNode.array2TreeNode(new Integer[]{1,2,3,null,4})), 2);
    }

}
