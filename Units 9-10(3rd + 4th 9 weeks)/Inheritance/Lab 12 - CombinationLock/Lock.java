public class Lock {

  private boolean locked;

  public Lock(){
    
  }

  void open() {
    this.locked = false;
  }

  void close() {
    this.locked = true;
  }

  boolean isLocked() {
    return locked;
  }

  public String toString() {
    String state = "";
    if (locked) {
      state = "Lock is closed";
    } else {
      state = "Lock is open";
    }
    return state;
  }
}
