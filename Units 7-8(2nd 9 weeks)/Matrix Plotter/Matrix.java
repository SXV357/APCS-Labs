import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] x = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] y = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(Arrays.equals(x, y)); // both represent objects that store references to other objects so if
                                                 // comparing them, will return false
        System.out.println(Arrays.deepEquals(x, y)); // goes deeper into content of both arrays

        x = y; // setting references equal to one another. when calling method again, it will
               // return true
        System.out.println(Arrays.equals(x, y));
    }
}
