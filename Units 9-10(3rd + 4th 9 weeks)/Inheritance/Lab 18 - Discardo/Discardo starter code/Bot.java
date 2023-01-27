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
        if (this.goal instanceof RunGoal){
            if (this.goal.hasWon(this.hand)){
                return;
            }
            else {
                if (card == 1){
                    int lowestCard = this.hand[0];
                    int lowestCardIndex = 0;
                    for (int i = 0; i < this.hand.length; i++){
                        if (this.hand[i] < lowestCard){
                            lowestCard = this.hand[i];
                            lowestCardIndex = i;
                        }
                    }
                    this.hand[lowestCardIndex] = card;
                }
                else if (card == 9){
                    int highestCard = this.hand[0];
                    int highestCardIndex = 0;
                    for (int i = 0; i < this.hand.length; i++){
                        if (this.hand[i] > highestCard){
                            highestCard = this.hand[i];
                            highestCardIndex = i;
                        }
                    }
                    this.hand[highestCardIndex] = card;
                }
                else {
                    int closestCard = this.hand[0];
                    int closestCardIndex = 0;
                    for (int i = 0; i < this.hand.length; i++){
                        if (Math.abs(this.hand[i] - card) < Math.abs(closestCard - card)){
                            closestCard = this.hand[i];
                            closestCardIndex = i;
                        }
                    }
                    this.hand[closestCardIndex] = card;
                }
            }
        }
        
        else if (this.goal instanceof AllSameGoal){
            if (this.goal.hasWon(this.hand)){
                return;
            }
            else {
                int cardToReplace = this.hand[0];
                int cardToReplaceIndex = 0;
                for (int i = 0; i < this.hand.length; i++){
                    if (this.hand[i] != card){
                        cardToReplace = this.hand[i];
                        cardToReplaceIndex = i;
                    }
                }
                this.hand[cardToReplaceIndex] = card;
            }
        }

        else if (this.goal instanceof MultiGoal){
            if (this.goal.hasWon(this.hand)){
                return;
            }
            else {
                if (card == 1){
                    int lowestCard = this.hand[0];
                    int lowestCardIndex = 0;
                    for (int i = 0; i < this.hand.length; i++){
                        if (this.hand[i] < lowestCard){
                            lowestCard = this.hand[i];
                            lowestCardIndex = i;
                        }
                    }
                    this.hand[lowestCardIndex] = card;
                }
                else if (card == 9){
                    int highestCard = this.hand[0];
                    int highestCardIndex = 0;
                    for (int i = 0; i < this.hand.length; i++){
                        if (this.hand[i] > highestCard){
                            highestCard = this.hand[i];
                            highestCardIndex = i;
                        }
                    }
                    this.hand[highestCardIndex] = card;
                }
                else {
                    int closestCard = this.hand[0];
                    int closestCardIndex = 0;
                    for (int i = 0; i < this.hand.length; i++){
                        if (Math.abs(this.hand[i] - card) < Math.abs(closestCard - card)){
                            closestCard = this.hand[i];
                            closestCardIndex = i;
                        }
                    }
                    this.hand[closestCardIndex] = card;
                }
            }
        }
    }
}