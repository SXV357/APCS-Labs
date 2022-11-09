import java.util.Arrays;
public class ArrayTester {

    public static void main(String[] args){
        int[][] arr2D = {{0,1,2},{3,4,5},{6,7,8},{9,5,3}};
        System.out.println(Arrays.toString(getColumn(arr2D, 1)));

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {3,5,2,4,1};
        System.out.println(hasAllValues(arr1, arr2));
    }
    
    public static int[] getColumn(int[][] arr2D, int c){
        int[] arr = new int[arr2D.length];
        for (int r = 0; r < arr2D.length; r++){
            arr[r] = arr2D[r][c];
        }
        return arr;

    }

    public static boolean hasAllValues(int[] arr1, int[] arr2){
        for (int i = 0; i < arr1.length; i++){
            boolean found = false;
            for (int j = 0; j < arr2.length; j++){
                if (arr1[i] == arr2[j]){
                    found = true;
                    break;
                }
            }
            if (!found){
                return false;
            }
        }
        return true;
    }

    public static boolean containsDuplicates(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] == arr[i + 1]){
                return true;
            }
        }
        return false;
    }

    public static boolean isLatin(int[][] square){
        int[] firstRow = square[0];
        if (containsDuplicates(firstRow)){
            return false;
        }
        for (int i = 1; i < square.length; i++){
            if (!hasAllValues(firstRow, square[i])){
                return false;
            }
        }
        for (int i = 0; i < square.length; i++){
            if (!hasAllValues(firstRow, getColumn(square, i))){
                return false;
            }
        }
        return true;
    }
}
