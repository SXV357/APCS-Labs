class Cat extends Animal {
    private int numLives;

    public Cat(String name, int birthyear, int numLives){
        super(name, birthyear);
        this.numLives = numLives;
    }

    public Cat(String name, int birthyear){
        this(name, birthyear, 9);
    }

    @Override
    public String toString(){
        return super.toString() + "I have " + this.numLives + "lives";
    }
}
