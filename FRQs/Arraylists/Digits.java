package FRQs.Arraylists;
import java.util.ArrayList;

public class Digits {
    private ArrayList<Integer> digitList;

    public Digits(int num) {
        // could've written a while loop that runs as long as num > 0
        // base case is when num = 0, for which we just add a 0
        String n = String.valueOf(num);
        char[] digs = n.toCharArray();
        for (char ch : digs) {
            digitList.add(0, Integer.parseInt(String.valueOf(ch)));
            // adding everything at index 0, will keep pushing values by index + 1
        }

        //alternate solution
        // while num is not = 0:
            // list.add(index of 0, num % 10) --> get very last digit
            // num /= 10 --> keep moving from left to right grabbing each indiv digit
    }

    public boolean isStrictlyIncreasing() {
        for (int i = 0; i < digitList.size() - 1; i++) {
            if (digitList.get(i + 1) > digitList.get(i)) {
                return true;
            }
        }
        return false;
    }

}