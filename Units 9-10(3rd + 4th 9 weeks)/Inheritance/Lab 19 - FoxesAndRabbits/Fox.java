import java.util.List;
import java.util.Random;

public class Fox extends Animal implements Actor {

  /* Characteristics shared by all foxes (static fields). */

  private static final int BREEDING_AGE = 10;
  private static final double BREEDING_PROBABILITY = 0.17;
  private static final int MAX_LITTER_SIZE = 4;
  private static final int RABBIT_FOOD_VALUE = 8;

  /* Individual characteristics (instance fields). */
  private int foodLevel;

  /**
   * Create a fox. A fox is created as a new born (age zero
   * and not hungry).
   */
  public Fox(Field field, Location location) {
    super(field, location);
    this.foodLevel = Fox.RABBIT_FOOD_VALUE;
  }

  @Override
  public void act() {
    incrementAge();
    incrementHunger();
    if (!isActive()) {
      super.setDead();
    };
    int births = breed();
    for (int i = 0; i < births; i++) {
      Location loc = super.getField().freeAdjacentLocation(super.getLocation());
      if (loc != null) {
        Fox fox = new Fox(super.getField(), loc);
        super.getField().place(fox, loc);
      }
    }
    Location newLocation = findFood();
    if (newLocation != null) {
      super.getField().place(this, newLocation);
      super.setLocation(newLocation);
      remove();
    } else {
      super.setDead();
    }
  }

  /**
   * Make this fox more hungry. This could result in the fox's death.
   */
  private void incrementHunger() {
    this.foodLevel--;
    if (this.foodLevel <= 0) {
      super.setDead();
    }
  }

  @Override
  public void remove(){
    super.getField().remove(super.getLocation());
  }

  @Override
  public boolean isActive(){
    return super.getAlive();
  }

  /**
   * Tell the fox to look for rabbits adjacent to its current location.
   * @return Where food was found, or null if it wasn't.
   */
  private Location findFood() {
    List<Location> adjacentLocations = super.getField().adjacentLocations(super.getLocation());

    for (Location where : adjacentLocations) { //look for Rabbits in adjacent locations
      Object animal = super.getField().getObjectAt(where);

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
    return super.getAge() >= BREEDING_AGE;
  }

  @Override
  public String toString() {
    return "Fox, " + super.getAge() + " y/o, at " + super.getLocation();
  }
}
