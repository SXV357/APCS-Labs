public class FieldTester 
{
	public static void main(String[] args) 
	{
		Field field  = new Field(4, 4);
		
		Location a = new Location(0, 0); //initial rabbit location
		Location b = new Location(2, 2); //initial fox location
		
		Animal rabbit = new Rabbit(field, a); 
		
		Animal fox = new Fox(field, b);
		         
		field.place(rabbit, a); //place rabbit in field at <0, 0>
		field.place(fox, b);    //place fox in field at <2, 2>
		
		System.out.println("Initial field state:");
		System.out.println(field); //should show fox and rabbit at proper locations
		
		System.out.println("Adjacent locations:");
		System.out.println("Rabbit: " + field.adjacentLocations(a)); //should show 3 adj. locations
		System.out.println(field.freeAdjacentLocation(a)); //should be a random choice from options above
		
		System.out.println("\nFox: " + field.adjacentLocations(b)); //should show 8 adj. locations (NOT including the location itself) 
		System.out.println(field.freeAdjacentLocation(b)); //should be a random choice from options above
		
		Location c = new Location(1, 1);
		
		System.out.println("\nManually move rabbit to <1, 1>:");
		field.move(rabbit.getLocation(), c); //manually move the rabbit to a new location
		rabbit.setLocation(c);
		
		System.out.println(field); //rabbit should show in new location, be removed from old
		
		System.out.println("Rabbit runs:");
		((Rabbit) rabbit).act();
		
		System.out.println(field); //rabbit should move to a free adjacent location
		
		System.out.println("Fox hunts:");
		((Fox) fox).act(); 
		
		//fox should eat rabbit if rabbit moved near fox, otherwise move randomly
		//  run multiple times to check
		System.out.println(field); 
	}
}
