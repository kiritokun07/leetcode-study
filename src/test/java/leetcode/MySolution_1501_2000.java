package leetcode;

import leetcode.node.ListNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kirito
 * @desc ...
 * @date 2022-09-01 08:49:12
 */
public class MySolution_1501_2000 {

    public int findLengthOfShortestSubarray(int[] arr) {
        int length = arr.length;
        for (int i = length - 1; i >= 0; i++) {

        }
        return 0;
    }

    public int numSpecial(int[][] mat) {
        //行数
        int row = mat.length;
        //列数
        int col = mat[0].length;
        //每行的和
        int[] rowSum = new int[row];
        //每列的和
        int[] colSUm = new int[col];
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rowSum[i] = rowSum[i] + mat[i][j];
                colSUm[j] = colSUm[j] + mat[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSUm[j] == 1) {
                    ++sum;
                }
            }
        }
        return sum;
    }

    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % p;
        }
        if (sum == 0) {
            return 0;
        }


        return -1;
    }

    public String reorderSpaces(String text) {
        //获得空格数量和每个单词的数组 空格是32
        int blankNum = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 32) {
                //空格
                ++blankNum;
            }
        }
        if (blankNum < 1) {
            return text;
        }
        String[] split = text.trim().split("\\s+");
        //List<String> collect = Arrays.stream(split).filter(a -> !a.equals("")).collect(Collectors.toList());
        int n = split.length;
        if (n == 1) {
            StringBuilder sb = new StringBuilder(blankNum);
            for (int i = 0; i < blankNum; i++) {
                sb.append(" ");
            }
            return split[0] + sb.toString();
        }
        int x = blankNum / (n - 1);
        StringBuilder sb = new StringBuilder(x);
        for (int i = 0; i < x; i++) {
            sb.append(" ");
        }

        int elseBlank = blankNum - x * (n - 1);
        StringBuilder elseBlankSb = new StringBuilder(elseBlank);
        for (int i = 0; i < elseBlank; i++) {
            elseBlankSb.append(" ");
        }
        String join = String.join(sb.toString(), split);
        //计算每两个单词间的空格数量和最后一个位置的空格数量
        //拼接字符串
        return join + elseBlankSb.toString();
    }

    /**
     * 1 <= logs.length <= 103
     * 2 <= logs[i].length <= 10
     * logs[i] 包含小写英文字母，数字，'.' 和 '/'
     * logs[i] 符合语句中描述的格式
     * 文件夹名称由小写英文字母和数字组成
     */
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (depth > 0) {
                    --depth;
                }
            } else if (log.equals("./")) {
            } else {
                //x/
                ++depth;
            }
        }
        return depth;
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {


        List<String> res = new ArrayList<>();

        res = res.stream().sorted().collect(Collectors.toList());
        return res;
    }

    public int specialArray(int[] nums) {
        List<Integer> numList = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int x = -1;
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) >= i + 1) {
                x = i + 1;
                continue;
            }
            if (numList.get(i) == x) {
                return -1;
            }
            break;
        }
        return x;
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>(n);
        Map<String, Integer> map2 = new HashMap<>(n);
        for (int[] road : roads) {
            map.merge(road[0], 1, Integer::sum);
            map.merge(road[1], 1, Integer::sum);
            if (road[0] < road[1]) {
                map2.put(road[0] + "_" + road[1], 1);
            } else {
                map2.put(road[1] + "_" + road[0], 1);
            }
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (map2.getOrDefault(i + "_" + j, -1) == 1) {
                    res = Math.max(res, map.getOrDefault(i, 0) + map.getOrDefault(j, 0) - 1);
                } else {
                    res = Math.max(res, map.getOrDefault(i, 0) + map.getOrDefault(j, 0));
                }
            }
        }
        return res;
    }

    public double trimMean(int[] arr) {
        //5%
        int delNum = arr.length / 20;
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            minQueue.add(arr[i]);
            maxQueue.add(arr[i]);
            sum += arr[i];
            if (i > delNum - 1) {
                minQueue.poll();
                maxQueue.poll();
            }
        }
        while (!minQueue.isEmpty()) {
            sum -= minQueue.poll();
            sum -= maxQueue.poll();
        }
        return sum * 1.0 / (arr.length - 2 * delNum);
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int length = s.length();
        int res = -1;
        //key:char value:[第一个下标,最后一个下标]
        int[] charArray = new int[26];
        Arrays.fill(charArray, -1);
        //Map<Character, Pair<Integer, Integer>> map = new HashMap<>(26);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (charArray[c - 'a'] < 0) {
                charArray[c - 'a'] = i;
            } else {
                res = Math.max(res, i - charArray[c - 'a'] - 1);
            }
        }
        return res;
    }

    public int[] frequencySort(int[] nums) {
        //key 值 value 频次
        Map<Integer, Integer> valueFreMap = new HashMap<>();
        //统计每个值的频次
        for (int num : nums) {
            if (valueFreMap.containsKey(num)) {
                valueFreMap.put(num, valueFreMap.get(num) + 1);
            } else {
                valueFreMap.put(num, 1);
            }
        }
        Map<Integer, TreeSet<Integer>> freValueSetMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : valueFreMap.entrySet()) {
            if (freValueSetMap.containsKey(entry.getValue())) {
                freValueSetMap.get(entry.getValue()).add(entry.getKey());
            } else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(entry.getKey());
                freValueSetMap.put(entry.getValue(), set);
            }
        }
        int[] res = new int[nums.length];
        int curse = 0;
        for (Map.Entry<Integer, TreeSet<Integer>> entry : freValueSetMap.entrySet()) {
            for (Integer num : entry.getValue().descendingSet()) {
                for (int i = 0; i < entry.getKey(); i++) {
                    res[curse] = num;
                    ++curse;
                }
            }
        }
        return res;
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>(pieces.length);
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }
        int i = 0;
        while (i < arr.length) {
            int arrI = arr[i];
            if (!map.containsKey(arrI)) {
                return false;
            }
            Integer index = map.get(arrI);
            int length = pieces[index].length;
            for (int j = 0; j < length; j++) {
                if (arr[i + j] != pieces[index][j]) {
                    return false;
                }
            }
            i += length;
        }
        return true;
    }

    public int countVowelStrings(int n) {
        int[] aArr = new int[]{1, 1, 1, 1, 1};
        int[] eArr = new int[]{0, 1, 1, 1, 1};
        int[] iArr = new int[]{0, 0, 1, 1, 1};
        int[] oArr = new int[]{0, 0, 0, 1, 1};
        int[] uArr = new int[]{0, 0, 0, 0, 1};
        int[] resArr = new int[]{1, 0, 0, 0, 0};
        for (int k = 0; k < n; k++) {
            int a = resArr[0];
            int e = resArr[1];
            int i = resArr[2];
            int o = resArr[3];
            int u = resArr[4];

            resArr[0] = a * aArr[0] + e * eArr[0] + i * iArr[0] + o * oArr[0] + u * uArr[0];
            resArr[1] = a * aArr[1] + e * eArr[1] + i * iArr[1] + o * oArr[1] + u * uArr[1];
            resArr[2] = a * aArr[2] + e * eArr[2] + i * iArr[2] + o * oArr[2] + u * uArr[2];
            resArr[3] = a * aArr[3] + e * eArr[3] + i * iArr[3] + o * oArr[3] + u * uArr[3];
            resArr[4] = a * aArr[4] + e * eArr[4] + i * iArr[4] + o * oArr[4] + u * uArr[4];
        }
        return resArr[0] + resArr[1] + resArr[2] + resArr[3] + resArr[4];
    }

    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) {
            Arrays.fill(res, 0);
            return res;
        }
        int base = 0;
        if (k > 0) {
            for (int i = 0; i < k; ++i) {
                base += code[i];
            }
        } else {
            //+=从右数k个值
            for (int i = 0; i < -k; ++i) {
                base += code[code.length - i - 1];
            }
        }
        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int sub = (i + k) % code.length;
                //减当前值，加i+k下标的值
                base += (-code[i] + code[sub]);
                res[i] = base;
            }
        } else {
            for (int i = code.length - 1; i >= 0; --i) {
                //减当前值，加i+k下标的值
                int sub = (i + k) % code.length;
                if (sub < 0) {
                    sub += code.length;
                }
                base += (-code[i] + code[sub]);
                res[i] = base;
            }
        }
        return res;
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }

    public int waysToMakeFair(int[] nums) {
        //sum原奇数
        int sumOriOdd = 0;
        //sum原偶数
        int sumOriEven = 0;
        //true：是偶数
        boolean flag = true;
        for (int num : nums) {
            if (flag) {
                //当前下标是偶数
                sumOriEven += num;
            } else {
                //当前下标是奇数
                sumOriOdd += num;
            }
            flag = !flag;
        }
        flag = true;
        //for i累加的偶数和
        int cumOdd = 0;
        //for i累加的奇数和
        int cumEven = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //当前奇数和
            int currentOdd = 0;
            //当前偶数和
            int currentEven = 0;
            if (flag) {
                //当前下标是偶数
                currentOdd = sumOriEven - cumEven + cumOdd - num;
                currentEven = sumOriOdd + cumEven - cumOdd;
                cumEven += num;
            } else {
                //当前下标是奇数
                currentOdd = sumOriEven - cumEven + cumOdd;
                currentEven = sumOriOdd + cumEven - cumOdd - num;
                cumOdd += num;
            }
            String msg = "当前删除数字nums[" + i + "]=" + num + ",当前奇偶=(" + currentOdd + "," + currentEven + ")";
            System.out.println(msg);
            if (currentOdd == currentEven) {
                ++res;
            }
            flag = !flag;
        }
        return res;
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode nodeAFront = goStep(list1, a - 1);
        ListNode nodeB = goStep(nodeAFront, b - a + 1);
        ListNode list2End = list2;
        while (list2End.next != null) {
            list2End = list2End.next;
        }
        nodeAFront.next = list2;
        list2End.next = nodeB.next;
        return list1;
    }

    /**
     * 走n步
     */
    public static ListNode goStep(ListNode node, int n) {
        ListNode res = node;
        for (int i = 0; i < n; i++) {
            res = res.next;
        }
        return res;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        Set<Character> set = new HashSet<>(allowed.length());
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }

        for (String word : words) {
            if (isConsistentString(set, word)) {
                ++count;
            }
        }
        return count;
    }

    private boolean isConsistentString(Set<Character> set, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!set.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //public static void main(String[] args) {
    //    String a = "123- 456";
    //    System.out.println(a);
    //}

    //原字符串 新字符串 商 余
    //12:12 0 2
    //123:123 1 0
    //1234:12-34 1 1
    //12345:123-45 1 2
    //123456:123-456 2 0
    //1234567:123-45-67 2 1
    //12345678:123-456-78 2 2
    //123456789:123-456-789 3 0
    //1234567891:123-456-78-91 3 1
    //规律
    //余0时整除
    //余1时末尾4个处理成xx-xx
    //余2时末尾是-xx
    public String reformatNumber(String number) {
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            //如果不是空格32 不是- 45
            if (c != 32 && c != 45) {
                charList.add(c);
            }
        }
        int len = charList.size();
        if (len <= 3) {
            return getStrByCharList(charList);
        }
        //余数
        int left = len % 3;
        //从右数需要处理的数字个数
        int len2 = left == 0 ? 0 : left == 1 ? 4 : 2;
        //前面的数每3个加一个-
        List<Character> resultList = new ArrayList<>();
        for (int i = 0; i < len - len2; i++) {
            resultList.add(charList.get(i));
            if ((i + 1) % 3 == 0 && i != len - len2 - 1) {
                resultList.add('-');
            }
        }
        //处理剩余字符串
        if (len2 == 0) {
            //
        } else if (len2 == 4) {
            if (resultList.size() > 0) {
                resultList.add('-');
            }
            resultList.add(charList.get(len - 4));
            resultList.add(charList.get(len - 3));
            resultList.add('-');
            resultList.add(charList.get(len - 2));
            resultList.add(charList.get(len - 1));
        } else {
            //len2==2
            resultList.add('-');
            resultList.add(charList.get(len - 2));
            resultList.add(charList.get(len - 1));
        }
        return getStrByCharList(resultList);
    }

    private String getStrByCharList(List<Character> charList) {
        StringBuilder sb = new StringBuilder(charList.size());
        for (Character character : charList) {
            sb.append(character);
        }
        return sb.toString();
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int zeroNum = 0;
        int oneNum = 0;
        for (int student : students) {
            if (student == 0) {
                ++zeroNum;
            } else {
                ++oneNum;
            }
        }
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                --zeroNum;
                if (zeroNum < 0) {
                    return oneNum;
                }
            } else {
                --oneNum;
                if (oneNum < 0) {
                    return zeroNum;
                }
            }
        }
        return zeroNum + oneNum;
    }

    public boolean halvesAreAlike(String s) {
        int countLeft = 0;
        int countRight = 0;
        int length = s.length();
        int halfLength = length / 2;
        for (int i = 0; i < halfLength; i++) {
            if (isAEIOU(s.charAt(i))) {
                ++countLeft;
            }
            if (isAEIOU(s.charAt(i + halfLength))) {
                ++countRight;
            }
        }
        return countLeft == countRight;
    }

    private static boolean isAEIOU(char c) {
        if (c == 'a' || c == 'A') {
            return true;
        }
        if (c == 'e' || c == 'E') {
            return true;
        }
        if (c == 'i' || c == 'I') {
            return true;
        }
        if (c == 'o' || c == 'O') {
            return true;
        }
        if (c == 'u' || c == 'U') {
            return true;
        }
        return false;
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //按numberOfUnitsPerBoxi倒序排
        List<Integer> list = new ArrayList<>(boxTypes.length * 2);
        for (int[] boxType : boxTypes) {
            for (int times = 0; times < boxType[0]; times++) {
                list.add(boxType[1]);
            }
        }
        list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int res = 0;
        int count = 0;
        for (Integer integer : list) {
            ++count;
            res += integer;
            if (count >= truckSize) {
                break;
            }
        }
        return res;
    }

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int i = lowLimit; i <= highLimit; ++i) {
            //获得编号数
            int temp = 0;
            int ii = i;
            while (ii != 0) {
                temp += ii % 10;
                ii = ii / 10;
            }
            count.merge(temp, 1, Integer::sum);
            res = Math.max(res, count.get(temp));
        }
        return res;
    }

    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int maxLen = Math.max(len1, len2);
        StringBuilder sb = new StringBuilder(len1 + len2);
        for (int i = 0; i < maxLen; i++) {
            if (i < len1) {
                sb.append(word1.charAt(i));
            }
            if (i < len2) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int sub;
        switch (ruleKey) {
            case "type":
                sub = 0;
                break;
            case "color":
                sub = 1;
                break;
            case "name":
                sub = 2;
                break;
            default:
                sub = 0;
                break;
        }
        int res = 0;
        for (List<String> item : items) {
            if (item.get(sub).equals(ruleValue)) {
                ++res;
            }
        }
        return res;
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char dif1 = 0;
        char dif2 = 0;
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) {
                continue;
            }
            ++count;
            if (count < 1) {
                continue;
            }
            if (count > 2) {
                return false;
            }
            if (count < 2) {
                dif1 = c1;
                dif2 = c2;
            } else {
                if (dif1 == 0 || dif2 == 0) {
                    continue;
                }
                if (dif1 != c2 || dif2 != c1) {
                    return false;
                }
            }
        }
        if (count == 1) {
            return false;
        }
        return true;
    }

    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int max = 0;
        for (int coin : coins) {
            if (coin > max + 1) {
                return max + 1;
            }
            max = coin + max;
        }
        return max + 1;
    }

    public int maxAscendingSum(int[] nums) {
        int res = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                current = nums[i];
                res = nums[i];
                continue;
            }
            if (nums[i] > nums[i - 1]) {
                current += nums[i];
                res = Math.max(res, current);
            } else {
                current = nums[i];
            }
        }
        return res;
    }

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        String replace = word.replaceAll("[a-z]", " ");
        String[] split = replace.split("\\s+");
        for (String s : split) {
            if (Objects.equals(s, "")) {
                continue;
            }
            String s1 = s.replaceAll("^0+", "");
            set.add(s1);
        }
        return set.size();
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>(knowledge.size());
        for (List<String> kn : knowledge) {
            map.put("(" + kn.get(0) + ")", kn.get(1));
        }
        int n = s.length();
        int curse = 0;
        //找(xx)
        StringBuilder sb = new StringBuilder();
        while (curse < n) {
            char c = s.charAt(curse);
            if (c == '(') {
                int left = curse;
                while (s.charAt(curse + 1) != ')') {
                    ++curse;
                }
                ++curse;
                String s1 = s.substring(left, curse + 1);
                sb.append(map.getOrDefault(s1, "?"));
            } else {
                sb.append(s.charAt(curse));
            }
            ++curse;
        }
        return sb.toString();
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        return false;
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        //k 用户id v.size 用户活跃分钟数
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int[] logI = logs[i];
            if (!map.containsKey(logI[0])) {
                map.put(logI[0], new HashSet<>());
            }
            map.get(logI[0]).add(logI[1]);
        }
        int[] res = new int[k];
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            res[size - 1] = res[size - 1] + 1;
        }
        return res;
    }

    public int arraySign(int[] nums) {
        //false表示负数
        boolean res = true;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                res = !res;
            }
        }
        return res ? 1 : -1;
    }

    public int minSideJumps(int[] obstacles) {
        int[] res = new int[]{1, 0, 1};
        for (int i = 1; i < obstacles.length; i++) {
            for (int j = 0; j < res.length; j++) {
                if (obstacles[i] - 1 == j) {
                    res[j] = Integer.MAX_VALUE;
                }
            }
            int min = Math.min(res[0], res[1]);
            min = Math.min(min, res[2]);
            for (int j = 0; j < res.length; j++) {
                if (obstacles[i] - 1 != j) {
                    res[j] = Math.min(res[j], min + 1);
                }
            }
        }
        int min = Math.min(res[0], res[1]);
        min = Math.min(min, res[2]);
        return min;
    }

    public int getLucky(String s, int k) {
        String numStr = alphabet2Num(s);
        for (int i = 0; i < k; i++) {
            numStr = lucky(numStr);
        }
        return Integer.parseInt(numStr);
    }

    private String lucky(String numStr) {
        int res = 0;
        for (int i = 0; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            res += Integer.parseInt(String.valueOf(c));
        }
        return String.valueOf(res);
    }

    //97 a
    private String alphabet2Num(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 96);
        }
        return sb.toString();
    }

}
