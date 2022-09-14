package leetcode;

import org.junit.jupiter.api.Assertions;

/**
 * 我的工具类
 *
 * @author kirito
 * @desc ...
 * @date 2022-09-14 08:45:22
 */
public class MyUtils {

    private static final double e = 1e-5;

    public static void doubleEqual(double result, double predict) {
        Assertions.assertTrue(Math.abs(result - predict) <= e);
    }

}
