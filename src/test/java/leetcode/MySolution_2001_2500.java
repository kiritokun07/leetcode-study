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

}
