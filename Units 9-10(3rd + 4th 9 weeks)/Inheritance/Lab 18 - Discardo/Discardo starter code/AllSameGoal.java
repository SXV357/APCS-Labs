public class AllSameGoal implements Goal
{
    int primaryGoal;
    public AllSameGoal(int primaryGoal){
        this.primaryGoal = primaryGoal;
    }

	@Override
    public boolean hasWon(int[] hand){
        int count = 0;
        for (int i = 0; i < hand.length; i++){
            if (hand[i] == this.primaryGoal){
                count++;
            }
        }
        return count == hand.length;
    }

    public static void main(String[] args){
        Goal goal2 = new AllSameGoal(2);
        int[] hand1 = {2, 2, 2, 8, 2};
        System.out.println(goal2.hasWon(hand1));
        int[] hand2 = {2, 2, 2, 2, 2, 2};
        System.out.println(goal2.hasWon(hand2));
        int[] hand3 = {5, 5, 5, 5};
        System.out.println(goal2.hasWon(hand3));
        Goal only5 = new AllSameGoal(5);
        System.out.println(only5.hasWon(hand3));

    }

}