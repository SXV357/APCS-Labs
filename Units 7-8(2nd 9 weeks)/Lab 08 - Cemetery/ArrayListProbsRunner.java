import java.util.*;

public class ArrayListProbsRunner {
    public static void main (String[] args){
        ArrayListProbs tester = new ArrayListProbs();
        tester.makeListAndPrint(10, 50);
        System.out.println(tester.minToFront(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))));
        System.out.println(tester.addOne(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))));
        System.out.println(tester.removeDupes(new ArrayList<String>(Arrays.asList("a", "a", "b", "b", "c", "c", "d", "d", "e", "e"))));
        System.out.println(tester.swapPairs(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))));
        System.out.println(tester.removeLenN(new ArrayList<String>(Arrays.asList("a", "bb", "ccc", "dddd", "eeeee", "ffffff", "ggggggg", "hhhhhhhh", "iiiiiiiii", "jjjjjjjjjj")), 3));
        
        Person p1 = new Person("Bob", 100);
        Person p2 = new Person("Sally", 120);
        Person p3 = new Person("Joe", 90);
        Person p4 = new Person("Sue", 110);
        Person p5 = new Person("Bill", 80);

        System.out.println(tester.dumbestPerson(new ArrayList<Person>(Arrays.asList(p1, p2, p3, p4, p5))));

        Book b1 = new Book("Harry Potter", "JK Rowling", 10.00);
        Book b2 = new Book("Lord of the Rings", "Tolkien", 15.00);
        Book b3 = new Book("The Hobbit", "Tolkien", 5.00);
        Book b4 = new Book("The Hunger Games", "Suzanne Collins", 8.00);
        Book b5 = new Book("The Giver", "Lois Lowry", 12.00);

        System.out.println(tester.highestPricedBook(new ArrayList<Book>(Arrays.asList(b1, b2, b3, b4, b5))));

        System.out.println(tester.banBook(new ArrayList<Book>(Arrays.asList(b1, b2, b3, b4, b5)), b3));
    }
}
