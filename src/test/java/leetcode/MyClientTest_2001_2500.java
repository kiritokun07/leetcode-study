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

    /**
     * 2185. 统计包含给定前缀的字符串
     * 简单
     * https://leetcode.cn/problems/counting-words-with-a-given-prefix/
     */
    @Test
    public void no2185() {
        Assertions.assertEquals(solution.prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"), 2);
        Assertions.assertEquals(solution.prefixCount(new String[]{"leetcode", "win", "loops", "success"}, "code"), 0);
    }

    /**
     * 2287. 重排字符形成目标字符串
     * 简单
     * https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
     */
    @Test
    public void no2287() {
        Assertions.assertEquals(solution.rearrangeCharacters("ilovecodingonleetcode", "code"), 2);
        Assertions.assertEquals(solution.rearrangeCharacters("abcba", "abc"), 1);
        Assertions.assertEquals(solution.rearrangeCharacters("abbaccaddaeea", "aaaaa"), 1);
    }

    /**
     * 2299. 强密码检验器 II
     * 简单
     * https://leetcode.cn/problems/strong-password-checker-ii/
     */
    @Test
    public void no2299() {
        Assertions.assertTrue(solution.strongPasswordCheckerII("IloveLe3tcode!"));
        Assertions.assertFalse(solution.strongPasswordCheckerII("Me+You--IsMyDream"));
        Assertions.assertFalse(solution.strongPasswordCheckerII("1aB!"));
    }

    /**
     * 2309. 兼具大小写的最好英文字母
     * 简单
     * https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/
     */
    @Test
    public void no2309() {
        Assertions.assertEquals(solution.greatestLetter("lEeTcOdE"), "E");
        Assertions.assertEquals(solution.greatestLetter("arRAzFif"), "R");
        Assertions.assertEquals(solution.greatestLetter("AbCdEfGhIjK"), "");
    }

    /**
     * 2315. 统计星号
     * 简单
     * https://leetcode.cn/problems/count-asterisks/
     */
    @Test
    public void no2315() {
        Assertions.assertEquals(solution.countAsterisks("l|*e*et|c**o|*de|"), 2);
        Assertions.assertEquals(solution.countAsterisks("iamprogrammer"), 0);
        Assertions.assertEquals(solution.countAsterisks("yo|uar|e**|b|e***au|tifu|l"), 5);
    }

    /**
     * 2319. 判断矩阵是否是一个 X 矩阵
     * 简单
     * https://leetcode.cn/problems/check-if-matrix-is-x-matrix/
     */
    @Test
    public void no2319() {
        Assertions.assertTrue(solution.checkXMatrix(new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}}));
        Assertions.assertFalse(solution.checkXMatrix(new int[][]{{5, 7, 0}, {0, 3, 1}, {0, 5, 0}}));
    }
}
