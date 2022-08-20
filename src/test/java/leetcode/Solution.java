package leetcode;

import leetcode.node.ListNode;
import leetcode.node.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

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

    public static void main(String[] args) {
        String a = "abc+-x";
        for (int i = 0; i < a.length(); i++) {
            System.out.println("a.charAt(i) = " + a.charAt(i));
        }

    }

    /**
     * 用+号-号分隔左边和右边，提取左边和右边的
     * 然后计算1次项、0次项：ax+b=0
     * x=x   0x+0=0
     * 如果a==0&&b==0，返回"Infinite solutions"
     * x=x+2  0x-2=0
     * 如果a==0&&b!=0，返回"No solution"
     * 否则返回x=-b/a
     *
     * @param equation
     * @return
     */
    public String solveEquation(String equation) {
        //用=分割左边和右边，（左边）-（右边）=0
        String[] split = equation.split("=");
        String leftStr = split[0];
        String rightStr = split[1];

        int leftLen = leftStr.length();
        int rightLen = rightStr.length();

        int a = 0;
        int b = 0;
        int tempA = 0;
        String tempStr = "";
        int tempB = 0;

        //左边字符串循环
        for (int i = 0; i < leftLen; i++) {
            char leftI = leftStr.charAt(i);
            //如果==x 120，是结尾
            if (leftI == 120) {
                //如果字符串是空的，那么tempA=1，否则就parse
                switch (tempStr) {
                    case "":
                        tempA = 1;
                        break;
                    case "+":
                        tempA = 1;
                        break;
                    case "-":
                        tempA = -1;
                        break;
                    default:
                        tempA = Integer.parseInt(tempStr);
                        break;
                }
                a += tempA;
                continue;
            }
            //如果== +/- 43 45
            if (leftI == 43 || leftI == 45) { //为+或-
                tempStr = "" + leftI;
                continue;
            }
            //剩下情况是数字
            //数字的下一位可能是：数字、x、+/-、无
            //+/-、无，是结尾
            if (i == leftLen - 1 || (leftStr.charAt(i + 1) == 43 || leftStr.charAt(i + 1) == 45)) {
                tempStr = tempStr + leftI;
                tempB = Integer.parseInt(tempStr);
                b += tempB;
                continue;
            }
            //数字、x可以继续
            tempStr = tempStr + leftI;
        }
        tempA = 0;
        tempStr = "";
        tempB = 0;
        //右边字符串循环
        for (int i = 0; i < rightLen; i++) {
            char rightI = rightStr.charAt(i);
            //如果==x 120，是结尾
            if (rightI == 120) {
                //如果字符串是空的，那么tempA=1，否则就parse
                switch (tempStr) {
                    case "":
                        tempA = 1;
                        break;
                    case "+":
                        tempA = 1;
                        break;
                    case "-":
                        tempA = -1;
                        break;
                    default:
                        tempA = Integer.parseInt(tempStr);
                        break;
                }
                a -= tempA;
                continue;
            }
            //如果== +/- 43 45
            if (rightI == 43 || rightI == 45) { //为+或-
                tempStr = "" + rightI;
                continue;
            }
            //剩下情况是数字
            //数字的下一位可能是：数字、x、+/-、无
            //+/-、无，是结尾
            if (i == rightLen - 1 || (rightStr.charAt(i + 1) == 43 || rightStr.charAt(i + 1) == 45)) {
                tempStr = tempStr + rightI;
                tempB = Integer.parseInt(tempStr);
                b -= tempB;
                continue;
            }
            //数字、x可以继续
            tempStr = tempStr + rightI;
        }
        if (a == 0 && b == 0) {
            return "Infinite solutions";
        }
        if (a == 0 && b != 0) {
            return "No solution";
        }
        return "x=" + (-b / a);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return generateConstruct(nums, 0, nums.length);
    }

    private TreeNode generateConstruct(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        int maxNum = nums[left];
        int maxNumSub = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > maxNum) {
                maxNumSub = i;
                maxNum = nums[i];
            }
        }
        TreeNode treeNode = new TreeNode(maxNum);
        treeNode.left = generateConstruct(nums, left, maxNumSub);
        treeNode.right = generateConstruct(nums, maxNumSub + 1, right);
        return treeNode;
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

    public static class NumberAndSubScript {
        private Integer num;
        private Integer sub;

        public NumberAndSubScript(int num, int sub) {
            this.num = num;
            this.sub = sub;
        }

        public Integer getNum() {
            return num;
        }

        public Integer getSub() {
            return sub;
        }
    }

    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> numTimesMap = new HashMap<>();
        //Map<Integer, Integer> timesNumMap = new HashMap<>();
        int result = 0;
        //int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            numTimesMap.merge(num, 1, Integer::sum);
            if (numTimesMap.size() == 1) {
                //if (numTimesMap.values().iterator().next() == 1) {
                result = i;
                //}
                continue;
            }
            //如果符合条件就更新result
            //条件是：判断是否只有一个元素的数量比其他元素个数多1个
            //有可能是：2 2 3
            //有可能是：1 n n
            //有可能是：1 1 1 1 2|2
            //有可能是：1 1 1 1 1
            //不能是：2 2 2 2 2
            //有可能是 2 3
            List<Integer> timesList = numTimesMap.values().stream().sorted().collect(Collectors.toList());
            if (timesList.size() == 2) {
                if (timesList.get(0) == 1) {
                    result = i;
                    continue;
                }
                if (Math.abs(timesList.get(0) - timesList.get(1)) == 1) {
                    result = i;
                    continue;
                }
            }
            //size>=3的情况
            boolean flag = true;
            if (!timesList.get(0).equals(timesList.get(1))) {
                //第一个值和第二个值不相同
                //如果第一个值是1，那么其他值必须都相同
                if (timesList.get(0) == 1) {
                    for (int i1 = 1; i1 < timesList.size() - 1; i1++) {
                        if (!timesList.get(i1).equals(timesList.get(i1 + 1))) {
                            flag = false;
                            break;
                        }
                    }
                } else {
                    continue;
                }
            } else if (!timesList.get(timesList.size() - 1).equals(timesList.get(timesList.size() - 2))) {
                //倒一和倒二不相同
                //判断最后一个值为其他值+1
                for (int i1 = 0; i1 < timesList.size() - 1; i1++) {
                    if (!timesList.get(i1).equals(timesList.get(timesList.size() - 1) - 1)) {
                        flag = false;
                        break;
                    }
                }
            } else {
                //如果都是1也可以
                for (Integer ti : timesList) {
                    if (!ti.equals(1)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                result = i;
            }
        }
        return result + 1;
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int length = groupSizes.length;
        List<NumberAndSubScript> numberAndSubScriptList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            numberAndSubScriptList.add(new NumberAndSubScript(groupSizes[i], i));
        }
        //排序
        numberAndSubScriptList = numberAndSubScriptList.stream().sorted(Comparator.comparing(NumberAndSubScript::getNum)).collect(Collectors.toList());
        int i = 0;
        List<List<Integer>> peopleListList = new ArrayList<>();
        while (i < length) {
            int first = numberAndSubScriptList.get(i).getNum();
            List<Integer> peopleList = new ArrayList<>(first);
            for (int j = 0; j < first; j++) {
                peopleList.add(numberAndSubScriptList.get(i).getSub());
                ++i;
            }
            peopleListList.add(peopleList);
        }
        return peopleListList;
    }

    public int deepestLeavesSum(TreeNode root) {
        List<TreeNode> pNodeList = new ArrayList<>();
        pNodeList.add(root);
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
            if (childNodeList.isEmpty()) {
                int sum = 0;
                for (TreeNode pNode : pNodeList) {
                    sum += pNode.val;
                }
                return sum;
            }
            pNodeList = childNodeList;
        }
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

    public String reformat(String s) {
        StringBuilder alphaSb = new StringBuilder();
        StringBuilder numberSb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isAlphabet(s.charAt(i))) {
                alphaSb.append(s.charAt(i));
            } else {
                numberSb.append(s.charAt(i));
            }
        }
        //筛出字母
        String alphabetStr = alphaSb.toString();
        //筛出数字
        String numberStr = numberSb.toString();
        //如果length差超过1就返回空字符串
        if (Math.abs(alphabetStr.length() - numberStr.length()) > 1) {
            return "";
        }
        StringBuilder result = new StringBuilder(s.length());
        //当前是否选字母
        boolean isAlphabet = alphabetStr.length() > numberStr.length();
        int i = 0;
        int j = 0;
        while (true) {
            if (isAlphabet) {
                result.append(alphabetStr.charAt(i));
                ++i;
            } else {
                result.append(numberStr.charAt(j));
                ++j;
            }
            isAlphabet = !isAlphabet;
            if (i >= alphabetStr.length() && j >= numberStr.length()) {
                break;
            }
        }
        return result.toString();
    }

    /**
     * 字符   a  z
     * ascii 97 122
     */
    public static boolean isAlphabet(char ch) {
        return ch >= 97 && ch <= 122;
    }

    /**
     * 字符   0  9
     * ascii 48 57
     */
    public static boolean isNumber(char ch) {
        return ch >= 48 && ch <= 57;
    }

    public int maxScore(String s) {
        int oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            //1的个数
            if (s.charAt(i) == 49) {
                ++oneCount;
            }
        }
        int currentScore = oneCount;
        int maxScore = oneCount;
        //如果开头是0
        if (s.charAt(0) == 48) {
            ++currentScore;
            ++maxScore;
        } else {
            --currentScore;
            --maxScore;
        }
        for (int i = 1; i < s.length() - 1; i++) {
            //如果是0
            if (s.charAt(i) == 48) {
                ++currentScore;
            } else {
                --currentScore;
            }
            maxScore = Math.max(currentScore, maxScore);
        }
        return maxScore;
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            int startI = startTime[i];
            int endI = endTime[i];
            if (startI <= queryTime && queryTime <= endI) {
                ++count;
            }
        }
        return count;
    }

}
