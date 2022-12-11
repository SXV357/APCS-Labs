package FRQs.Arraylists;
import java.util.ArrayList;

public class WordPairList {
    private ArrayList<WordPair> allPairs;

    public WordPairList(String[] words) {
        // -1 because didn't create a local allPairs arraylist
        // -1 because of bound error(loop till words.length - 1 for outer loop)
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                allPairs.add(new WordPair(words[i], words[j]));
            }
        }
    }

    public int numMatches() {
        int match = 0;
        // can also use a for each loop to make it more concise
        for (int i = 0; i < allPairs.size(); i++) {
            if (allPairs.get(i).getFirst().equals(allPairs.get(i).getSecond())) {
                match++;
            }
        }
        return match;
    }
}
