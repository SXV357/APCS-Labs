class Dog extends Animal {
    private boolean goodBoy;

    public Dog(String name, int birthyear, boolean gb){
        super(name, birthyear);
        this.goodBoy = gb;
    }

    public boolean isGoodBoy(){
        return goodBoy;
    }

    @Override
    public String toString(){
        if (this.isGoodBoy()){
            return super.toString() + "I am a good boy.";
        }
        return null;
    }
}
