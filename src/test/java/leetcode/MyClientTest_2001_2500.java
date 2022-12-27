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

}
