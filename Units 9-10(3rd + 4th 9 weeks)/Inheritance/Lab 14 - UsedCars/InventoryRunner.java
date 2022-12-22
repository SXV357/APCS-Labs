public class InventoryRunner {
    public static void main(String[] args){
        Car car1 = new Car("Honda Civic", 2014, 20000.0, 30);
        Car car2 = new Car("Toyota Sienna", 2019, 15000.0, 34);
        Truck truck1 = new Truck("Ford", 2020, 10000.0, 1750);
        Truck truck2 = new Truck("Land Rover", 2011, 35000.0, 2500);
        Motorcycle motorcycle1 = new Motorcycle("Harley Davidson", 2015, 15700, "Black");
        Inventory inventory = new Inventory();
        inventory.addVehicle(car1);
        inventory.addVehicle(car2);
        inventory.addVehicle(truck1);
        inventory.addVehicle(truck2);
        inventory.addVehicle(motorcycle1);
        System.out.println(motorcycle1.isRed());
        System.out.println();
        inventory.listInventory();
    }
}
