package leetcode.node;

import lombok.Data;

@Data
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

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
            //获取其与父节点的关联，父节点下标是多少，它是父节点的左子树还是右子树
            boolean isOdd = i % 2 == 1;
            int pI;
            if (isOdd) {
                pI = (i + 3) / 2;
            } else {
                pI = (i + 2) / 2;
            }
            TreeNode pTreeNode = null;
            if (pI > 1) {
                pTreeNode = treeNodes[pI - 2];
            }
            if (pTreeNode != null) {
                //下标奇数是左子树
                if (isOdd) {
                    pTreeNode.left = treeNode;
                } else {
                    pTreeNode.right = treeNode;
                }
            }
            treeNodes[i] = treeNode;
        }
        return treeNodes[0];
    }

}