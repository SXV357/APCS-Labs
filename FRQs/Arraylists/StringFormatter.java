package FRQs.Arraylists;
import java.util.List;

public class StringFormatter {
    public static int totalLetters(List<String> wordList) {
        /* Correct */
        int total = 0;
        for (int i = 0; i < wordList.size(); i++) {
            total += wordList.get(i).length();
        }
        return total;
    }

    public static int basicGapWidth(List<String> wordList, int formattedLen) {
        if (wordList.size() - 1 == 1) {
            return (formattedLen - totalLetters(wordList)) + 1;
        } else if (wordList.size() - 1 > 1) {
            return (formattedLen - totalLetters(wordList)) - (wordList.size() - 1); /*Correct */
        }
        return 0;
    }

    public static int leftoverSpaces(List<String> wordList, int formattedLen) {
        return 0;

    }

    public static String format(List<String> wordList, int formattedLen) {
        /*
         * main idea:
            * get gap width + leftover spaces
            * first add all words in order to formatted string
            * then add all basic width gaps
            * then add all left over spaces until it is = 0
            * to ensure no extra spots left, manipulate the string by adding the last item in the arraylist so it gets pushed to the very end
         */
        String formatted = "";
        int gapWidth = basicGapWidth(wordList, formattedLen);
        int leftOver = leftoverSpaces(wordList, formattedLen);
        for (int i = 0; i < wordList.size(); i++) {
            formatted += wordList.get(i);
            for (int j = 0; j < gapWidth; j++) {
                formatted += " ";
            }
            while (leftOver > 0) {
                formatted += " ";
                leftOver--;
            }
        }
        formatted += wordList.get(wordList.size() - 1); /*to prevent any extra spaces from being left */
        return formatted;
    }
}
