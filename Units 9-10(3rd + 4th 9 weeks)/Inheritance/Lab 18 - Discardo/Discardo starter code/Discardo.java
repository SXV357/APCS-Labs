import java.util.*;

public class Discardo
{
	public static void main(String[] args) {
		Discardo.test();
        // Discardo.play(new Human(), 4, new AllSameGoal(7));
        // Discardo.play(new Bot(),   3, new RunGoal());
	}
	
    public static void test()
    {
        int numCards = 3;
        int numTurns = play(new Bot(), numCards, new RunGoal());
        System.out.println("Player reached goal in " + numTurns + " turns");
    }
    public static int play(Player p, int numCards, Goal goal) // both rungoal and allsamegoal are implementing goal
    {
        int[] hand = new int[numCards];
        
        for (int i = 0; i < hand.length; i++)
            hand[i] = randomCard();

        p.init(hand, goal);

        int numTurns = 0;

        while (numTurns < 100 && !goal.hasWon(hand))
        {
            System.out.println("Turns Taken:  " + numTurns);
            System.out.println("Hand:  " + Arrays.toString(hand));
            p.maybeReplaceCard(randomCard());
            numTurns++;
        }
        System.out.println("Turns Taken:  " + numTurns);
        System.out.println("Hand:  " + Arrays.toString(hand));

        return numTurns;
    }

    public static int randomCard()
    {
        return (int)(Math.random() * 9) + 1;
    }
}