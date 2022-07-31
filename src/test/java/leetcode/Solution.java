package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kirito
 * @desc ...
 * @date 2022-07-31 15:34:22
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void printNode(ListNode l) {
        while (l != null) {
            System.out.print(l.val);
            l = l.next;
        }
        System.out.println("");
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
        return 0;
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

}
