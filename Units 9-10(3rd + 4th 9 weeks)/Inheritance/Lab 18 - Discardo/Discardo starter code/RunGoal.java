public class RunGoal implements Goal
{
    public boolean hasWon(int[] hand)
    {
		//Below: a clever method for detecting a run in arbitrary order
		//see if you can figure out how it works
		//alternative: simply sorting the array first (but will be slower for large arrays)
		
        int[] freqs = new int[10];
        
        for (int i = 0; i < hand.length; i++)
            freqs[hand[i]]++;
            // hand = [1,3,1]
            // Iteration 1: freqs[1] = freqs[1] + 1 --> [0,1,0,0,0,0,0,0,0,0]
            // Iteration 2: freqs[3] = freqs[3] + 1 --> [0,1,0,1,0,0,0,0,0,0]
            // Iteration 3: freqs[1] = freqs[1] + 1 --> [0,2,0,1,0,0,0,0,0,0]
        
        // int count = 0;
        int low   = 0;
        
        while (freqs[low] == 0) // true
            low++; // low = 1
        
        for (int i = 1; i < hand.length; i++)
            // Iteration 1: 1 + 1 >= 10 || freqs[2] != 1(true) --> return false
            // Iteration 2: 1 + 2 >= 10 || freqs[3] != 1(true) --> return false
            // Iteration 3: 1 + 3 >= 10 || freqs[4] != 1(true) --> return false
            if (low + i >= 10 || freqs[low + i] != 1)
                return false;

        return true;
    }

    // Conditions

    // Example hand: [1,3,1]
    // Not a run because there are duplicates and they can't be arranged in increasing order
    // For increasing order, there will need to be consecutive numbers one after the other
    // Example hand: [4,3,1,2]
    // Run because all unique numbers and can be arranged in ascending order with each number 1 more than the previous

    public static void main(String[] args){
        Goal g = new RunGoal(); //RunGoal is-a Goal
        int[] hand1 = {4, 3, 1};
        System.out.println(g.hasWon(hand1)); // false
        int[] hand2 = {4, 3, 1, 2};
        System.out.println(g.hasWon(hand2)); // true

    }
}