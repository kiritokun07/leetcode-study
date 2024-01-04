package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kirito
 * @date 2024-01-04 09:18:09
 * @desc ...
 */
public class MyClientTest_2501_3000 {

    MySolution_2501_3000 solution = new MySolution_2501_3000();

    /**
     * 2545. 根据第 K 场考试的分数排序
     * 中等
     * https://leetcode.cn/problems/sort-the-students-by-their-kth-score/
     */
    @Test
    public void no2545() {
        int[][] score = solution.sortTheStudents(new int[][]{{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}}, 2);
        Assertions.assertEquals(score[0][0], 7);
        Assertions.assertEquals(score[0][1], 5);
        Assertions.assertEquals(score[0][2], 11);
        Assertions.assertEquals(score[0][3], 2);
        int[][] score2 = solution.sortTheStudents(new int[][]{{3, 4}, {5, 6}}, 0);
        Assertions.assertEquals(score2[0][0], 5);
        Assertions.assertEquals(score2[0][1], 6);
    }

}
