import java.util.Random;

public class Rabbit {

  /* Characteristics shared by all rabbits (static fields). */

  private static final int BREEDING_AGE = 5;
  private static final int MAX_AGE = 15;
  private static final double BREEDING_PROBABILITY = 0.22;
  private static final int MAX_LITTER_SIZE = 6;

  /* Individual characteristics (instance fields). */

  private int age;
  private boolean alive;
  private Field field;
  private Location location; //stores a reference to this Rabbit's current location

  /**
   * Create a new rabbit. A rabbit is created with age zero (a new born).
   */
  public Rabbit(Field field, Location location) {
    this.field = field;
    this.location = location;
    this.age = 0;
    this.alive = true;
  }

  public Location getLocation() {
    return this.location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * This is what the rabbit does most of the time - it runs
   * around. Sometimes it will breed or die of old age.
   */
  public void run() {
    incrementAge();
    if (!alive) return;
    int births = breed();
    for (int i = 0; i < births; i++) {
      Location loc = field.freeAdjacentLocation(location);
      if (loc != null) {
        Rabbit young = new Rabbit(field, loc);
        field.place(young, loc);
      }
    }
    Location modified = field.freeAdjacentLocation(location);
    if (modified != null) {
      field.place(this, modified);
      this.location = modified;
      this.field.remove(this.location);
    } else {
      setDead();
    }
  }

  /** Method called when a Rabbit becomes deceased */
  public void setDead() {
    this.alive = false;
    this.field.remove(this.location);
  }

  /**
   * Increase the Rabbit's age.
   * This could result in the rabbit's death.
   */
  private void incrementAge() {
    this.age++;
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
   * A rabbit can breed if it has reached breeding age.
   * @return true if the rabbit can breed, false otherwise.
   */
  private boolean canBreed() {
    return this.age >= BREEDING_AGE;
  }

  @Override
  public String toString() {
    return "Rabbit, " + this.age + " y/o, at " + this.location;
  }
}
