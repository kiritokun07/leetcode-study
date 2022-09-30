package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kirito
 * @desc ...
 * @date 2022-09-27 08:44:50
 */
public class MyInterviewSolution {

    public boolean CheckPermutation(String s1, String s2) {
        //每个字符的出现次数，s1按正的算，s2按负的算
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int[] rowZero = new int[row];
        Arrays.fill(rowZero, 1);
        int col = matrix[0].length;
        int[] colZero = new int[col];
        Arrays.fill(colZero, 1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = 0;
                    colZero[j] = 0;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowZero[i] == 0 || colZero[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).contains(s2);
    }

}
