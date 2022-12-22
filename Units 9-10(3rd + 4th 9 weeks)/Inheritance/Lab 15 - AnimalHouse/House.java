import java.util.ArrayList;

class House {
    private ArrayList<Animal> animals;

    void add(Animal a){
        animals.add(a);
    }

    void printAnimals(){
        for (Animal a: animals){
            a.toString();
        }
    }

    void cleanHouse(){
        for (Animal a: animals){
            ArrayList<Toy> toys = a.getToys();
            for (int i = 0; i < toys.size(); i++){
                if (toys.indexOf(toys.get(i)) != toys.lastIndexOf(toys.get(i))){
                    toys.remove(i);
                }
            }
        }
    }
}
