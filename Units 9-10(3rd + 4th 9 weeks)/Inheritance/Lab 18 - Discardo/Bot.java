public class Bot implements Player
{
    private int[] hand;
    private Goal goal;

    @Override
	public void init(int[] hand, Goal goal){
        this.hand = hand;
        this.goal = goal;
    }

    @Override
	public void maybeReplaceCard(int card){
        if (this.goal instanceof AllSameGoal){
            AllSameGoal g = (AllSameGoal) this.goal;
            int primaryGoal = g.primaryGoal;
            int count = 0;
            for (int i = 0; i < this.hand.length; i++){
                if (this.hand[i] == primaryGoal){
                    count++;
                }
            }
            if (count < this.hand.length){
                for (int i = 0; i < this.hand.length; i++){
                    if (this.hand[i] != primaryGoal){
                        this.hand[i] = card;
                        break;
                    }
                }
            }
        } else if (this.goal instanceof RunGoal){
            RunGoal g = (RunGoal) this.goal;
            int[] run = new int[hand.length];
            int count = 0;
            for (int i = 0; i < this.hand.length; i++){
                if (this.hand[i] == run[i]){
                    count++;
                }
            }
            if (count < this.hand.length){
                for (int i = 0; i < this.hand.length; i++){
                    if (this.hand[i] != run[i]){
                        this.hand[i] = card;
                        break;
                    }
                }
            }
        }
    }
}