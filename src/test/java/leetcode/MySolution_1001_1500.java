package leetcode;

import leetcode.node.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kirito
 * @desc ...
 * @date 2022-09-01 08:49:12
 */
public class MySolution_1001_1500 {

    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            if (i == 0) {
                sb.append(alphaStart2End('a', target.charAt(i)));
            } else {
                sb.append(alphaStart2End(target.charAt(i - 1), target.charAt(i)));
            }
            sb.append(SELECT);
        }
        return sb.toString();
    }

    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char SELECT = '!';

    //abcde 97~101
    //fghij 102~106
    //klmno 107~111
    //pqrst 112~116
    //uvwxy 117~121
    //z     122
    private StringBuilder alphaStart2End(char start, char end) {
        if (start == end) {
            return new StringBuilder();
        }
        if (start == 'z') {
            //先上移一层，再u->end
            return new StringBuilder().append(UP).append(alphaStart2End('u', end));
        }
        if (end == 'z') {
            //先移到u再下移一层
            return alphaStart2End(start, 'u').append(DOWN);
            //先左移到最左再往下
        }
        int startI = (start - 97) / 5;
        int startJ = (start - 97) % 5;
        int endI = (end - 97) / 5;
        int endJ = (end - 97) % 5;
        //假如end=='o' 111
        //111-97=14
        //14/5=2...4
        //坐标是(2,4)
        //
        //假如end=='s' 115
        //115-97=18
        //15/5=3...3
        //坐标是(3,3)
        StringBuilder sb = new StringBuilder();
        if (endI > startI) {
            for (int i = 0; i < endI - startI; ++i) {
                sb.append(DOWN);
            }
        } else if (startI > endI) {
            for (int i = 0; i < startI - endI; ++i) {
                sb.append(UP);
            }
        }

        if (endJ > startJ) {
            for (int i = 0; i < endJ - startJ; ++i) {
                sb.append(RIGHT);
            }
        } else if (startJ > endJ) {
            for (int i = 0; i < startJ - endJ; ++i) {
                sb.append(LEFT);
            }
        }
        return sb;
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

    public int maxEqualFreq(int[] nums) {
        //值的频次
        Map<Integer, Integer> numTimeMap = new HashMap<>();
        //频次的频次
        Map<Integer, Integer> timeTimeMap = new HashMap<>();
        int res = 0;
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer sub = numTimeMap.get(num);
            if (sub != null) {
                //归位
                timeTimeMap.put(sub, timeTimeMap.get(sub) - 1);
            }
            if (sub != null) {
                ++sub;
            } else {
                sub = 1;
            }
            numTimeMap.put(num, sub);
            timeTimeMap.merge(sub, 1, Integer::sum);
            maxFreq = Math.max(maxFreq, numTimeMap.get(num));
            //判断当前map是否符合条件
            //1.最大频次为1
            //2.只有maxFreq和maxFreq-1（意思是加起来等于i+1），且前者只有1个，不能判断size==2，因为有可能value是0
            //3.只有一个1，其余都是maxFreq
            boolean ok = maxFreq == 1
                    || (timeTimeMap.get(maxFreq) == 1 && timeTimeMap.get(maxFreq) * maxFreq + timeTimeMap.get(maxFreq - 1) * (maxFreq - 1) == i + 1)
                    || (timeTimeMap.get(1) == 1 && timeTimeMap.get(maxFreq) * maxFreq + 1 == i + 1);
            if (ok) {
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }

    public List<String> removeSubfolders(String[] folder) {
        //字典树
        MyTreeNode root = new MyTreeNode();
        for (String path : folder) {
            String[] split = path.split("/");
            //第一个/前面是空的
            root.insert(path);
        }
        //找这颗字典树所有第一个有效子节点（有效的意思是这个节点必须是路径的终点，第一个的意思是找到这个就不再递归找了）
        List<String> res = new ArrayList<>(folder.length);
        dfsTree(folder, root, res);
        return res;
    }

    public class MyTreeNode {
        public Map<String, MyTreeNode> node;
        //下标
        public int sub = -1;


        public void insert(String path) {

        }

    }

    private void dfsTree(String[] folder, MyTreeNode root, List<String> res) {

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

    public List<String> buildArray(int[] target, int n) {
        int maxI = target[target.length - 1];
        List<String> res = new ArrayList<>(2 * maxI);
        int curse = 0;
        for (int i = 1; i <= maxI; i++) {
            if (i == target[curse]) {
                res.add("Push");
                ++curse;
            } else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
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

    public int isPrefixOfWord(String sentence, String searchWord) {
        int curse = 0;
        int times = 1;
        boolean flag = false;
        while (sentence.length() - curse >= searchWord.length()) {
            flag = true;
            //如果当前字符串为空，就跳过
            char charI = sentence.charAt(curse);
            if (charI == 32) {
                ++curse;
                ++times;
                flag = false;
                continue;
            }
            //判断是否为前缀，即searchWord的每个单词都和sentence的相等
            //如果判断不相等了，需要跳到空格处
            for (int i = 0; i < searchWord.length(); i++) {
                if (sentence.charAt(curse) == 32) {
                    flag = false;
                    break;
                }
                if (searchWord.charAt(i) != sentence.charAt(curse)) {
                    flag = false;
                    ++curse;
                    break;
                }
                ++curse;
            }
            if (flag) {
                break;
            }
            while (curse < sentence.length() - 1 && sentence.charAt(curse) != 32) {
                ++curse;
            }
        }
        if (flag) {
            return times;
        }
        return -1;
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public int maxProduct(int[] nums) {
        //a是top1
        int a = Math.max(nums[0], nums[1]);
        //b是top2
        int b = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];
            //如果小于b，跳过
            if (num < b) {
                continue;
            }
            //如果这个数大于b，就把它变成b，再重分配a b
            b = num;
            int temp = Math.max(a, b);
            b = Math.min(a, b);
            a = temp;
        }
        return (a - 1) * (b - 1);
    }

    public int[] shuffle(int[] nums, int n) {
        int length = nums.length;
        int[] res = new int[length];
        for (int i = 0; i < length / 2; i++) {
            res[i * 2] = nums[i];
            res[i * 2 + 1] = nums[i + length / 2];
        }
        return res;
    }

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!deque.isEmpty() && prices[i] < deque.peek()) {
                deque.pop();
            }
            res[i] = deque.isEmpty() ? prices[i] : prices[i] - deque.peek();
            deque.push(prices[i]);
        }
        return res;
    }

}
