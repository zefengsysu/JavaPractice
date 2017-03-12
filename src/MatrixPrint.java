import java.util.ArrayList;

/**
 * Created by Wangzf5 on 2017/3/10.
 */
public class MatrixPrint {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        if (matrix == null) {
            return res;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        if (rows == 1) {
            for (int i = 0; i < columns; i++) {
                res.add(matrix[0][i]);
            }

            return res;
        }
        if (columns == 1) {
            for (int i = 0; i < rows; i++) {
                res.add(matrix[i][0]);
            }

            return res;
        }

        int originRows = rows, originColumns = columns;
        boolean center = rows == columns && rows % 2 != 0;

        int count = rows <= columns ? (rows + 1) / 2 : (columns + 1) / 2;
        for (int i = 0, start = 0; i < count; i++) {
            for (int j = start; j < columns - 1; j++) {
                res.add(matrix[start][j]);
            }
            for (int j = start; j < rows - 1; j++) {
                res.add(matrix[j][columns - 1]);
            }
            for (int j = columns - 1; j > start; j--) {
                res.add(matrix[rows -1][j]);
            }
            for (int j = rows - 1; j > start; j--) {
                res.add(matrix[j][start]);
            }
            start++;
            rows--;
            columns--;
        }

        if (center) {
            res.add(matrix[originRows / 2][originColumns / 2]);
        }

        return res;
    }

    public static void main(String args[]) {
        MatrixPrint m = new MatrixPrint();
        System.out.print(m.printMatrix(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}}));
    }
}
