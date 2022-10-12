public class SieveOfEratosthenes{
    public static void main(String[] args){
        int[] sieve = new int[1001]; // creating an array of 1001 elements
        for (int i = 0; i < sieve.length; i++){
            sieve[i] = i; // filling array up with valeus from 0 to 1000
        }
        for (int i = 2; i < sieve.length; i++){ // looping from 2 till end
            if (sieve[i] != 0){
                for (int j = i * 2; j < sieve.length; j += i){ // replacing factors of that specific number with 0 leaving only primes behind
                    sieve[j] = 0;
                }
            }
        }
        System.out.println("Prime numbers from 1 to 1000 are: ");
        for (int i = 2; i < sieve.length; i++){
            if (sieve[i] != 0){
                System.out.print(sieve[i] + " "); // the ones that have a value of zero are factors of the number
            }
        }
    }
}