package leetcode;

import leetcode.node.ListNode;
import leetcode.node.TreeNode;

import java.util.*;

/**
 * LeetCode题解
 *
 * @author kirito
 * @desc ...
 * @date 2022-07-31 15:34:22
 */
public class Solution {

    public void printNode(ListNode l) {
        while (l != null) {
            System.out.print(l.val);
            l = l.next;
        }
        System.out.println("");
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            int len = result.length();
            if (len < 1) {
                result = "";
                break;
            }
            int len2 = Math.min(result.length(), strs[i].length());
            result = result.substring(0, len2);
            if (len2 < 1) {
                result = "";
                break;
            }
            for (int j = 0; j < len2; ++j) {
                if (result.charAt(j) != strs[i].charAt(j)) {
                    result = result.substring(0, j);
                    break;
                }
            }
        }
        return result;
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        List<TreeNode> pNodeList = new ArrayList<>();
        pNodeList.add(root);
        for (int level = 2; !pNodeList.isEmpty(); ++level) {
            if (level == depth) {
                break;
            }
            List<TreeNode> childNodeList = new ArrayList<>();
            for (TreeNode pNode : pNodeList) {
                if (pNode.left != null) {
                    childNodeList.add(pNode.left);
                }
                if (pNode.right != null) {
                    childNodeList.add(pNode.right);
                }
            }
            pNodeList = childNodeList;
        }
        for (TreeNode pNode : pNodeList) {
            TreeNode left = new TreeNode(val, pNode.left, null);
            TreeNode right = new TreeNode(val, null, pNode.right);
            pNode.left = left;
            pNode.right = right;
        }
        return root;
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        return null;
    }

    public String orderlyQueue(String s, int k) {
        if (k == 0) {
            return s;
        }
        if (k == 1) {
            //for循环n次
            String minS = s;
            int length = s.length();
            for (int i = 1; i < length; ++i) {
                String tempS = s.substring(i, length) + s.substring(0, i);
                //如果小于最小s就返回s
                if (tempS.compareTo(minS) < 0) {
                    minS = tempS;
                }
            }
            return minS;
        }
        //直接输出升序排序
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = new ListNode(head.val);
        ListNode b = a;
        while (head != null) {
            if (head.next != null) {
                if (head.next.val != a.val) {
                    a.next = head.next;
                    a = a.next;
                }
            }
            head = head.next;
        }
        a.next = null;
        return b;
    }

    public int maxLevelSum(TreeNode root) {
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);
        int maxSum = root.val;
        int ans = 1;
        for (int level = 1; !rootList.isEmpty(); ++level) {
            int sum = 0;
            List<TreeNode> childNodeList = new ArrayList<>();
            for (TreeNode node : rootList) {
                sum += node.val;
                if (node.left != null) {
                    childNodeList.add(node.left);
                }
                if (node.right != null) {
                    childNodeList.add(node.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                ans = level;
            }
            rootList = childNodeList;

        }
        return ans;
    }

    public int[] arrayRankTransform(int[] arr) {
        if (arr.length < 1) {
            return new int[0];
        }
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        //key 数字 value 序号
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        map.put(sortedArr[0], 1);
        int num = 1;
        for (int i = 1; i < sortedArr.length; i++) {
            if (sortedArr[i] != sortedArr[i - 1]) {
                ++num;
                map.put(sortedArr[i], num);
            }
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder(n);
        if (n % 2 == 1) {
            //奇数
            for (int i = 0; i < n; i++) {
                sb.append("a");
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                sb.append("a");
            }
            sb.append("b");
        }
        return sb.toString();
    }

    public List<Integer> minSubsequence(int[] nums) {
        //降序排序，选刚好大于剩余的前缀序列
        List<Integer> result = new ArrayList<>(nums.length);
        for (int num : nums) {
            result.add(num);
        }
        Collections.sort(result);
        Collections.reverse(result);
        Integer sum = result.stream().reduce(0, Integer::sum);
        int tempSum = 0;
        for (int i = 0; i < result.size(); i++) {
            tempSum += result.get(i);
            if (tempSum > sum - tempSum) {
                return result.subList(0, i + 1);
            }
        }
        return result;
    }

    public List<String> stringMatching(String[] words) {
        Set<String> matchSet = new HashSet<>(words.length);
        for (int i = 0; i < words.length; i++) {
            String wordI = words[i];
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (words[j].contains(wordI)) {
                    matchSet.add(wordI);
                }
            }
        }
        return new ArrayList<>(matchSet);
    }

    public int minStartValue(int[] nums) {
        int sum = nums[0];
        int sMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i];
            sMin = Math.min(sMin, sum);
        }
        if (sMin > 0) {
            return 1;
        }
        return 1 - sMin;
    }

}
