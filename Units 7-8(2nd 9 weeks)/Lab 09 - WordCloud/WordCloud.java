import java.util.*;
import java.io.*;

public class WordCloud {
    ArrayList<Word> words;
    ArrayList<Word> topHits;
    int totalWords;
    int uniqueWords;

    public WordCloud(String fileName) throws IOException {
        words = new ArrayList<>();
        topHits = new ArrayList<>();
        totalWords = 0;
        uniqueWords = 0;
    }

    private int getIndex(String str) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getWord().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private void load(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNext()){
            String word = input.next().toLowerCase();
            for (int i = 0; i < word.length() - 1; i++){
                int idx = word.indexOf('-');
            }
        }
    }

    private void findTopHits(){

    }

    public ArrayList<Word> getTopHits() {
        return topHits;
    }

    public void printInfo(){

    }

}
