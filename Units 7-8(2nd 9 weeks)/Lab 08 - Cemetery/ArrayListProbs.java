import java.util.*;

class ArrayListProbs {
    public ArrayListProbs(){

    }

    public void makeListAndPrint(int num, int limit){
        ArrayList<Integer> list  = new ArrayList<Integer>();
        for (int i = 0; i < num; i++){
            list.add((int) ((Math.random() * (limit - 1)) + 1));
        }
        System.out.println(list);
    }

    public ArrayList<Integer> minToFront(ArrayList<Integer> list){
        int min = list.get(0);
        int minIndex = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) < min){
                min = list.get(i);
                minIndex = i;
            }
        }
        list.remove(minIndex);
        list.add(0, min);
        return list;
    }

    public ArrayList<Integer> addOne(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++){
            list.set(i, list.get(i) + 1);
        }
        return list;
    }

    public ArrayList<String> removeDupes(ArrayList<String> list){
        for (int i = 0; i < list.size() - 1; i++){
            if (list.get(i).equals(list.get(i + 1))){
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public ArrayList<Integer> swapPairs(ArrayList<Integer> list){
        for (int i = 0; i < list.size() - 1; i += 2){
            int temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
        return list;
    }

    public ArrayList<String> removeLenN(ArrayList<String> list, int n){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).length() == n){
                list.remove(i);
                i--;
            }
        }
        return list;
    }

    public int dumbestPerson(ArrayList<Person> list){
        int dumbest = list.get(0).getIQ();
        int dumbestIndex = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getIQ() < dumbest){
                dumbest = list.get(i).getIQ();
                dumbestIndex = i;
            }
        }
        return dumbestIndex;
    }

    public Book highestPricedBook(ArrayList<Book> list){
        double highestPrice = list.get(0).getPrice();
        int highestPriceIndex = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getPrice() > highestPrice){
                highestPrice = list.get(i).getPrice();
                highestPriceIndex = i;
            }
        }
        return list.get(highestPriceIndex);
    }

    public ArrayList<Book> banBook(ArrayList<Book> list, Book book){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getTitle().equals(book.getTitle())){
                list.remove(i);
                i--;
            }
        }
        return list;
    }
}
