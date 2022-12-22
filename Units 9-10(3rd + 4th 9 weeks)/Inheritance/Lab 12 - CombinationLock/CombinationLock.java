import java.util.*;

public class CombinationLock extends Lock {
    String combination;

    public CombinationLock(){
        super();
        combination = "";
    }

    public CombinationLock(String combo){
        super();
        combination = combo;
    }

    void setCombination(String c){
        combination = c;
    }

    String getCombination(){
        return combination;
    }

    @Override
    void open(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter combo: ");
        String combo = input.nextLine();
        if (combo.equals(combination)){
            super.open();
        }
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + "Combination = " + combination + "\n";
    }
}
