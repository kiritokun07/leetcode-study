package leetcode;

import javafx.util.Pair;
import leetcode.node.ListNode;
import leetcode.node.MyStack;
import leetcode.node.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kirito
 * @desc ...
 * @date 2022-09-01 08:49:12
 */
public class MySolution_501_1000 {

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
        int[] result = new int[n];
        MyStack myStack = new MyStack(logs.size());
        int lastId = 0;
        int lastTime = 0;
        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            String[] split = log.split(":");
            int nowId = Integer.parseInt(split[0]);
            String nowStatus = split[1];
            int nowTime = Integer.parseInt(split[2]);
            if (nowStatus.equals("start")) {
                //start
                myStack.push(Integer.parseInt(split[0]));
            } else {
                //end
                myStack.pop();
                ++nowTime;
            }
            if (lastId >= 0) {
                int deltaTime = nowTime - lastTime;
                result[lastId] = result[lastId] + deltaTime;
            }
            lastId = nowId;
            lastTime = nowTime;
            if (nowStatus.equals("end") && i < logs.size() - 1) {
                lastId = myStack.getTheHead();
            }
        }
        return result;
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

    public int findLongestChain(int[][] pairs) {
        int maxRight = Integer.MIN_VALUE;
        int result = 0;
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < pairs.length; i++) {
            int[] pair = pairs[i];
            if (pair[0] > maxRight) {
                ++result;
                maxRight = pair[1];
            }
        }
        return result;
    }

    Map<String, Pair<TreeNode, Integer>> map;
    Set<TreeNode> set;
    int idx;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        set = new HashSet<>();
        idx = 0;
        dupDfs(root);
        return new ArrayList<>(set);
    }

    /**
     * 返回节点标记序列
     *
     * @param root
     * @return
     */
    private int dupDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] tri = new int[]{root.val, dupDfs(root.left), dupDfs(root.right)};
        String hash = Arrays.toString(tri);
        if (map.containsKey(hash)) {
            Pair<TreeNode, Integer> pair = map.get(hash);
            set.add(pair.getKey());
            return pair.getValue();
        } else {
            map.put(hash, new Pair<>(root, ++idx));
            return idx;
        }
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

    public List<List<String>> printTree(TreeNode root) {
        //高度
        int height = TreeNode.getHeight(root);
        //矩阵行数
        int m = height + 1;
        //矩阵列数
        int n = (int) (Math.pow(2, height + 1) - 1);
        //初始化矩阵
        List<List<String>> result = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<String> resultI = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                resultI.add("");
            }
            result.add(resultI);
        }

        List<TreeNode> pNodeList = new ArrayList<>();
        pNodeList.add(root);
        int r = 0;
        while (!pNodeList.isEmpty()) {
            List<TreeNode> childNodeList = new ArrayList<>(pNodeList.size() * 2);
            for (TreeNode pNode : pNodeList) {
                if (pNode == root) {
                    result.get(r).set((n - 1) / 2, String.valueOf(pNode.val));
                    pNode.val = (n - 1) / 2;
                }
                int c = pNode.val;
                if (pNode.left != null) {
                    childNodeList.add(pNode.left);
                    int lc = (int) (c - Math.pow(2, height - r - 1));
                    result.get(r + 1).set(lc, String.valueOf(pNode.left.val));
                    pNode.left.val = lc;
                }
                if (pNode.right != null) {
                    childNodeList.add(pNode.right);
                    int rc = (int) (c + Math.pow(2, height - r - 1));
                    result.get(r + 1).set(rc, String.valueOf(pNode.right.val));
                    pNode.right.val = rc;
                }
            }
            ++r;
            pNodeList = childNodeList;
        }
        return result;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return arrList.stream().sorted((a, b) -> {
            if (Math.abs(a - x) != Math.abs(b - x)) {
                return Math.abs(a - x) - Math.abs(b - x);
            } else {
                return a - b;
            }
        }).limit(k).sorted().collect(Collectors.toList());
    }

    public int widthOfBinaryTree(TreeNode root) {
        int width = 1;
        List<TreeNode> pNodeList = new ArrayList<>();
        pNodeList.add(root);
        //下标列表
        List<Integer> subList = new ArrayList<>();
        subList.add(0);
        while (!pNodeList.isEmpty()) {
            List<TreeNode> childNodeList = new ArrayList<>(pNodeList.size() * 2);
            List<Integer> childSubList = new ArrayList<>(pNodeList.size() * 2);
            int minSub = subList.get(subList.size() - 1) * 2 + 1;
            int maxSub = 0;
            for (int i = 0; i < pNodeList.size(); i++) {
                TreeNode pNode = pNodeList.get(i);
                int childSub = subList.get(i);
                if (pNode.left != null) {
                    minSub = Math.min(minSub, childSub * 2);
                    maxSub = Math.max(maxSub, childSub * 2);
                    childNodeList.add(pNode.left);
                    childSubList.add(childSub * 2);
                }
                if (pNode.right != null) {
                    minSub = Math.min(minSub, childSub * 2 + 1);
                    maxSub = Math.max(maxSub, childSub * 2 + 1);
                    //tempWidth = Math.max(tempWidth, subList.get(i) * 2);
                    childNodeList.add(pNode.right);
                    childSubList.add(childSub * 2 + 1);
                }
            }
            width = Math.max(width, subList.get(subList.size() - 1) - subList.get(0) + 1);
            pNodeList = childNodeList;
            subList = childSubList;
        }
        return width;
    }

    public int[] constructArray(int n, int k) {
        //1 <= k < n <= 10^4
        //和答案相似的思路，因为1~n可以组成的差的个数的范围是[1,n-1]
        //所以当需要组成k个不同的差时，1~k+1可以组成的差的个数的范围是[1,k]（头尾互相入列），k+2~n直接落位
        int[] res = new int[n];
        int head = 1;
        int tail = k + 1;
        boolean headFirst = true;
        for (int i = 0; i < k + 1; i++) {
            if (headFirst) {
                res[i] = head;
                ++head;
            } else {
                res[i] = tail;
                --tail;
            }
            headFirst = !headFirst;
        }
        for (int i = k + 1; i < n; ++i) {
            res[i] = i + 1;
        }
        return res;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        if (val < low) {
            return trimBST(root.right, low, high);
        }
        if (val > high) {
            return trimBST(root.left, low, high);
        }
        return new TreeNode(root.val, trimBST(root.left, low, val), trimBST(root.right, val, high));
    }

    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] numChars = numStr.toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>(
                (o1, o2) -> {
                    if (o1.equals(o2)) {
                        return 1;
                    }
                    return o2 - o1;
                }
        );
        for (int i = 0; i < numChars.length; i++) {
            map.put(numChars[i], i);
        }
        List<Map.Entry<Character, Integer>> collect = new ArrayList<>(map.entrySet());
        for (int i = 0; i < collect.size(); i++) {
            int j = i;
            if (numChars[i] != collect.get(i).getKey()) {
                while (j < collect.size() - 1 && collect.get(j).getKey() == collect.get(j + 1).getKey()) {
                    ++j;
                }
                //交换，要拿当前最大值和当前值交换，如果有多个最大值，要取最后一个
                numChars[collect.get(j).getValue()] = numChars[i];
                numChars[i] = collect.get(j).getKey();
                return Integer.parseInt(String.valueOf(numChars));
            }
        }
        return num;
    }

    public int flipLights(int n, int presses) {
        return 0;
    }

    int longestPath;

    public int longestUnivaluePath(TreeNode root) {
        longestPath = 0;
        dfs(root);
        return longestPath;
    }

    /**
     * 传入root，返回当前层单边最大深度
     *
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左子树路径
        int maxLeft = dfs(root.left);
        //右子树路径
        int maxRight = dfs(root.right);
        int left = 0;
        int right = 0;
        if (root.left != null && root.val == root.left.val) {
            left = maxLeft + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            right = maxRight + 1;
        }
        longestPath = Math.max(longestPath, left + right);
        return Math.max(left, right);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        //key 数字 value 总共多少|当前头指针
        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>(Collections.reverseOrder());
        for (int num : nums) {
            sum += num;
            if (map.containsKey(num)) {
                Pair<Integer, Integer> pair = map.get(num);
                map.put(num, new Pair<>(pair.getKey() + 1, 0));
            } else {
                map.put(num, new Pair<>(1, 0));
            }
        }
        //如果sum不被k整除，返回false
        if (sum % k > 0) {
            return false;
        }
        int average = sum / k;
        for (int num : nums) {
            if (num > average) {
                return false;
            }
        }

        int successNum = 0;
        while (successNum < k) {
            //需要拼凑一个average
            int temp = 0;
            boolean isSuccess = false;
            for (Map.Entry<Integer, Pair<Integer, Integer>> entry : map.entrySet()) {
                Pair<Integer, Integer> pair = entry.getValue();
                //这步可能需要反复的取当前的key值
                while (pair.getValue() < pair.getKey() && temp + entry.getKey() <= average) {
                    temp += entry.getKey();
                    entry.setValue(new Pair<>(pair.getKey(), pair.getValue() + 1));
                    if (temp == average) {
                        isSuccess = true;
                        break;
                    }
                }
                if (isSuccess) {
                    break;
                }
            }
            if (!isSuccess) {
                return false;
            }
            ++successNum;
        }
        return true;
    }

    public int maxChunksToSorted(int[] arr) {
        return 0;
    }

    public int kthGrammar(int n, int k) {
        if (k == 1) {
            return 0;
        }
        if (k > (1 << (n - 2))) {
            return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
        }
        return kthGrammar(n - 1, k);
    }

    public int rotatedDigits(int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (canRotate(i + 1)) {
                ++res;
            }
        }
        return res;
    }

    /**
     * ASCII 不能旋转的数 3 4 7
     */
    private static final Set<Character> CAN_NOT_ROTATE_SET = new HashSet<>();

    /**
     * ASCII 旋转不变数 0 1 8
     */
    private static final Set<Character> ROTATE_NOT_CHANGE_SET = new HashSet<>();

    /**
     * ASCII 旋转后变的数 2 5 6 9
     */
    private static final Set<Character> ROTATE_CHANGE_SET = new HashSet<>();

    //0->48
    //1->49
    //2->50
    static {
        CAN_NOT_ROTATE_SET.add('3');
        CAN_NOT_ROTATE_SET.add('4');
        CAN_NOT_ROTATE_SET.add('7');

        ROTATE_NOT_CHANGE_SET.add('0');
        ROTATE_NOT_CHANGE_SET.add('1');
        ROTATE_NOT_CHANGE_SET.add('8');

        ROTATE_CHANGE_SET.add('2');
        ROTATE_CHANGE_SET.add('5');
        ROTATE_CHANGE_SET.add('6');
        ROTATE_CHANGE_SET.add('9');
    }

    /**
     * 判断一个数是否是好数 no788
     * 不能旋转的数 3 4 7
     * 旋转不变数 0 1 8
     * 旋转后变的数 2 5 6 9
     * <p>
     * 如果这个数字里存在不能旋转的数，那么必不是好数
     * 在全部都能旋转的条件下，如果这个数里存在旋转后变的数，那就是好数
     * 否则不是好数
     *
     * @return
     */
    private boolean canRotate(int n) {
        String nStr = String.valueOf(n);
        char[] nCharArray = nStr.toCharArray();
        boolean hasRotateChange = false;
        for (char c : nCharArray) {
            if (CAN_NOT_ROTATE_SET.contains(c)) {
                return false;
            }
            if (hasRotateChange) {
                continue;
            }
            if (ROTATE_CHANGE_SET.contains(c)) {
                hasRotateChange = true;
            }
        }
        return hasRotateChange;
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int times = Integer.parseInt(split[0]);
            String[] split1 = split[1].split("\\.");
            switch (split1.length) {
                case 1:
                    //"com"
                    map.merge(split1[0], times, Integer::sum);
                    break;
                case 2:
                    //"baidu.com"
                    map.merge(split1[1], times, Integer::sum);
                    map.merge(split[1], times, Integer::sum);
                    break;
                case 3:
                    //"www.baidu.com"
                    map.merge(split1[2], times, Integer::sum);
                    map.merge(split1[1] + "." + split1[2], times, Integer::sum);
                    map.merge(split[1], times, Integer::sum);
                    break;
                default:
                    break;
            }
        }
        List<String> result = new ArrayList<>(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        //false表明不开启新的一段
        boolean flag = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (!flag) {
                    flag = true;
                    ++res;
                }
            } else {
                //新的一段
                flag = false;
            }
            head = head.next;
        }
        return res;
    }

    public int uniqueLetterString(String s) {
        //存储每个元素的所有下标list
        Map<Character, List<Integer>> subListMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!subListMap.containsKey(c)) {
                subListMap.put(c, new ArrayList<>());
            }
            subListMap.get(c).add(i);
        }

        //元素只有1个时，结果是(下标+1)*(length-下标)
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : subListMap.entrySet()) {
            List<Integer> subList = entry.getValue();
            int head = -1;
            int tail = -1;
            for (int i = 0; i < subList.size(); i++) {
                tail = (i < subList.size() - 1) ? subList.get(i + 1) : s.length();
                int times = (subList.get(i) - head) * (tail - subList.get(i));
                res += times;
                head = subList.get(i);
            }
        }
        return res;
    }

    public int scoreOfParentheses(String s) {
        int res = 0;
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //计算当前深度
            if (c == '(') {
                ++depth;
            } else {
                --depth;
            }
            //最底层只有一个完整的括号
            //如果是2层的完整括号，那么res+=2^1
            //如果是3层的完整括号，那么res+=2^2
            //如果是n层的，那么res+=2^(n-1)
            //1<<n=2^n
            if (c == ')' && s.charAt(i - 1) == '(') {
                res += 1 << depth;
            }
        }
        return res;
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        double[][] rate = new double[len][2];
        for (int i = 0; i < len; i++) {
            rate[i][0] = wage[i] * 1.0 / quality[i];
            rate[i][1] = i * 1.0;
        }
        //按比值升序排序
        Arrays.sort(rate, Comparator.comparingDouble(a -> a[0]));
        //需要符合比值要求的最小k个quality，所以构造最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        double totalK = 0;
        for (int i = 0; i < k; i++) {
            int sub = (int) rate[i][1];
            totalK += quality[sub];
            queue.add(quality[sub]);
        }
        double result = totalK * rate[k - 1][0];
        for (int i = k; i < len; i++) {
            int sub = (int) rate[i][1];
            totalK += quality[sub];
            queue.add(quality[sub]);
            totalK -= queue.poll();
            //计算result
            result = Math.min(result, totalK * rate[i][0]);
        }
        return result;
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums2.length;
        int[] res = new int[len];
        Integer[] subList = new Integer[len];
        for (int i = 0; i < len; i++) {
            subList[i] = i;
        }
        Arrays.sort(nums1);
        Arrays.sort(subList, Comparator.comparingInt(a -> nums2[a]));
        int left = 0;
        int right = len - 1;
        for (int num : nums1) {
            //田忌赛马，
            int sub;
            if (num > nums2[subList[left]]) {
                sub = subList[left];
                ++left;
            } else {
                sub = subList[right];
                --right;
            }
            res[sub] = num; //和nums2的值对应起来，所以不是按顺序填充数组
        }
        return res;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        //Arrays.sort(dislikes, Comparator.comparingInt(a -> a[0]));
        //Set<Integer> aSet = new HashSet<>(n);
        //Set<Integer> bSet = new HashSet<>(n);
        //for (int i = 0; i < dislikes.length; i++) {
        //    int[] dislike = dislikes[i];
        //    int a = dislike[0];
        //    int b = dislike[1];
        //    if (aSet.contains(a)) {
        //        if (aSet.contains(b)) {
        //            return false;
        //        }
        //        bSet.add(b);
        //        continue;
        //    }
        //    if (bSet.contains(a)) {
        //        if (bSet.contains(b)) {
        //            return false;
        //        }
        //        aSet.add(b);
        //        continue;
        //    }
        //    if (aSet.contains(b)) {
        //        if (aSet.contains(a)) {
        //            return false;
        //        }
        //        bSet.add(a);
        //        continue;
        //    }
        //    if (bSet.contains(b)) {
        //        if (bSet.contains(a)) {
        //            return false;
        //        }
        //        aSet.add(a);
        //        continue;
        //    }
        //    aSet.add(a);
        //    bSet.add(b);
        //}
        return true;
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

    static class StockSpanner {

        private int flag;
        private final int[] value1List; //记录price
        private final int[] value2List; //记录满足题目要求的连续日的最小下标
        private final int[] value3List; //next(price)返回的参数

        public StockSpanner() {
            flag = -1;
            value1List = new int[10000];
            value2List = new int[10000];
            value3List = new int[10000];
        }

        public int next(int price) {
            ++flag;
            int value2;
            int value3;
            if (flag == 0) {
                value2 = flag;
                value3 = 1;
            } else {
                int lastValue1 = value1List[flag - 1];
                //如果value[i+1]<value[i] 返回1
                //如果== 返回dp[i]+1
                //如果> 返回dp[i]+value2[i]开始向左所有满足要求的数量
                if (price < lastValue1) {
                    value2 = flag;
                    value3 = 1;
                } else if (price == lastValue1) {
                    value2 = value2List[flag - 1];
                    value3 = value3List[flag - 1] + 1;
                } else {
                    //int lastValue2 = value2List[flag - 1];
                    int lastValue3 = value2List[flag - 1];
                    int curse = lastValue3 - 1;
                    int count = 1;
                    while (curse >= 0 && price >= value1List[curse]) {
                        --curse;
                        ++count; //包括自己和已经前进的数量
                    }
                    value2 = curse + 1;
                    value3 = value3List[flag - 1] + count;
                }
            }
            value1List[flag] = price;
            value2List[flag] = value2;
            value3List[flag] = value3;
            return value3;
        }
    }

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                Integer le = map.get(fruits[left]);
                if (le != null) {
                    if (le > 1) {
                        map.put(fruits[left], le - 1);
                    } else {
                        map.remove(fruits[left]);
                    }
                }
                ++left;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] minRightList = new int[len];
        minRightList[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; --i) {
            minRightList[i] = Math.min(minRightList[i + 1], nums[i]);
        }

        int[] maxLeftList = new int[len];
        maxLeftList[0] = nums[0];
        for (int i = 1; i < len; i++) {
            maxLeftList[i] = Math.max(maxLeftList[i - 1], nums[i]);
        }
        for (int i = 0; i < len - 1; i++) {
            if (maxLeftList[i] <= minRightList[i + 1]) {
                return i + 1;
            }
        }
        return len - 1;
    }

    public int minAddToMakeValid(String s) {
        int res = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ++current;
            } else {
                //)
                if (current > 0) {
                    --current;
                } else {
                    ++res;
                }
            }
        }
        res += current;
        return res;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        //int i=pushed.length;
        //int j=i;
        int curse = 0;
        MyStack myStack = new MyStack(pushed.length);
        for (int j = 0; j < popped.length; j++) {
            //如果栈空就入栈
            if (myStack.isEmpty()) {
                myStack.push(pushed[curse]);
                ++curse;
            }
            //先判断栈顶元素和popI是否相同
            //如果不同就入栈，再判断栈顶
            while (myStack.getTheHead() != popped[j] && curse < pushed.length) {
                myStack.push(pushed[curse]);
                ++curse;
            }
            if (curse == pushed.length && myStack.getTheHead() != popped[j]) {
                return false;
            }
            myStack.pop();
        }
        return true;
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            TreeNode result = new TreeNode(val);
            result.left = root;
            return result;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }

}
