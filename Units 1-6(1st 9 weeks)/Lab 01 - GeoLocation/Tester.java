import java.util.*;

public class Tester{
    public static void main(String[] args){
        //3
         System.out.println("Hello again, World!");
         //4
        // this is a comment!

        //5
        int numApples = 5;
        //6
        final int PRICE_OF_APPLES = 117;
        //7
        System.out.println("The total for " + numApples + " apples is " + (numApples * PRICE_OF_APPLES) + " cents.");
        
        //8
        if (numApples * PRICE_OF_APPLES >= 2000){
            System.out.println("Thank you valued customer!");
        }

        //9
        for (int i = 10; i > 0; i--){
            System.out.println(i);
        }

        //10
        for (int i = 150; i <= 300; i++){
            if (i % 3 == 0){
                System.out.println(i);
            }
        }

        //11
        int sum = 0;
        for (int i = 1; i <= 100; i++){
            sum += i;
        }
        System.out.println(sum);

        //13
        Scanner console = new Scanner(System.in);

        //14
        System.out.println("Enter a number: ");
        double num = console.nextInt();

        //15
        System.out.println(Math.sqrt(num));

        //16
        System.out.println(Math.pow(num, 3));

        //17
        System.out.println("Enter number 1: ");
        int num1 = console.nextInt();
        System.out.println("Enter number 2: ");
        int num2 = console.nextInt();

        if (num2 - num1 < 10 || Math.abs(num2 - num1) < 10){
            System.out.println("Within 10");
        }
        else{
            System.out.println("Not within 10");
        }

        //18
        int new_sum = 0;
        while (true){
            System.out.println("Enter a number: ");
            int number = console.nextInt();
            if (number == 0){
                break;
            }
            new_sum += number;
        }
        System.out.println("The total sum is " + new_sum);
        console.close();

        //19
        double[] areas = new double[20];
        //20
        areas[0] = 4.56;

        //21
        int length = areas.length;
        System.out.println(length);

        //22
        boolean[] bool = {true, true, false, false, true};
        for (boolean i: bool){
            System.out.print(i + "");
        }

        //29
        simpleMethod();
        System.out.println(sum(4,5));
        System.out.println(sumToN(14));
        triangle(7);
        System.out.println(altCaps("Hello World"));

        //31
        Player player1 = new Player();
        Player player2 = new Player("John", 38);
        System.out.println(player1.PlayerInfo());
        System.out.println(player2.PlayerInfo());
    }

    //24
    public static void simpleMethod(){
        System.out.println("This is a method!");
    }

    //25
    public static int sum(int a, int b){
        return a + b;
    }

    //26
    public static int sumToN(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++){
            if (i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }
        return sum;
    }

    //27
    public static void triangle(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    //28
    public static String altCaps(String s){
        String new_string = "";
        for (int i = 0; i < s.length(); i++){
            if (i % 2 == 0){
                new_string += s.charAt(i);
            }
            else{
                new_string += Character.toUpperCase(s.charAt(i));
            }
        }
        return new_string;
    }

}

class Player{
    private String name;
    private int number;

    public Player(){
        name = "Default";
        number = -1;
    }

    public Player(String n1, int n2){
        name = n1;
        number = n2;
    }

    public String PlayerInfo(){
        return "Player: " + name + "#" + number;
    }
}