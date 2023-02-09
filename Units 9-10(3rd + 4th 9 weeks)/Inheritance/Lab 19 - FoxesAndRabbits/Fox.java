import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fox {

  /* Characteristics shared by all foxes (static fields). */

  private static final int BREEDING_AGE = 10;
  private static final int MAX_AGE = 20;
  private static final double BREEDING_PROBABILITY = 0.17;
  private static final int MAX_LITTER_SIZE = 4;
  private static final int RABBIT_FOOD_VALUE = 8;

  /* Individual characteristics (instance fields). */

  private int age;
  private boolean alive;
  private Field field;
  private Location location;
  private int foodLevel;

  /**
   * Create a fox. A fox is created as a new born (age zero
   * and not hungry).
   */
  public Fox(Field field, Location location) {
    this.field = field;
    this.location = location;
    this.age = 0;
    this.foodLevel = Fox.RABBIT_FOOD_VALUE;
    this.alive = true;
  }

  /**
   * This is what the fox does most of the time: it hunts for rabbits.
   * In the process, it might breed, die of hunger, or die of old age.
   */
  public void hunt() {
    incrementAge();
    incrementHunger();
    if (!alive) return;
    int births = breed();
    for (int i = 0; i < births; i++) {
      Location loc = field.freeAdjacentLocation(location);
      if (loc != null) {
        Fox young = new Fox(field, loc);
        field.place(young, loc);
      }
    }
    Location newLocation = findFood();
    if (newLocation != null) {
      field.place(this, newLocation);
      this.location = newLocation;
      this.field.remove(this.location);
    } else {
      setDead();
    }
  }

  /**
   * Increase the age. This could result in the fox's death.
   */
  private void incrementAge() {
    this.age++;
  }

  /**
   * Make this fox more hungry. This could result in the fox's death.
   */
  private void incrementHunger() {
    this.foodLevel--;
    if (this.foodLevel < 0) {
      this.setDead();
    }
  }

  /** Method called with a Fox is no longer alive */
  public void setDead() {
    this.alive = false;
    this.field.remove(this.location);
  }

  /**
   * Tell the fox to look for rabbits adjacent to its current location.
   * @return Where food was found, or null if it wasn't.
   */
  private Location findFood() {
    List<Location> adjacentLocations = field.adjacentLocations(this.location);

    for (Location where : adjacentLocations) { //look for Rabbits in adjacent locations
      Object animal = field.getObjectAt(where);

      if (animal instanceof Rabbit) { //if this object is a rabbit...
        Rabbit rabbit = (Rabbit) animal;

        rabbit.setDead();

        this.foodLevel = Fox.RABBIT_FOOD_VALUE; //Foxes goes back to full

        return where;
      }
    }
    return null;
  }

  /**
   * Generate a number representing the number of births, if it can breed.
   * @return The number of births (may be zero).
   */
  private int breed() {
    Random rand = new Random();
    int births = 0;
    if (canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) {
      births = rand.nextInt(MAX_LITTER_SIZE) + 1;
    }
    return births;
  }

  /**
   * A fox can breed if it has reached breeding age.
   */
  private boolean canBreed() {
    return this.age >= BREEDING_AGE;
  }
}
