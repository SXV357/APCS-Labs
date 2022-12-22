public class Vehicle {
    private String type;
    private int year;
    private double price;

    public Vehicle(String t, int y, double p){
        this.type = t;
        this.year = y;
        this.price = p;
    }

    String getType(){return this.type;}
    int getYear(){return this.year;}
    double getPrice(){return this.price;}
    String getInfo(){
        return this.type + " " + this.year;
    }
}
