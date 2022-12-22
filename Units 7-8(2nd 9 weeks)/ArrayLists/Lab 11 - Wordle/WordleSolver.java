import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;

class WordleSolver {

  private ArrayList<String> dictionary;

  public WordleSolver(String filename) throws IOException{
    this.dictionary = new ArrayList<String>();
    load(filename);
  }

  public void load(String filename) throws FileNotFoundException{
    Scanner file = new Scanner(new File(filename));
    while (file.hasNext()) {
      dictionary.add(file.next());
    }
  }

  public void solve() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("Enter the word you typed into the game: ");
      String guess = scanner.nextLine().toUpperCase();
      System.out.print(
        "Enter the result (X for Gray, Y for Yellow, G for Green): "
      );
      String result = scanner.nextLine().toUpperCase();

      for (int i = dictionary.size() - 1; i >= 0; i--) {
        String word = dictionary.get(i);
        for (int j = 0; j < word.length(); j++) {
          char c = word.charAt(j);
          if (result.charAt(j) == 'G' && c != guess.charAt(j)) {
            dictionary.remove(i);
            break;
          } else if (
            result.charAt(j) == 'Y' && (c != guess.charAt(j) || c == 'X')
          ) {
            dictionary.remove(i);
            break;
          } else if (result.charAt(j) == 'X' && c == guess.charAt(j)) {
            dictionary.remove(i);
            break;
          }
        }
      }
      scanner.close();

      System.out.println("Words left in the dictionary: " + dictionary);

      if (dictionary.size() > 0) {
        int index = (int) (Math.random() * dictionary.size());
        System.out.println("Suggested word: " + dictionary.get(index));
      } else {
        System.out.println("No more words left in the dictionary.");
        break;
      }
    }
  }
}
