class Truck extends Vehicle {
    private int towing;

    public Truck(String t, int y, double p, int tow){
        super(t,y,p);
        this.towing = tow;
    }

    boolean canTwoBoat(){
        return this.towing >= 2000;
    }

    @Override
    String getInfo(){
        return super.getInfo() + " " + "$" + super.getPrice() + " " + this.towing + ".00" + " " + "towing";
    }
}
