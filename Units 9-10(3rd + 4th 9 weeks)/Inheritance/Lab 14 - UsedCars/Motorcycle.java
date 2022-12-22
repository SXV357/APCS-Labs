class Motorcycle extends Vehicle {
    private String color;

    public Motorcycle(String t, int y, double p, String c){
        super(t,y,p);
        this.color = c;
    }

    boolean isRed(){
        return color.equals("red");
    }

    @Override
    String getInfo(){
        return super.getInfo() + " " + "$" + super.getPrice() + " " + this.color;
    }
}
