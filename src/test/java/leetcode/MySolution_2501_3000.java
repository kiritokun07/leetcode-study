package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kirito
 * @date 2024-01-04 09:18:35
 * @desc ...
 */
public class MySolution_2501_3000 {

    public int[][] sortTheStudents(int[][] score, int k) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] s : score) {
            map.put(s[k], s);
        }
        List<Integer> sortedKList = map.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; i < sortedKList.size(); i++) {
            score[i] = map.get(sortedKList.get(i));
        }
        return score;
    }

    public int differenceOfSums(int n, int m) {
        int num2;
        if (m == 1) {
            num2 = n * (n + 1) / 2;
        } else if (m <= n / 2) {
            int ratio = n / m;
            num2 = m * ratio * (ratio + 1) / 2;
        } else if (m <= n) {
            num2 = m;
        } else {
            num2 = 0;
        }
        return n * (n + 1) / 2 - 2 * num2;
    }

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < mountain.length; i++) {
            //如果是开头
            if (i == 0 || i == mountain.length - 1) {
            } else if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                result.add(i);
            }
        }
        return result;
    }

}
