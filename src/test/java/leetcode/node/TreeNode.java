package leetcode.node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@Data
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
     * 数组转二叉树 数组是满的，就是说null的子树也要给
     *
     * @param nums
     * @return
     */
    public static TreeNode array2TreeNode(Integer[] nums) {
        if (nums.length < 1) {
            return null;
        }
        TreeNode[] treeNodes = new TreeNode[nums.length];
        //通过下标判断父节点
        for (int i = 0; i < nums.length; i++) {
            //第i个数字
            Integer num = nums[i];
            TreeNode treeNode;
            if (num == null) {
                treeNode = null;
            } else {
                treeNode = new TreeNode(num, null, null);
            }
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

    /**
     * 数组转二叉树2 为null的树，子树不提供直接跳过
     *
     * @param nums
     * @return
     */
    public static TreeNode array2TreeNode2(Integer[] nums) {
        if (nums.length < 1) {
            return null;
        }
        TreeNode[] treeNodes = new TreeNode[nums.length];
        //当前层级
        //int level = 1;

        List<TreeNode> pNodeList = new ArrayList<>();
        pNodeList.add(new TreeNode(nums[0], null, null));
        int curse = 0;
        int curse2 = 1;
        while (!pNodeList.isEmpty() && curse2 < nums.length) {
            List<TreeNode> childNodeList = new ArrayList<>(pNodeList.size() * 2);
            for (TreeNode treeNode : pNodeList) {
                treeNodes[curse] = treeNode;
                ++curse;
                if (curse2 >= nums.length) {
                    break;
                }
                Integer leftNodeValue = nums[curse2];
                TreeNode leftChildNode;
                if (leftNodeValue == null) {
                    leftChildNode = null;
                } else {
                    leftChildNode = new TreeNode(leftNodeValue, null, null);
                    childNodeList.add(leftChildNode);
                }
                treeNode.left = leftChildNode;
                ++curse2;
                if (curse2 >= nums.length) {
                    break;
                }
                Integer rightNodeValue = nums[curse2];
                TreeNode rightChildNode;
                if (rightNodeValue == null) {
                    rightChildNode = null;
                } else {
                    rightChildNode = new TreeNode(rightNodeValue, null, null);
                    childNodeList.add(rightChildNode);
                }
                treeNode.right = rightChildNode;
                ++curse2;
            }
            if (curse2 >= nums.length) {
                break;
            }
            pNodeList = childNodeList;
        }
        return treeNodes[0];
    }

    /**
     * 判断两个TreeNode相等
     *
     * @return
     */
    public static boolean isEqual(TreeNode a, TreeNode b) {
        if (a == b) {
            return true;
        }
        if (a != null && b == null) {
            return false;
        }
        if (a == null && b != null) {
            return false;
        }
        if (a == null && b == null) {
            return true;
        }
        if (!Objects.equals(a.val, b.val)) {
            return false;
        }
        return isEqual(a.left, b.left) && isEqual(a.right, b.right);
    }

    /**
     * 获取树的高度（[1,2]高度=1）
     *
     * @return
     */
    public static int getHeight(TreeNode root) {
        List<TreeNode> pNodeList = new ArrayList<>();
        pNodeList.add(root);
        int height = -1;
        while (!pNodeList.isEmpty()) {
            List<TreeNode> childNodeList = new ArrayList<>(pNodeList.size() * 2);
            for (TreeNode pNode : pNodeList) {
                if (pNode.left != null) {
                    childNodeList.add(pNode.left);
                }
                if (pNode.right != null) {
                    childNodeList.add(pNode.right);
                }
            }
            pNodeList = childNodeList;
            ++height;
        }
        return height;
    }

}