import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvilHangman {

  private boolean debug;
  private Scanner in;
  private List<String> wordList;
  private int wordLength;
  private int remainingGuesses;
  private String solution;
  private String guessedLetters;

  /**
   * Construct an EvilHangman object.
   * @param fileName the name of the file that contains the word list.
   * @param debug indicates if the size of the remaining word list
   *        should be included in the toString result.
   */
  public EvilHangman(String fileName, boolean debug)
    throws FileNotFoundException {
    this.debug = debug;
    inputWords(fileName);
    System.out.print("Number of guesses? ");
    this.remainingGuesses = in.nextInt();
    this.solution = "-".repeat(this.wordLength);
    this.guessedLetters = this.solution;
    in.close();
  }

  /**
   * Plays one the game.  The user guesses letters until either
   * they guess the word, or they run out of guesses.
   * Game status is printed each turn and winning / losing
   * information is printed at the conclusion of the game.
   */
  public void playGame() {}

  /**
   * Creates and returns a status string that indicates the
   * state of the game.
   * @return the game status string.
   */
  public String toString() {
	return debug ? "\n" + "Remaining guesses:" + remainingGuesses + "\n" + "Guessed letters:" + guessedLetters + "\n" + "Solution:" + solution + "\n" + "Remaining words:" + wordList.size() + "\n" : 
	"\n" + "Remaining guesses:" + remainingGuesses + "\n" + "Guessed letters:" + guessedLetters + "\n" + "Solution:" + solution + "\n";
  }

  ////////// PRIVATE HELPER METHODS //////////

  /**
   * Helper method for the constructor:
   * Inputs the word length from the user, reads in the words from
   * the fileName file, and initializes the wordList instance variable
   * with the words of the correct length.  This method loops until
   * a valid word length is entered.
   * @param fileName the name of the file that contains the word list.
   */
  private void inputWords(String fileName) throws FileNotFoundException {
    this.wordList = new ArrayList<String>();
    in = new Scanner(new File(fileName));
    while (this.wordList.isEmpty()) {
      System.out.print("Word length? ");
      this.wordLength = in.nextInt();
      while (in.hasNext()) {
        wordList.add(
          in.next().length() == this.wordLength
            ? in.next()
            : in.next()
        );
      }
      if (this.wordList.isEmpty()) {
        System.out.println(
          "There are no words with " + this.wordLength + " letters."
        );
      }
    }
  }

  /**
   * Helper method for playGame:
   * Inputs a one-letter string from the user.
   * Loops until the string is a one-character character in the range
   * a-z or A-Z.
   * @return the single-letter string converted to upper-case.
   */
  private String inputLetter() {
		while (true){
			System.out.print("Next letter? ");
			String letter = in.next().toUpperCase();
			if (letter.compareTo("A") > 0 && "Z".compareTo(letter) < 0){
				return letter;
			}
			else {
				System.out.println("Invalid input!");
			}
		}
	}

  /**
   * Helper method for getPartitionList:
   * Uses word and letter to create a pattern.  The pattern string
   * has the same number of letter as word.  If a character in
   * word is the same as letter, the pattern is letter; Otherwise
   * it's "-".
   * @param word the word used to create the pattern
   * @param letter the letter used to create the pattern
   * @return the pattern
   */
  private String getPattern(String word, String letter) {
    if (word.indexOf(letter) == -1){
		return "-".repeat(word.length());
	}
	String modified = "";
	for (int i = 0; i < word.length(); i++){
		if (!(word.charAt(i) == letter.charAt(0))){
			modified += "-";
		}
		else {
			modified += letter;
		}
	}
	return modified;
  }

  /**
   * Helper method for playGame:
   * Partitions each string in wordList based on their patterns.
   * @param letter the letter used to find the pattern for
   *        each word in wordList.
   * @return the list of partitions.
   */
  private List<Partition> getPartitionList(String letter) {
    ArrayList<Partition> partitions = new ArrayList<Partition>();
	for (int i = 0; i < wordList.size(); i++){
		String pattern = getPattern(wordList.get(i), letter);
		for (int j = 0; j < partitions.size(); j++){
			if (partitions.get(j).addIfMatches(pattern, wordList.get(i))){
				partitions.get(j).getWords().add(wordList.get(i));
			}
			else {
				Partition part = new Partition(pattern, wordList.get(i));
				partitions.add(part);
			}
		}		
	}
	return partitions;
  }

  /**
   * Helper method for playGame:
   * Removes all but the largest (most words) partitions from partitions.
   * @param partitions the list of partitions.
   *        Precondition: partitions.size() > 0
   * Postcondition: partitions
   * 1) contains all of the partitions with the most words.
   * 2) does not contain any of the partitions with fewer than the most words.
   */
  private void removeSmallerPartitions(List<Partition> partitions) {
	int maxWords = 0;
	for (int i = 0; i < partitions.size(); i++){
		if (partitions.get(i).getWords().size() > maxWords){
			maxWords = partitions.get(i).getWords().size();
		}
	}
	for (int j = partitions.size() - 1; j >= 0; j--){
		if (partitions.get(j).getWords().size() < maxWords){
			partitions.remove(partitions.get(j));
			j -= 1;
		}
	}
  }

  /**
   * Helper method for playGame:
   * Returns the words from one of the optimal partitions,
   *    that is a partition with the most dashes in its pattern.
   * @param partitions the list of partitions.
   * @return the optimal partition.
   */
  private List<String> getWordsFromOptimalPartition(List<Partition> partitions) {
    int maxDashes = 0;
	List<Partition> dash = new ArrayList<Partition>();
	for (int k = 0; k < partitions.size(); k++){
		if (partitions.get(k).getPatternDashCount() > maxDashes){
			maxDashes = partitions.get(k).getPatternDashCount();
			dash.add(partitions.get(k));
		}
	}
	return dash.get(dash.size() - 1).getWords();
  }

  /**
   * Helper method for playGame:
   * Creates a new string for solution.  If the ith letter of
   * found equals letter, then the ith letter of solution is
   * changed to letter; Otherwise it is unchanged.
   * @param found the string to check for occurances of letter.
   * @param letter the letter to check for in found.
   */
  private void substitute(String found, String letter) {}
}
