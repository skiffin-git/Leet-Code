package Arrays_and_Strings._8_Zero_Matrix;
// QUESTION
// Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
// column are set to 0.
//
// EXPLANATION
// At first glance, this problem seems easy: just iterate through the matrix and every time we see a cell with
// value zero, set its row and column to 0. There's one problem with that solution though: when we come
// across other cells in that row or column, we'll see the zeros and change their row and column to zero. Pretty
// soon, our entire matrix will be set to zeros.
// One way around this is to keep a second matrix which flags the zero locations. We would then do a second
// pass through the matrix to set the zeros. This would take O(MN) space.
// Do we really need O(MN) space? No. Since we're going to set the entire row and column to zero, we don't
// need to track that it was exactly cell [ 2] [ 4] (row 2, column 4). We only need to know that row 2 has a
// zero somewhere, and column 4 has a zero somewhere. We'll set the entire row and column to zero anyway,
// so why would we care to keep track of the exact location of the zero?
// The code below implements this algorithm. We use two arrays to keep track of all the rows with zeros and all
// the columns with zeros. We then nullify rows and columns based on the values in these arrays.
public class Zero_Matrix {
    boolean setZeros(int[][] matrix) {

        // check if matrix empty
        if(matrix.length < 1){
            return false;
        }

        boolean[] rowsWithZeros = new boolean[matrix.length];
        boolean[] columnWithZeros = new boolean[matrix[0].length];

        // find zeros in matrix and remember the rows and columns with zeros
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsWithZeros[i] = true;
                    columnWithZeros[j] = true;
                }
            }
        }

        // nullify rows and zeros that had zero in them
        for(int i = 0; i < rowsWithZeros.length; i++){
            if(rowsWithZeros[i]){
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
            if(columnWithZeros[i]){
                for(int j = 0; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        return true;
    }

    // TEST
    public static void main(String[] args) {
        Zero_Matrix zeroMatrix = new Zero_Matrix();

        // Test case 1: matrix with zeros
        int[][] matrix1 = {
                {1, 0, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Before setting zeros:");
        printMatrix(matrix1);
        zeroMatrix.setZeros(matrix1);
        System.out.println("After setting zeros:");
        printMatrix(matrix1);

        // Test case 2: matrix with no zeros
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Before setting zeros:");
        printMatrix(matrix2);
        zeroMatrix.setZeros(matrix2);
        System.out.println("After setting zeros:");
        printMatrix(matrix2);

        // Test case 3: empty matrix
        int[][] matrix3 = {};
        System.out.println("Before setting zeros:");
        printMatrix(matrix3);
        zeroMatrix.setZeros(matrix3);
        System.out.println("After setting zeros:");
        printMatrix(matrix3);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

}
