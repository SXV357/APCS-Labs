class Toy {
    private String name;

    public Toy(String n){
        name = n;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Toy){
            Toy t = (Toy) o;
            return this.name.equals(t.name);
        }
        return false;
    }

}
