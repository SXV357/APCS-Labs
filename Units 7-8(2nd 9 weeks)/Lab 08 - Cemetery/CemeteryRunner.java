import java.io.IOException;

public class CemeteryRunner {
    public static void main(String[] args) throws IOException {
        Cemetery stone = new Cemetery(
                "C:/Users/14058/OneDrive/Desktop/Programming/AP CS Projects/Units 7-8(2nd 9 weeks)/Lab 08 - Cemetery/cemetery.txt");
        int totalAge = 0;
        for (int i = 0; i < stone.graves.size(); i++) {
            totalAge += stone.parseAge(String.valueOf(stone.graves.get(i).getAge()));
        }
        System.out.println("The average age of the deceased is " + totalAge / stone.graves.size() + " days.");
    }

}
