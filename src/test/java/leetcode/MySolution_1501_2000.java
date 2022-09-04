package leetcode;

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

}
