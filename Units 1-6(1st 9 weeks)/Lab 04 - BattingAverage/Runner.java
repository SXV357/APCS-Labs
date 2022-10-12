import java.util.Scanner;
import java.io.*;

public class Runner {
    public static void main(String[] args) throws IOException{
        File file = new File("C:/Users/14058/OneDrive/Desktop/AP CS Projects/Lab 04 - BattingAverage/players.txt");
        Scanner input = new Scanner(file);
        int p = Integer.parseInt(input.nextLine());
        Team liberty = new Team(p);
        for (int i = 0; i < p; i++) {
            String name = input.next();
            int jersey = input.nextInt();
            int atBats = input.nextInt();
            int hits = input.nextInt();
            Player player = new Player(name, jersey, atBats, hits);
            liberty.addPlayer(player, i);
        }
        input.close();

        liberty.printTeamStats();
    }
}
