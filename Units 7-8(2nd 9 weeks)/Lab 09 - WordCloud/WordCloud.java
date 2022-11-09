import java.util.*;
import java.io.*;

class WordCloud<Word> {
    private ArrayList<Word> words;
    private ArrayList<Word> topHits;
    private int totalWords;
    private int uniqueWords;

    public WordCloud(String fileName) throws IOException{
        words = new ArrayList<Word>();
        topHits = new ArrayList<Word>();
        totalWords = 0;
        uniqueWords = 0;
    }

    public void load(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        while(input.hasNext()){
            String word = input.next();
            words.add((Word) word);
            totalWords++;
        }
        input.close();
    }

    public ArrayList<Word> getTopHits(){
        return topHits;
    }

    public void printInfo(){
        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Top hits: " + topHits);
    }
}
