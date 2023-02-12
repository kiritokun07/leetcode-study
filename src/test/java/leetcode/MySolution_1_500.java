package leetcode;

import leetcode.node.ListNode;

import java.util.Arrays;

/**
 * @author kirito
 * @desc ...
 * @date 2022-07-31 15:34:22
 */
public class MySolution_1_500 {

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0, head);
        ListNode h1 = pre;
        ListNode h2 = pre;
        for (int i = 0; i < n + 1; ++i) {
            h1 = h1.next;
        }
        while (h1 != null) {
            h1 = h1.next;
            h2 = h2.next;
        }
        h2.next = h2.next.next;
        return pre.next;
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

    public int firstBadVersion(int n) {
        return findBetween(1, n);
    }

    private int findBetween(int start, int end) {
        if (start > end) {
            return 0;
        }
        int i = start + (end - start) / 2;
        boolean isBad = isBadVersion(i);
        if (!isBad) {
            return findBetween(i + 1, end);
        }
        if (i == 0 || !isBadVersion(i - 1)) {
            return i;
        }
        return findBetween(start, i - 1);
    }

    private boolean isBadVersion(int i) {
        return i >= 1702766719;
    }

    public int bulbSwitch(int n) {
        return 0;
    }

    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int[][] memo = new int[length][length];
        for (int i = 0; i < length; ++i) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return dfsPredict(nums, 0, length - 1, memo) >= 0;
    }

    /**
     * 返回第一个人比第二个多多少分
     */
    private int dfsPredict(int[] nums, int i, int j, int[][] memo) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        memo[i][j] = Math.max(nums[i] - dfsPredict(nums, i + 1, j, memo),
                nums[j] - dfsPredict(nums, i, j - 1, memo));
        return memo[i][j];
    }

}
