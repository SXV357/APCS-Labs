public class Animal {

  private int age;
  private boolean alive;
  private Field field;
  private Location location;

  public Animal(Field field, Location location) {
    this.age = 0;
    this.alive = true;
    this.field = field;
    this.location = location;
  }

  public void setDead() {
    this.alive = false;
    this.field.remove(this.location);
  }

  public void incrementAge() {
    this.age++;
  }

  public int getAge(){return this.age;}
  public boolean getAlive(){return this.alive;}
  public Field getField(){return this.field;}
  public Location getLocation(){return this.location;}

  public void setAge(int age){this.age = age;}
  public void setAlive(boolean alive){this.alive = alive;}
  public void setField(Field field){this.field = field;}
  public void setLocation(Location loc){this.location = loc;}

  public String toString(){
    return "Animal, " + this.age + " y/o, at " + this.location;
  }
}
