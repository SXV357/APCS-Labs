import java.util.Arrays;

public class ArrayResizer {
    public static void main(String[] args) {

        int[][] arr = { { 2, 1, 0 }, { 1, 3, 2 }, { 0, 0, 0 }, { 4, 5, 6 } };
        System.out.println(isNonZeroRow(arr, 0));
        System.out.println(isNonZeroRow(arr, 1));
        System.out.println(isNonZeroRow(arr, 2));
        System.out.println(isNonZeroRow(arr, 3));
        System.out.println(numNonZeroRows(arr));
        System.out.println(Arrays.deepToString(arr));

    }

    public static boolean isNonZeroRow(int[][] array2D, int r) {
        boolean nonZero = false;
        for (int c = 0; c < array2D[0].length; c++) {
            if (array2D[r][c] != 0) {
                nonZero = true;
            } else {
                nonZero = false;
            }
        }
        return nonZero;
    }

    public static int numNonZeroRows(int[][] array2D) {
        int count = 0;
        for (int r = 0; r < array2D.length; r++) {
            if (isNonZeroRow(array2D, r)) {
                count++;
            }
        }
        return count;
    }

    public static int[][] resize(int[][] array2D) {
        int[][] resized = new int[numNonZeroRows(array2D)][array2D[0].length];
        int r = 0;
        for (int i = 0; i < array2D.length; i++) {
            if (isNonZeroRow(array2D, i)) {
                for (int j = 0; j < array2D[0].length; j++){
                    resized[r][j] = array2D[i][j];
                }
                r++;
            }
        }
        return resized;
    }

}