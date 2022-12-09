package FRQs.Arraylists;
import java.util.ArrayList;

public class UserName {
    private ArrayList<String> possibleNames;

    public UserName(String firstName, String lastName){
        possibleNames = new ArrayList<String>(); // need to construct it locally as well
        for (int i = 0; i < firstName.length(); i++){
            possibleNames.add(lastName + firstName.substring(0, i + 1));
        }
    }

    public boolean isUsed(String name, String[] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == name){
                return true;
            }
        }
        return false;
    }

    public void setAvailableUserNames(String[] usedNames){
        for (int i = 0; i < possibleNames.size(); i++){
            if (isUsed(possibleNames.get(i), usedNames)){
                possibleNames.remove(i); // remove item at that index
                i++;
            }
        }
    }
}
