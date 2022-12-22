import java.io.IOException;

public class WordleSolverRunner {
    public static void main(String[] args) throws IOException{
        WordleSolver solver = new WordleSolver("C:/Users/14058/OneDrive/Desktop/Programming/AP CS Projects/Units 7-8(2nd 9 weeks)/ArrayLists/Lab 11 - Wordle/wordleWords.txt");
        solver.solve();
    }
}
