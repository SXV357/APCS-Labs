import java.util.Arrays;
import java.util.ArrayList;

class RecurProbs {

    static boolean isPalindrome(String str){
        if (str == "" || str.length() == 1){
            return true;
        }
        else {
            return str.charAt(0) == str.charAt(str.length() -1) ? isPalindrome(str.substring(1, str.length() - 1)) : false;
        }
    }

    static boolean isPrime(int reference, int num){
        if (num < 0 || num == 0 || num == 1 || num % reference == 0){
            return false;
        }
        if (reference == num){
            return true;
        }
        else {
            reference += 1;
            return isPrime(reference, num);
        }
    }

    static void timesTwo(int n){
        if (n == 2){
            System.out.print("2 * 1");
        }
        if (n % 2 != 0){
            System.out.print(+ n);
        }
        else {
            if (n % 2 == 0){
                System.out.print("2 * ");
            }
            timesTwo(n / 2);
        }
    }

    static int tri(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        else {
            return n + tri(n-1);
        }
    }

    static int penta(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        else {
            return ((3 * n) - 2) + penta(n-1);
        }
    }

    static int arraySum(int[] arr, int index){
        if (arr.length == 0){
            return 0;
        }
        if (arr.length == 1){
            return arr[0];
        }
        else {
            int[] modified = Arrays.copyOfRange(arr, index + 1, arr.length);
            return arr[index] + arraySum(modified, index);
        }
    }

    // Helper method
    static String reverseString(String str){
        if (str.equals("")){
            return "";
        }
        if (str.length() == 1){
            return str;
        }
        else{
            return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
        }
    }
    // Client method
    static void printReverse(String str){
        System.out.println(reverseString(str));
    }

    static boolean isPowerOfN(int num, int base){
        if (num == 1){
            return true; // any base raised to the 0 power is 1 so it holds true for every number
        }
        if (num == 0){
            return true;
        }
        else {
            num /= base;
            return isPowerOfN(num, base);
        }
    }

    static String curlyString(String str){
        if (str.length() == 0 || str.indexOf("{") == -1){
            return "";
        }
        else {
            return str.charAt(0) == '{' ? str.substring(str.indexOf("{"), str.indexOf("}") + 1) : curlyString(str.substring(1));
        }
    }

      static ArrayList<Integer> nums = new ArrayList<Integer>();
      static void printPattern2(int n){
        if (n < 0){
            System.out.print(n + " ");
            nums.add(n);
        }
        else {
            System.out.print(n + " ");
            nums.add(n);
            printPattern2(n-5);
        }
        System.out.print(nums.get(0) + " ");
    }

    static void printSquares(int n){
        if (n == 0){
            System.out.print(n);
        }
        if (n == 1){
            System.out.print(n + " ");
        }
        else{
            if (n % 2 != 0){
                System.out.print(((int) Math.pow(n, 2)) + " ");
                printSquares(n - 2);
            }
            if (n % 2 == 0){
                n -= 1;
                System.out.print(((int)Math.pow(n, 2)) + " ");
                printSquares(n-2);
            }
        }
        for (int i = 2; i <= n; i += 2){
            System.out.print(((int)Math.pow(i, 2)) + " ");
        }
    }

    static String wordWrap(String line, int width){
        if (line.length() < width){
            return line;
        }
        if (line.length() == 0){
            return "";
        }
        else {
            String modified = line.substring(0, width + 1) + "\n";
            return modified + wordWrap(line.substring(width + 1), width);
        }
    }
}