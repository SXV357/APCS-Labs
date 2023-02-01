import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field
{    
	private int height, width;
	private Object[][] field;

	/**
	 * Represent a field of the given dimensions.
	 * @param height The height of the field.
	 * @param width The width of the field.
	 */
	public Field(int height, int width)
	{
		//TODO
	}

	/** Empty the field */
	public void clear()
	{
		//TODO
	}

	/**
	 * Place an animal at the given location.
	 * If there is already an animal at the location it will
	 * be lost.
	 * @param animal The animal to be placed.
	 * @param row Row coordinate of the location.
	 * @param col Column coordinate of the location.
	 */
	public void place(Object animal, int row, int col)
	{
		//TODO
	}

	/**
	 * Place an animal at the given location.
	 * If there is already an animal at the location it will
	 * be lost.
	 * @param animal The animal to be placed.
	 * @param location Where to place the animal.
	 */
	public void place(Object animal, Location location)
	{
		//TODO
	}
	
	/**
	 * Move an Object from one location in the field to another
	 * @param oldLocation Object's old location
	 * @param newLocation Object's new location
	 */
	public void move(Location oldLocation, Location newLocation)
	{
		//TODO
	}
	
	/**
	 * Remove an Object from a particular location
	 * @param location
	 */
	public void remove(Location location)
	{
		//TODO
	}
	
	/**
	 * Return the animal at the given location, if any.
	 * @param location Where in the field.
	 * @return The animal at the given location, or null if there is none.
	 */
	public Object getObjectAt(Location location)
	{
		//TODO
		
		return null;
	}

	/**
	 * Return the animal at the given location, if any.
	 * @param row The desired row.
	 * @param col The desired column.
	 * @return The animal at the given location, or null if there is none.
	 */
	public Object getObjectAt(int row, int col)
	{
		//TODO
		
		return null;
	}

	/**
	 * Generate a shuffled List of locations adjacent to the given one - will 
	 * not include the location itself. All locations will lie within the grid.
	 * @param location The location from which to generate adjacencies.
	 * @return A randomized list of locations adjacent to that given.
	 */
	public List<Location> adjacentLocations(Location location)
	{
		//TODO
		
		return null;
	}

	/**
	 * Try to find a free location that is adjacent to the given location. 
	 * If there is none, return null. The returned location will be within 
	 * the valid bounds of the field.
	 * @param location The location from which to generate an adjacency.
	 * @return A valid free location within the grid area, or null if all
	 *         locations around are full.
	 */
	public Location freeAdjacentLocation(Location location)
	{
		//USED BY FOXES AND RABBITS TO MOVE RANDOMLY
		
		/*
		 * TODO
		 */
		
		return null;
			
	}

	@Override
	public String toString() //quick picture of the state of the field, for debugging
	{
		String result = "";
		
		for (int r = 0; r < this.height; r++)
		{
			for (int c = 0; c < this.width; c++)
			{
				Object obj = this.field[r][c];
				
				if (obj instanceof Rabbit)
					result += "R\t";
				else if (obj instanceof Fox)
					result += "F\t";
				else
					result += "x\t";
			}
			result += "\n";
		}
		
		return result;
	}
	
	public int getHeight() { return this.height; }
	
	public int getWidth() { return this.width; }
}
