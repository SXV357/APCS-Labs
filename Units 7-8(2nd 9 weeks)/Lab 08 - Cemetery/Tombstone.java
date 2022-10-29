class Tombstone {
    private String name;
    private String burialDate;
    private int age;
    private String address;

    public Tombstone(String name, String burialDate, int age, String address) {
        this.name = name;
        this.burialDate = burialDate;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getBurialDate() {
        return burialDate;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}   
