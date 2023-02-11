import java.util.Random;

public class Rabbit extends Animal implements Actor {

  /* Characteristics shared by all rabbits (static fields). */

  private static final int BREEDING_AGE = 5;
  // private static final int MAX_AGE = 15;
  private static final double BREEDING_PROBABILITY = 0.22;
  private static final int MAX_LITTER_SIZE = 6;

  /* Individual characteristics (instance fields). */

  /**
   * Create a new rabbit. A rabbit is created with age zero (a new born).
   */
  public Rabbit(Field field, Location location) {
    super(field, location); 
  }

  // public Location getLocation() {
  //   return this.location;
  // }

  // public void setLocation(Location location) {
  //   this.location = location;
  // }

  @Override
  public void act() {
    super.incrementAge();
    if (!isActive()) {super.setDead();};
    int births = breed();
    for (int i = 0; i < births; i++) {
      Location loc = super.getField().freeAdjacentLocation(super.getLocation());
      if (loc != null) {
        Rabbit rabbit = new Rabbit(super.getField(), loc);
        super.getField().place(rabbit, loc);
      }
    }
    Location free = super.getField().freeAdjacentLocation(super.getLocation());
    if (free != null) {
      Location curr = super.getLocation();
      super.getField().place(this, free);
      curr = free;
      remove();
    } else {
      super.setDead();
    }
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

  @Override
  public void remove(){
    super.getField().remove(super.getLocation());
  }

  @Override
  public boolean isActive(){
    return super.getAlive();
  }

  /**
   * A rabbit can breed if it has reached breeding age.
   * @return true if the rabbit can breed, false otherwise.
   */
  private boolean canBreed() {
    return super.getAge() >= BREEDING_AGE;
  }

  @Override
  public String toString() {
    return "Rabbit, " + super.getAge() + " y/o, at " + super.getLocation();
  }
}
