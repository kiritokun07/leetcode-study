package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyClientTest_2001_2500 {

    MySolution_2001_2500 solution = new MySolution_2001_2500();

    /**
     * 2027. 转换字符串的最少操作次数
     * 简单
     * https://leetcode.cn/problems/minimum-moves-to-convert-string/
     */
    @Test
    public void no2027() {
        Assertions.assertEquals(solution.minimumMoves("XXX"), 1);
        Assertions.assertEquals(solution.minimumMoves("XXOX"), 2);
        Assertions.assertEquals(solution.minimumMoves("OOOO"), 0);
    }

    /**
     * 2042. 检查句子中的数字是否递增
     * 简单
     * https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/
     */
    @Test
    public void no2042() {
        Assertions.assertTrue(solution.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        Assertions.assertFalse(solution.areNumbersAscending("hello world 5 x 5"));
        Assertions.assertFalse(solution.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        Assertions.assertTrue(solution.areNumbersAscending("4 5 11 26"));
    }

}
