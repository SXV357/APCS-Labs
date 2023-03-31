public class RecurProbsTester {
    public static void main(String[] args){
        System.out.println(RecurProbs.isPalindrome("a"));
        System.out.println(RecurProbs.isPalindrome(""));

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

    }

    // Happy numbers problem
    public boolean isHappy(int n){
        return false;
    }
}
