import java.util.Scanner;
public class Factors {
    public static void main(String[] args){
        // factor();
        // primeFactorization();
}
    public static void factor(){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Enter a number: ");
            int n = input.nextInt();
            if (n == 0){
                break;
            }
            int num_factors = 0;
            for (int i = 2; i <= n / 2; i++){
                if (n % i == 0){
                    num_factors++;
                }
            }
            System.out.println("The number of factors of " + n + " is " + num_factors);
            System.out.println("They are: ");
            for (int i = 2; i <= n / 2; i++){
                if (n % i == 0){
                    System.out.print(i + " ");
                }
            }
    }
    input.close();
    }

    public static boolean isPrime(int n){
        for (int i = 2; i <= n / 2; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void primeFactorization(){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Enter a number: ");
            int n1 = input.nextInt();
            if (n1 == 0){
                break;
            }
            int numPrimeFactors = 0;
            for (int i = 2; i <= n1 / 2; i++){
                if (n1 % i == 0){
                    if (isPrime(i)){
                        numPrimeFactors++;
                    }
                }
            }

            System.out.println("The number of prime factors of " + n1 + " is " + numPrimeFactors);
            System.out.println("They are: ");
            for (int i = 2; i <= n1 / 2; i++){
                if (n1 % i == 0){
                    if (isPrime(i)){
                        System.out.print(i + " ");
                    }
                }
            }
        }
        input.close();
    }
    }

