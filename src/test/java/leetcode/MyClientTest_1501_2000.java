package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author kirito
 * @desc ...
 * @date 2022-09-01 08:48:49
 */
public class MyClientTest_1501_2000 {

    MySolution_1501_2000 solution = new MySolution_1501_2000();

    /**
     * 1582. 二进制矩阵中的特殊位置
     * 简单
     * https://leetcode.cn/problems/special-positions-in-a-binary-matrix/
     */
    @Test
    public void no1582() {
        Assertions.assertEquals(solution.numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}), 1);
        Assertions.assertEquals(solution.numSpecial(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}), 3);
        Assertions.assertEquals(solution.numSpecial(new int[][]{{0, 0, 0, 1}, {1, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}), 2);
        Assertions.assertEquals(solution.numSpecial(new int[][]{{0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}}), 3);
    }

    /**
     * 1592. 重新排列单词间的空格
     * 简单
     * https://leetcode.cn/problems/rearrange-spaces-between-words/
     */
    @Test
    public void no1592() {
        Assertions.assertEquals(solution.reorderSpaces("  this   is  a sentence "), "this   is   a   sentence");
        Assertions.assertEquals(solution.reorderSpaces(" practice   makes   perfect"), "practice   makes   perfect ");
        Assertions.assertEquals(solution.reorderSpaces("hello   world"), "hello   world");
        Assertions.assertEquals(solution.reorderSpaces("  walks  udp package   into  bar a"), "walks  udp  package  into  bar  a ");
        Assertions.assertEquals(solution.reorderSpaces("a"), "a");
    }

    /**
     * 1598. 文件夹操作日志搜集器
     * 简单
     * https://leetcode.cn/problems/crawler-log-folder/
     */
    @Test
    public void no1598() {
        Assertions.assertEquals(solution.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}), 2);
        Assertions.assertEquals(solution.minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}), 3);
        Assertions.assertEquals(solution.minOperations(new String[]{"d1/", "../", "../", "../"}), 0);
        Assertions.assertEquals(solution.minOperations(new String[]{"./", "../", "./"}), 0);
    }

    /**
     * 1608. 特殊数组的特征值
     * 简单
     * https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
     */
    @Test
    public void no1608() {
        Assertions.assertEquals(solution.specialArray(new int[]{3, 5}), 2);
        Assertions.assertEquals(solution.specialArray(new int[]{0, 0}), -1);
        Assertions.assertEquals(solution.specialArray(new int[]{0, 4, 3, 0, 4}), 3);
        Assertions.assertEquals(solution.specialArray(new int[]{3, 6, 7, 7, 0}), -1);
    }

    /**
     * 1619. 删除某些元素后的数组均值
     * 简单
     * https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
     */
    @Test
    public void no1619() {
        MyUtils.doubleEqual(solution.trimMean(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}), 2.00000);
        MyUtils.doubleEqual(solution.trimMean(new int[]{6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0}), 4.00000);
        MyUtils.doubleEqual(solution.trimMean(new int[]{6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4}), 4.77778);
        MyUtils.doubleEqual(solution.trimMean(new int[]{9, 7, 8, 7, 7, 8, 4, 4, 6, 8, 8, 7, 6, 8, 8, 9, 2, 6, 0, 0, 1, 10, 8, 6, 3, 3, 5, 1, 10, 9, 0, 7, 10, 0, 10, 4, 1, 10, 6, 9, 3, 6, 0, 0, 2, 7, 0, 6, 7, 2, 9, 7, 7, 3, 0, 1, 6, 1, 10, 3}), 5.27778);
        MyUtils.doubleEqual(solution.trimMean(new int[]{4, 8, 4, 10, 0, 7, 1, 3, 7, 8, 8, 3, 4, 1, 6, 2, 1, 1, 8, 0, 9, 8, 0, 3, 9, 10, 3, 10, 1, 10, 7, 3, 2, 1, 4, 9, 10, 7, 6, 4, 0, 8, 5, 1, 2, 1, 6, 2, 5, 0, 7, 10, 9, 10, 3, 7, 10, 5, 8, 5, 7, 6, 7, 6, 10, 9, 5, 10, 5, 5, 7, 2, 10, 7, 7, 8, 2, 0, 1, 1}), 5.29167);
    }

    /**
     * 1624. 两个相同字符之间的最长子字符串
     * 简单
     * https://leetcode.cn/problems/largest-substring-between-two-equal-characters/
     */
    @Test
    public void no1624() {
        Assertions.assertEquals(solution.maxLengthBetweenEqualCharacters("aa"), 0);
        Assertions.assertEquals(solution.maxLengthBetweenEqualCharacters("abca"), 2);
        Assertions.assertEquals(solution.maxLengthBetweenEqualCharacters("cbzxy"), -1);
        Assertions.assertEquals(solution.maxLengthBetweenEqualCharacters("cabbac"), 4);
    }

    /**
     * 1636. 按照频率将数组升序排序
     * 简单
     * https://leetcode.cn/problems/sort-array-by-increasing-frequency/
     */
    @Test
    public void no1636() {
        Assertions.assertEquals(Arrays.toString(solution.frequencySort(new int[]{1, 1, 2, 2, 2, 3})), "[3, 1, 1, 2, 2, 2]");
        Assertions.assertEquals(Arrays.toString(solution.frequencySort(new int[]{2, 3, 1, 3, 2})), "[1, 3, 3, 2, 2]");
        Assertions.assertEquals(Arrays.toString(solution.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})), "[5, -1, 4, 4, -6, -6, 1, 1, 1]");
    }

    /**
     * 1656. 设计有序流
     * 简单
     * https://leetcode.cn/problems/design-an-ordered-stream/
     */
    @Test
    public void no1656() {
        OrderedStream orderedStream = new OrderedStream(5);
        Assertions.assertEquals(orderedStream.insert(3, "ccccc").size(), 0);
        Assertions.assertEquals(orderedStream.insert(1, "aaaaa").get(0), "aaaaa");
        List<String> bbbbb = orderedStream.insert(2, "bbbbb");
        Assertions.assertEquals(bbbbb.get(0), "bbbbb");
        Assertions.assertEquals(bbbbb.get(1), "ccccc");
        Assertions.assertEquals(orderedStream.insert(5, "eeeee").size(), 0);
        List<String> ddddd = orderedStream.insert(4, "ddddd");
        Assertions.assertEquals(ddddd.get(0), "ddddd");
        Assertions.assertEquals(ddddd.get(1), "eeeee");
    }

}
