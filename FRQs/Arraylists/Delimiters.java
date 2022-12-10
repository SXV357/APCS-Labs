package FRQs.Arraylists;
import java.util.ArrayList;

public class Delimiters {
    private String openDel;
    private String closeDel;

    public Delimiters(String open, String close) {
        openDel = open;
        closeDel = close;
    }

    public ArrayList<String> getDelimitersList(String[] tokens) {
        ArrayList<String> delims = new ArrayList<String>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals(openDel) || tokens[i].equals(closeDel)) {
                delims.add(tokens[i]);
            }
        }
        return delims;
    }

    public boolean isBalanced(ArrayList<String> delimiters) {
        // we just need to check if close > open at any point so no need to grab index
        // and use a nested for loop

        // pseudocode for above:
        // vars for open and close
        // for each item in delimiters
            // if item = openDel increment open
            // else if item = closeDel increment close
            // now check if close > open and if true, return false
        // check of open = close and if true, return true
        // if not, return false

        //new solution
        
        int numOpenDel = 0;
        int numCloseDel = 0;
        for (int i = 0; i < delimiters.size(); i++){
            if (delimiters.get(i).equals(openDel)){
                numOpenDel++;
            }
            else if (delimiters.get(i).equals(closeDel)){
                numCloseDel++;
            }
            if (numCloseDel > numOpenDel){
                return false;
            }
        }
        if (numOpenDel == numCloseDel){
            return true;
        }
        else{
            return false;
        }

        // previous solution

        // boolean balance = false;
        // int numOpenDel = 0;
        // int numCloseDel = 0;
        // for (int i = 0; i < delimiters.size(); i++) {
        //     if (delimiters.get(i).equals(openDel)) {
        //         numOpenDel++;
        //     } else if (delimiters.get(i).equals(closeDel)) {
        //         numCloseDel++;
        //     }
        //     int index = delimiters.indexOf(delimiters.get(i));
        //     boolean compareCount = false;
        //     for (int j = 0; j <= index; j++) {
        //         if (delimiters.get(i).equals(closeDel) && numCloseDel > numOpenDel) {
        //             compareCount = false;
        //         }
        //     }
        //     if (!compareCount && numOpenDel == numCloseDel) {
        //         return true;
        //     }
        // }
        // return false;
    }

}