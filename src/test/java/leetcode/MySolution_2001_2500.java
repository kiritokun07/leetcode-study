package leetcode;

import leetcode.node.TreeNode;

import java.util.*;

public class MySolution_2001_2500 {

    public int minimumMoves(String s) {
        int cur = 0;
        int res = 0;
        while (cur < s.length()) {
            if (s.charAt(cur) == 'X') {
                ++res;
                cur += 3;
            } else {
                ++cur;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "123";
        char c = s.charAt(0);
        if (c == 49) {
            System.out.println("yes");
        }
    }

    public boolean areNumbersAscending(String s) {
        String[] s1 = s.split(" ");
        int lastNum = -1;
        for (String s2 : s1) {
            //如果s2包含数字就进行解析，否则就跳过
            char c = s2.charAt(0);
            if (c > 57) {
                continue;
            }
            //如果数字大于上次的数字就ok，否则就返回false
            int s2Int = Integer.parseInt(s2);
            if (s2Int <= lastNum) {
                return false;
            }
            //记录最新的数字
            lastNum = s2Int;
        }
        return true;
    }

    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                ++res;
            }
        }
        return res;
    }

    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            tMap.merge(target.charAt(i), 1, Integer::sum);
        }
        int result = s.length() / target.length() + 1;
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            result = Math.min(result, sMap.getOrDefault(entry.getKey(), 0) / entry.getValue());
            if (result == 0) {
                return 0;
            }
        }
        return result;
    }

    private static final String SPECIAL_STR = "!@#$%^&*()-+";
    private static final Set<Character> SPECIAL_CHAR_SET = new HashSet<>();

    static {
        for (int i = 0; i < SPECIAL_STR.length(); i++) {
            SPECIAL_CHAR_SET.add(SPECIAL_STR.charAt(i));
        }
    }

    /**
     * 字符   a  z
     * ascii 97 122
     */
    private static boolean isLowLetter(char c) {
        return c >= 97 && c <= 122;
    }

    /**
     * 字符 A Z
     * ascii 65 90
     */
    private static boolean isUpperLetter(char c) {
        return c >= 65 && c <= 90;
    }

    /**
     * 字符   0  9
     * ascii 48 57
     */
    private static boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }

    private static boolean isSpecialChar(char c) {
        return SPECIAL_CHAR_SET.contains(c);
    }

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasLowLetter = false;
        boolean hasUpperLetter = false;
        boolean hasNumber = false;
        boolean hasSpecChar = false;
        char lastChar = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (i > 0) {
                if (lastChar == c) {
                    return false;
                }
            }
            lastChar = c;
            if (!hasLowLetter && isLowLetter(c)) {
                hasLowLetter = true;
            }
            if (!hasUpperLetter && isUpperLetter(c)) {
                hasUpperLetter = true;
            }
            if (!hasNumber && isNumber(c)) {
                hasNumber = true;
            }
            if (!hasSpecChar && SPECIAL_CHAR_SET.contains(c)) {
                hasSpecChar = true;
            }
        }
        return hasLowLetter && hasUpperLetter && hasNumber && hasSpecChar;
    }

    public String greatestLetter(String s) {
        String res = "";
        //1 大写 2 小写 3 大写+小写
        int[] letterArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是大写字母
            if (isUpperLetter(c)) {
                int curse = c - 65;
                if (letterArr[curse] == 0) {
                    letterArr[curse] = 1;
                } else {
                    letterArr[curse] = 1 | letterArr[curse];
                }
            } else if (isLowLetter(c)) {
                int curse = c - 97;
                if (letterArr[curse] == 0) {
                    letterArr[curse] = 2;
                } else {
                    letterArr[curse] = 2 | letterArr[curse];
                }
            }
        }
        for (int i = 25; i >= 0; --i) {
            if (letterArr[i] == 3) {
                char c = (char) (i + 65);
                res = String.valueOf(c);
                break;
            }
        }
        return res;
    }

    public int countAsterisks(String s) {
        //true即计数
        boolean flag = true;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                flag = !flag;
                continue;
            }
            if (!flag) {
                continue;
            }
            if (c == '*') {
                ++res;
            }
        }
        return res;
    }

    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    //如果在对角线，必须不是0
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    //否则必须是0
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean evaluateTree(TreeNode root) {
        if (root.val < 2) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        return evaluateTree(root.left) && evaluateTree(root.right);
    }

    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        //a>b>c
        int a = amount[2];
        int b = amount[1];
        int c = amount[0];
        if (a >= b + c) {
            return a;
        }
        return (a + b + c + 1) / 2;
    }

    public int[] numberOfPairs(int[] nums) {
        int[] exist101 = new int[101];
        Arrays.fill(exist101, 0);
        int sum = 0;
        for (int num : nums) {
            if (exist101[num] == 0) {
                exist101[num] = 1;
            } else {
                exist101[num] = 0;
                ++sum;
            }
        }
        int[] res = new int[2];
        res[0] = sum;
        res[1] = nums.length - sum * 2;
        return res;
    }

    public String bestHand(int[] ranks, char[] suits) {
        int flush = 0;
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] == suits[0]) {
                ++flush;
            }
        }
        if (flush == 4) {
            return "Flush";
        }
        int[] rankArr = new int[13];
        Arrays.fill(rankArr, 0);
        for (int rank : ranks) {
            ++rankArr[rank - 1];
        }
        boolean threeOfAKind = false;
        boolean pair = false;
        boolean highCard = true;
        for (int rank : rankArr) {
            if (rank >= 3) {
                threeOfAKind = true;
            }
            if (rank == 2) {
                pair = true;
            }
            if (rank > 1) {
                highCard = false;
            }
        }
        if (threeOfAKind) {
            return "Three of a Kind";
        }
        if (pair) {
            return "Pair";
        }
        if (highCard) {
            return "High Card";
        }
        return null;
    }

    public int minimumOperations(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                numSet.add(num);
            }
        }
        return numSet.size();
    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] item : items1) {
            map.merge(item[0], item[1], Integer::sum);
        }
        for (int[] item : items2) {
            map.merge(item[0], item[1], Integer::sum);
        }
        List<List<Integer>> res = new ArrayList<>(map.size());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> resI = new ArrayList<>(2);
            resI.add(entry.getKey());
            resI.add(entry.getValue());
            res.add(resI);
        }
        return res;
    }

}
