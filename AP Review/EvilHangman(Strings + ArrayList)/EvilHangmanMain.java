import java.io.FileNotFoundException;

/**
 * EvilHangmanMain.java  06/04/2015
 *
 * @author - Robert Glen Martin
 * @author - School for the Talented and Gifted
 * @author - Dallas ISD
 */
public class EvilHangmanMain
{
	public static void main(String[] args) throws FileNotFoundException
	{
		EvilHangman evil = new EvilHangman("C:/Users/14058/OneDrive/Desktop/Programming/AP CS Projects/AP Review/EvilHangman(Strings + ArrayList)/test.txt", false);
		//EvilHangman evil = new EvilHangman("C:/Users/14058/OneDrive/Desktop/Programming/AP CS Projects/AP Review/EvilHangman(Strings + ArrayList)/dictionary.txt", false);
		evil.playGame();
	}
}