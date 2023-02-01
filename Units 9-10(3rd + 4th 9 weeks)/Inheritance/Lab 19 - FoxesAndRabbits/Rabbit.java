import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rabbit
{
	/* Characteristics shared by all rabbits (static fields). */

	private static final int    BREEDING_AGE = 5;
	private static final int    MAX_AGE = 15;
	private static final double BREEDING_PROBABILITY = 0.22;
	private static final int    MAX_LITTER_SIZE = 6;

	/* Individual characteristics (instance fields). */

	private int      age;
	private boolean  alive;
	private Field    field;
	private Location location; //stores a reference to this Rabbit's current location

	/**
	 * Create a new rabbit. A rabbit is created with age zero (a new born).
	 */
	public Rabbit(Field field, Location location)
	{
		//TODO
	}

	/**
	 * This is what the rabbit does most of the time - it runs 
	 * around. Sometimes it will breed or die of old age.
	 */
	public void run()
	{
		//TODO
	}

	/** Method called when a Rabbit becomes deceased */
	public void setDead()
	{
		//TODO
	}

	/**
	 * Increase the Rabbit's age.
	 * This could result in the rabbit's death.
	 */
	private void incrementAge()
	{
		//TODO
	}

	/**
	 * Generate a number representing the number of births, if it can breed.
	 * @return The number of births (may be zero).
	 */
	private int breed()
	{
		//TODO
		
		return -1; //replace
	}

	/**
	 * A rabbit can breed if it has reached breeding age.
	 * @return true if the rabbit can breed, false otherwise.
	 */
	private boolean canBreed()
	{
		//TODO
		
		return false; //replace
	}
}
