import java.io.FileNotFoundException;

public class NumbrixMain {

  /**
   * Constructs a Numbrix object and uses it to solve a Numbrix puzzle.
   * @throws FileNotFoundException when fileName file does not exist.
   */
  public static void main(String[] args) throws FileNotFoundException {
    Numbrix puzzle = new Numbrix("C:/Users/14058/OneDrive/Desktop/Programming/AP CS Projects/Units 9-10(3rd + 4th 9 weeks)/Recursion-Searching-Sorting/Lab 20 - Numbrix Puzzle/Data.txt");
    // System.out.println(puzzle);
    puzzle.solve();
  }
}
