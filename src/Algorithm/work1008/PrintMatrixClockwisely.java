package Algorithm.work1008;

public class PrintMatrixClockwisely {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        printMatrixClockwisely(matrix);
    }

    private static void printMatrixClockwisely(int[][] matrix) {
        if(matrix == null)
            return;
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows == 0 || cols == 0)
            return;

        int start = 0;
        while(cols > start * 2 && rows > start * 2){
            printMatrixCircle(matrix, rows, cols, start);
            start++;
        }
    }

    private static void printMatrixCircle(int[][] matrix, int rows, int cols, int start) {
        int endX = cols - start - 1;
        int endY = rows - start - 1;

        // 从左往右打印一行
        for (int i = start; i <= endX; i++) {
            System.out.print(matrix[start][i] + ",");
        }
        // 从上往下打印一列
        if(endY > start){
            for (int i = start+1; i <= endY; i++) {
                System.out.print(matrix[i][endX] + ",");
            }
        }
        // 从右往左打印一行
        if(endX > start && endY > start){
            for (int i = endX-1; i >= start; i--) {
                System.out.print(matrix[endY][i] + ",");
            }
        }
        // 从下往上打印一列
        if(endX > start && endY > start + 1){
            for (int i = endY-1; i >= start + 1; i--) {
                System.out.print(matrix[i][start] + ",");
            }
        }
    }
}
