import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;

class WordleSolver {

  private ArrayList<String> dictionary;

  public WordleSolver(String filename) throws IOException {
    this.dictionary = new ArrayList<String>();
    load(filename);
  }

  void load(String filename) throws FileNotFoundException {
    Scanner file = new Scanner(new File(filename));
    while (file.hasNext()) {
      dictionary.add(file.next());
    }
  }

  void solve() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("Enter the word you typed into the game: ");
      String guess = scanner.nextLine().toUpperCase();
      System.out.print(
        "Enter the result (X for Gray, Y for Yellow, G for Green): "
      );
      String result = scanner.nextLine().toUpperCase();
      for (int i = 0; i < dictionary.size(); i++) {
        String word = dictionary.get(i);
        for (int j = 0; j < word.length(); j++) {
          char c = word.charAt(j);
          if (result.charAt(j) == 'G') {
            if (word.indexOf(c) != guess.indexOf(guess.charAt(j))) {
              dictionary.remove(dictionary.indexOf(word));
            }
          }           
          else if (result.charAt(j) == 'Y') {
            if (
              c != guess.charAt(j) &&
              word.indexOf(c) == guess.indexOf(guess.charAt(j))
            ) {
              dictionary.remove(dictionary.indexOf(word));
            }
          } else if (result.charAt(j) == 'X') {
            if (c == guess.charAt(j)) {
              dictionary.remove(dictionary.indexOf(word));
            }
          }
        }
      }

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
