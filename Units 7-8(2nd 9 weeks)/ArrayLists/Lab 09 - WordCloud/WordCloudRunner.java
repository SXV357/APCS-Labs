import java.io.IOException;

public class WordCloudRunner {
    public static void main(String[] args) throws IOException{
        WordCloud cloud = new WordCloud("C:/Users/14058/OneDrive/Desktop/Programming/AP CS Projects/Units 7-8(2nd 9 weeks)/Lab 09 - WordCloud/dream.txt");
        cloud.printInfo();
    }
}
