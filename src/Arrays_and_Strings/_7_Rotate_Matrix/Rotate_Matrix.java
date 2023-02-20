package Arrays_and_Strings._7_Rotate_Matrix;
// QUESTION
// Given an image represented by an NxN matrix, where each pixel in the image is 4
// bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
//
// EXPLANATION
// Because we're rotating the matrix by 90 degrees, the easiest way to do this is to implement the rotation in
// layers. We perform a circular rotation on each layer, moving the top edge to the right edge, the right edge
// to the bottom edge, the bottom edge to the left edge, and the left edge to the top edge.
// How do we perform this four-way edge swap? One option is to copy the top edge to an array, and then
// move the left to the top, the bottom to the left, and so on. This requires O(N) memory, which is actually
// unnecessary.
// A better way to do this is to implement the swap index by index. In this case, we do the following:
// 1 for i = 0 to n
// 2 temp= top[i];
// 3 top[i] = left[i]
// 4 left[i] = bottom[i]
// 5 bottom[i] = right[i]
// 6 right[i] = temp
//
// HINT                                                                         T
// 00 10 20 30    so 1st layer     00, 01, 02 = left        and 2nd layer   L 11,21 R
// 01 11 21 31                     03, 13, 23 = bottom                        12,22
// 02 12 22 32                     33, 32, 31 = right                           B
// 03 13 23 33                     30, 20, 10 = top
//
// We perform such a swap on each layer, starting from the outermost layer and working our way inwards.
// (Alternatively, we could start from the inner layer and work outwards.)
public class Rotate_Matrix {
    boolean rotate(int[][] matrix){

        // check so not empty matrix and symmetrical sides
        if(matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int rowLength  = matrix.length;
        int columnLength = matrix[0].length;

        // first - first arg and doesn't change in current layer
        // last - last arg and doesn't change in current layer
        // increment - starts with first arg and incrementing
        // decrement - starts with last arg and decrementing
        for(int first = 0; first < rowLength; first++){

            // update lastSame
            int last = rowLength - 1 - first;
            // to step in next layer, start with row
            for(int increment = first; increment < last; increment++){

                // update lastDecrement
                int lastDecrement = columnLength - 1 - increment;

                // remember left
                int left = matrix[first][increment];

                // left = top
                matrix[first][increment] = matrix[lastDecrement][first];

                // top = right
                matrix[lastDecrement][first] = matrix[last][lastDecrement];

                // right = bottom
                matrix[last][lastDecrement] = matrix[increment][last];

                // bottom = left
                matrix[increment][last] = left;
            }
        }
        return true;
    }

    // TEST
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}};

        System.out.println("Before rotation:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        Rotate_Matrix rotateMatrix = new Rotate_Matrix();
        boolean result = rotateMatrix.rotate(matrix);

        if (result) {
            System.out.println("After rotation:");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Invalid matrix");
        }
    }
}
