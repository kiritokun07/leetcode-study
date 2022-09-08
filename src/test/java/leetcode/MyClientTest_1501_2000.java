package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(solution.reorderSpaces("  this   is  a sentence "),"this   is   a   sentence");
        Assertions.assertEquals(solution.reorderSpaces(" practice   makes   perfect"),"practice   makes   perfect ");
        Assertions.assertEquals(solution.reorderSpaces("hello   world"),"hello   world");
        Assertions.assertEquals(solution.reorderSpaces("  walks  udp package   into  bar a"),"walks  udp  package  into  bar  a ");
        Assertions.assertEquals(solution.reorderSpaces("a"),"a");
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
