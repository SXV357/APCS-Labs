public interface Actor {
  void act(); //do whatever the Actor 
  boolean isActive(); //determine if this Actor is still active in the simulation
  void remove(); //remove the Actor from the field / simulation
}
