import java.util.*;
import java.io.*;

class WordCloud {
    private ArrayList<Word> words;
    private ArrayList<Word> topHits;
    private int totalWords;
    private int uniqueWords;

    public WordCloud(String fileName) throws IOException {
        words = new ArrayList<>();
        topHits = new ArrayList<>();
        totalWords = 0;
        uniqueWords = 0;
        load("C:/Users/14058/OneDrive/Desktop/Programming/AP CS Projects/Units 7-8(2nd 9 weeks)/Lab 09 - WordCloud/dream.txt");
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
        while (input.hasNext()) {
            String word = input.next().toLowerCase();
            for (int i = 0; i < word.length(); i++) {
                if (!Character.isLetterOrDigit(word.charAt(i))) {
                    word = word.substring(0, i) + word.substring(i + 1);
                }
            }
            if (word.length() > 0) {
                totalWords++;
                int index = getIndex(word);
                if (index == -1) {
                    words.add(new Word(word));
                    uniqueWords++;
                } else {
                    words.get(index).increment();
                }
            }
        }
        findTopHits();
    }

    private void findTopHits() {
        for (int i = 0; i < 30; i++) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < words.size(); j++) {
                if (words.get(j).getCount() > max) {
                    max = words.get(j).getCount();
                    index = j;
                }
            }
            topHits.add(words.get(index));
            words.remove(index);
        }
    }

    public ArrayList<Word> getTopHits() {
        return topHits;
    }

    public void printInfo() {
        System.out.println("Total words: " + totalWords);
        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Top hits: ");
        System.out.println("Word\t\tFrequency");
        for (int i = 0; i < topHits.size(); i++) {
            System.out.println(topHits.get(i));
        }
    }

}
