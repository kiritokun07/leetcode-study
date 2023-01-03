package leetcode;

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

}
