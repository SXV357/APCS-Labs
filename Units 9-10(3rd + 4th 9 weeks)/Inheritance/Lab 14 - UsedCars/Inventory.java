import java.util.ArrayList;

class Inventory {
    private ArrayList<Vehicle> Inventory;

    public Inventory(){
        this.Inventory = new ArrayList<Vehicle>();
    }

    void addVehicle(Vehicle v){
        Inventory.add(v);
    }

    void listInventory(){
        for (int i = 0; i < Inventory.size(); i++){
            System.out.println(Inventory.get(i).getInfo());
        }
    }
}
