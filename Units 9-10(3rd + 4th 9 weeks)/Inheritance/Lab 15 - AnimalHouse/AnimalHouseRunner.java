public class AnimalHouseRunner {
    public static void main(String[] args)
	{
		Toy t1 = new Toy("Ball");
		Toy t2 = new Toy("Ball");
		Toy t3 = new Toy("Bone");
		Toy t4 = new Toy("Busy Bee");
		Toy t5 = new Toy("Bone");
		Toy t6 = new Toy("Ball");
		Toy t7 = new Toy("Mouse");

		System.out.println("Same toy? " + (t1 == t2));
		System.out.println("Equal toys? " + t1.equals(t2) + "\n");

		House house = new House();

		Animal a = new Dog("Sparky", 2005, true);
		Animal b = new Cat("Fluffy", 2008);

		a.addToy(t1); a.addToy(t2); a.addToy(t3); a.addToy(t4); a.addToy(t5); a.addToy(t6);

		b.addToy(t7);

		a.setFriend(b); b.setFriend(a);

		house.add(a);
		house.add(b);
        house.cleanHouse();
		house.printAnimals();
	}
}
