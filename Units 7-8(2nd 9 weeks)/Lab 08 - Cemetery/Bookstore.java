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

    public Book getBook(int index) {
        if (index < 0 || index >= inventory.size()) {
            return null;
        }
        return inventory.get(index);
    }

    public double bookstoreValue(Bookstore store) {
        double total = 0;
        for (int i = 0; i < store.numBooks(); i++) {
            total += store.getBook(i).getPrice();
        }
        return total;
    }
}
