import java.util.*;

class Bookstore {
    private ArrayList<Book> inventory;

    public Bookstore() {
        inventory = new ArrayList<Book>();
    }

    public void addBook(Book b) {
        inventory.add(b);
    }

    public int numBooks() {
        return inventory.size();
    }

    public ArrayList<Book> getBooks() {
        return inventory;
    }

    public Book getBook(int index) {
        if (index < 0 || index >= inventory.size()) {
            return null;
        }
        return inventory.get(index);
    }
}
