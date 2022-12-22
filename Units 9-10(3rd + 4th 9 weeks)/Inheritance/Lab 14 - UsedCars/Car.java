class Car extends Vehicle {
    private double mpg;

    public Car(String t, int y, double p, double e){
        super(t,y,p);
        this.mpg = e;
    }

    boolean greatMPG(){
        return this.mpg >= 36;
    }

    @Override
    String getInfo(){
        return super.getInfo() + " " + "$" + super.getPrice() + " " + this.mpg + " " + "mpg";
    }
}
