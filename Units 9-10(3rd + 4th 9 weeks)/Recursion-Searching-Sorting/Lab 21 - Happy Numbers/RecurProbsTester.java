import java.util.ArrayList;

public class RecurProbsTester {
    public static void main(String[] args){
        System.out.println(RecurProbs.isPalindrome("racecar"));
        System.out.println(RecurProbs.isPalindrome("madam"));
        
        RecurProbs.timesTwo(80);
        System.out.println();
        RecurProbs.timesTwo(68);

        for (int i = 0; i <= 50; i++){
            System.out.print(RecurProbs.tri(i) + " ");
        }
        for (int i = 0; i <= 50; i++){
            System.out.print(RecurProbs.penta(i) + " ");
        }

        System.out.println(RecurProbs.arraySum(new int[] {5, 3, 1, 2, 4}, 0)); 

        System.out.println(RecurProbs.curlyString("what's {all this} then"));

        RecurProbs.printPattern2(16);

        RecurProbs.printSquares(5);
        System.out.println();
        RecurProbs.printSquares(8);

        System.out.println(RecurProbs.wordWrap("hello, how are you doing today?", 13));

        HappyNumber number = new HappyNumber(new ArrayList<Integer>());
        System.out.println(number.isHappy(19));
        System.out.println(number.isHappy(230));
        System.out.println(number.isHappy(231));

    }
}

class HappyNumber {

    private ArrayList<Integer> nums;

    public HappyNumber(ArrayList<Integer> nums){
        this.nums = new ArrayList<Integer>();
    }

    // Client method
    boolean isHappy(int n){
        return this.isHappyRecursive(n);
    }

    // Helper methods
    int nextInSeries(int prev){
        int next = 0;
        while (prev > 0){
            next += Math.pow(prev % 10, 2);
            prev /= 10;
        }
        return next;
    }

    boolean isHappyRecursive(int n){
        if (n == 1){
            return true;
        }
        if (nums.contains(n)){
            return false;
        }
        else {
            nums.add(n);
            return isHappyRecursive(this.nextInSeries(n));
        }
    }
}
