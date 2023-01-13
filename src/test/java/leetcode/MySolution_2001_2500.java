package leetcode;

import java.util.HashMap;
import java.util.Map;

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
        }
        return result;
    }

}
