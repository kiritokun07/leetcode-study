package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kirito
 * @desc ...
 * @date 2022-09-01 08:49:12
 */
public class MySolution_1501_2000 {

    public int numSpecial(int[][] mat) {
        //行数
        int row = mat.length;
        //列数
        int col = mat[0].length;
        //每行的和
        int[] rowSum = new int[row];
        //每列的和
        int[] colSUm = new int[col];
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rowSum[i] = rowSum[i] + mat[i][j];
                colSUm[j] = colSUm[j] + mat[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSUm[j] == 1) {
                    ++sum;
                }
            }
        }
        return sum;
    }

    public String reorderSpaces(String text) {
        //获得空格数量和每个单词的数组 空格是32
        int blankNum = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 32) {
                //空格
                ++blankNum;
            }
        }
        if (blankNum < 1) {
            return text;
        }
        String[] split = text.trim().split("\\s+");
        //List<String> collect = Arrays.stream(split).filter(a -> !a.equals("")).collect(Collectors.toList());
        int n = split.length;
        if (n == 1) {
            StringBuilder sb = new StringBuilder(blankNum);
            for (int i = 0; i < blankNum; i++) {
                sb.append(" ");
            }
            return split[0] + sb.toString();
        }
        int x = blankNum / (n - 1);
        StringBuilder sb = new StringBuilder(x);
        for (int i = 0; i < x; i++) {
            sb.append(" ");
        }

        int elseBlank = blankNum - x * (n - 1);
        StringBuilder elseBlankSb = new StringBuilder(elseBlank);
        for (int i = 0; i < elseBlank; i++) {
            elseBlankSb.append(" ");
        }
        String join = String.join(sb.toString(), split);
        //计算每两个单词间的空格数量和最后一个位置的空格数量
        //拼接字符串
        return join + elseBlankSb.toString();
    }

    /**
     * 1 <= logs.length <= 103
     * 2 <= logs[i].length <= 10
     * logs[i] 包含小写英文字母，数字，'.' 和 '/'
     * logs[i] 符合语句中描述的格式
     * 文件夹名称由小写英文字母和数字组成
     */
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (depth > 0) {
                    --depth;
                }
            } else if (log.equals("./")) {
            } else {
                //x/
                ++depth;
            }
        }
        return depth;
    }

    public int specialArray(int[] nums) {
        List<Integer> numList = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int x = -1;
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) >= i + 1) {
                x = i + 1;
                continue;
            }
            if (numList.get(i) == x) {
                return -1;
            }
            break;
        }
        return x;
    }

    public double trimMean(int[] arr) {
        //5%
        int delNum = arr.length / 20;
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            minQueue.add(arr[i]);
            maxQueue.add(arr[i]);
            sum += arr[i];
            if (i > delNum - 1) {
                minQueue.poll();
                maxQueue.poll();
            }
        }
        while (!minQueue.isEmpty()) {
            sum -= minQueue.poll();
            sum -= maxQueue.poll();
        }
        return sum * 1.0 / (arr.length - 2 * delNum);
    }

}
