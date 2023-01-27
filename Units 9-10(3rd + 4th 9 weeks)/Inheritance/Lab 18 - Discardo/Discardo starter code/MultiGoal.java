import java.util.*;

public class MultiGoal implements Goal
{
    private List<Goal> goals;

    public MultiGoal(){
        this.goals = new ArrayList<Goal>();
    }

    public void addGoal(Goal g){
        this.goals.add(g);
    }

    @Override
    public boolean hasWon(int[] hand){
        for (Goal g : this.goals){
            if (g.hasWon(hand)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        MultiGoal mg = new MultiGoal();
        mg.addGoal(new RunGoal());
        mg.addGoal(new AllSameGoal(9));
        int[] hand1 = {4, 5, 6, 7};
        System.out.println(mg.hasWon(hand1));
        int[] hand2 = {9, 9, 9};
        System.out.println(mg.hasWon(hand2));
        int[] hand3 = {5, 5, 5};
        System.out.println(mg.hasWon(hand3));

    }
}