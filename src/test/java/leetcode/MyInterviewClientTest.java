package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kirito
 * @desc ...
 * @date 2022-09-27 08:44:20
 */
public class MyInterviewClientTest {

    MyInterviewSolution solution = new MyInterviewSolution();

    /**
     * 面试题 01.02. 判定是否互为字符重排
     * 简单
     * https://leetcode.cn/problems/check-permutation-lcci/
     */
    @Test
    public void interview01_02() {
        Assertions.assertTrue(solution.CheckPermutation("abc", "bca"));
        Assertions.assertFalse(solution.CheckPermutation("abc", "bad"));
    }

    /**
     * 面试题 01.09. 字符串轮转
     * 简单
     * https://leetcode.cn/problems/string-rotation-lcci/
     */
    @Test
    public void interview01_09() {
        Assertions.assertTrue(solution.isFlipedString("waterbottle", "erbottlewat"));
        Assertions.assertFalse(solution.isFlipedString("aa", "aba"));
    }

}
