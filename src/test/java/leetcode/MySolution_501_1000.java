package leetcode;

import javafx.util.Pair;
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
