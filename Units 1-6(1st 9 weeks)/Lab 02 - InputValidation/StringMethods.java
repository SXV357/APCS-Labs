import java.util.*;

class StringMethods {
    
    public StringMethods(){

    }

    public void unusualHello(String name){
        System.out.println("Hello " + name + ", " + "you dummy!");
    }

    public String stringRipper(String str){
        String combined = "";
        String firstLetter = str.substring(0,1); // first letter
        String lastLetter = str.substring(str.length()-1); // last letter
        combined = firstLetter + lastLetter;
        return combined;
    }

    public boolean evenFooBar(String s){
        int countFoo = 0;
        int countBar = 0;
        Boolean same = false;
        countFoo += s.length() - s.replace("foo", "").length();
        // since both strings are 3 characters long, subtracting 
        // the length of the string after removing the target word 
        // from the initial length will give how many times the specific word appears
        countBar += s.length() - s.replace("bar", "").length();

        if (countFoo == countBar){
            same = true;
        }
        else{
            same = false;
        }
        return same;
    }

    public int sumString(String str){
        int sum = 0;
        String[] split = str.split(" "); // create array so it can be looped over
        for(int i = 0; i < split.length; i++){
            if(split[i].matches("[0-9]+")){ // if char is a number(check using regex)
                sum += Integer.parseInt(split[i]); // add to sum
            }
        }
        return sum;
    }

    public String decode(String key, String code){
        String decoded = " ";
        Scanner input = new Scanner(code);
        while(input.hasNext()){ // while there are characters in the code string
            int num = input.nextInt(); // grab the integers in the code string
            decoded += key.charAt(num); // add characters at those corresponding indices to decoded string
        }
        input.close();
        return decoded;
    }
}
