import java.util.ArrayList;

class Animal {
    private String name;
    private int birthyear;
    private Animal friend;
    private ArrayList<Toy> toys;

    public Animal(String n, int b){
        name = n;
        birthyear = b;
        friend = null;
    }

    public void setFriend(Animal a){
        friend = a;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Toy> getToys(){
        return toys;
    }

    public void addToy(Toy t){
        toys.add(t);
    }

    public int getAge(){
        int currentYear = 2022;
        return currentYear - birthyear;
    }

    public String toString(){
        String info = "Hello, I am " + name + "." + "I am " + getAge() + " years old. ";
        if (friend != null){
            info += "I have a friend named " + this.friend.getName();
        }
        else {
            info += "I have no friends. I have the following toys: " + toys.toString();
        }  
        return info;      
    }


}