package leetcode;

import leetcode.node.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    /**
     * 2331. 计算布尔二叉树的值
     * 简单
     * https://leetcode.cn/problems/evaluate-boolean-binary-tree/
     */
    @Test
    public void no2331() {
        Assertions.assertTrue(solution.evaluateTree(Objects.requireNonNull(TreeNode.array2TreeNode2(new Integer[]{2, 1, 3, null, null, 0, 1}))));
        Assertions.assertFalse(solution.evaluateTree(Objects.requireNonNull(TreeNode.array2TreeNode2(new Integer[]{0}))));
    }

    /**
     * 2335. 装满杯子需要的最短总时长
     * 简单
     * https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/
     */
    @Test
    public void no2335() {
        Assertions.assertEquals(solution.fillCups(new int[]{1, 4, 2}), 4);
        Assertions.assertEquals(solution.fillCups(new int[]{5, 4, 4}), 7);
        Assertions.assertEquals(solution.fillCups(new int[]{5, 0, 0}), 5);
        Assertions.assertEquals(solution.fillCups(new int[]{1, 2, 3}), 3);
        Assertions.assertEquals(solution.fillCups(new int[]{2, 4, 2}), 4);
    }

    /**
     * 2341. 数组能形成多少数对
     * 简单
     * https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
     */
    @Test
    public void no2341() {
        Assertions.assertEquals(Arrays.toString(solution.numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2})), "[3, 1]");
        Assertions.assertEquals(Arrays.toString(solution.numberOfPairs(new int[]{1, 1})), "[1, 0]");
        Assertions.assertEquals(Arrays.toString(solution.numberOfPairs(new int[]{0})), "[0, 1]");
    }

    /**
     * 2347. 最好的扑克手牌
     * 简单
     * https://leetcode.cn/problems/best-poker-hand/
     */
    @Test
    public void no2347() {
        Assertions.assertEquals(solution.bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a', 'a', 'a', 'a'}), "Flush");
        Assertions.assertEquals(solution.bestHand(new int[]{4, 4, 2, 4, 4}, new char[]{'d', 'a', 'a', 'b', 'c'}), "Three of a Kind");
        Assertions.assertEquals(solution.bestHand(new int[]{10, 10, 2, 12, 9}, new char[]{'a', 'b', 'c', 'a', 'd'}), "Pair");
    }

    /**
     * 2357. 使数组中所有元素都等于零
     * 简单
     * https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/
     */
    @Test
    public void no2357() {
        Assertions.assertEquals(solution.minimumOperations(new int[]{1, 5, 0, 3, 5}), 3);
        Assertions.assertEquals(solution.minimumOperations(new int[]{0}), 0);
    }

    /**
     * 2363. 合并相似的物品
     * 简单
     * https://leetcode.cn/problems/merge-similar-items/
     */
    @Test
    public void no2363() {
        Assertions.assertEquals(solution.mergeSimilarItems(new int[][]{{1, 1}, {4, 5}, {3, 8}}, new int[][]{{3, 1}, {1, 5}}).toString(), "[[1, 6], [3, 9], [4, 5]]");
        Assertions.assertEquals(solution.mergeSimilarItems(new int[][]{{1, 1}, {3, 2}, {2, 3}}, new int[][]{{2, 1}, {3, 2}, {1, 3}}).toString(), "[[1, 4], [2, 4], [3, 4]]");
        Assertions.assertEquals(solution.mergeSimilarItems(new int[][]{{1, 3}, {2, 2}}, new int[][]{{7, 1}, {2, 2}, {1, 4}}).toString(), "[[1, 7], [2, 4], [7, 1]]");
    }

    /**
     * 2373. 矩阵中的局部最大值
     * 简单
     * https://leetcode.cn/problems/largest-local-values-in-a-matrix/
     */
    @Test
    public void no2373() {
        Assertions.assertEquals(Arrays.deepToString(solution.largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}})), "[[9, 9], [8, 6]]");
        Assertions.assertEquals(Arrays.deepToString(solution.largestLocal(new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}})), "[[2, 2, 2], [2, 2, 2], [2, 2, 2]]");
    }

    /**
     * 2383. 赢得比赛需要的最少训练时长
     * 简单
     * https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/
     */
    @Test
    public void no2383() {
        Assertions.assertEquals(solution.minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}), 8);
        Assertions.assertEquals(solution.minNumberOfHours(2, 4, new int[]{1}, new int[]{3}), 0);
        Assertions.assertEquals(solution.minNumberOfHours(1, 1, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 50}), 51);
    }

    /**
     * 2389. 和有限的最长子序列
     * 简单
     * https://leetcode.cn/problems/longest-subsequence-with-limited-sum/
     */
    @Test
    public void no2389() {
        Assertions.assertEquals(Arrays.toString(solution.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})), "[2, 3, 4]");
        Assertions.assertEquals(Arrays.toString(solution.answerQueries(new int[]{2, 3, 4, 5}, new int[]{1})), "[0]");
        Assertions.assertEquals(Arrays.toString(solution.answerQueries(new int[]{736411, 184882, 914641, 37925, 214915}, new int[]{331244, 273144, 118983, 118252, 305688, 718089, 665450})), "[2, 2, 1, 1, 2, 3, 3]");
    }

}
