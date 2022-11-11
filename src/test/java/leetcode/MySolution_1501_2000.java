package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kirito
 * @desc ...
 * @date 2022-09-01 08:49:12
 */
public class MySolution_1501_2000 {

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

    public static void main(String[] args) {
        String a = "123- 456";
        System.out.println(a);
    }

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

}
