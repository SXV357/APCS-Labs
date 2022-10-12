class Player {
    private String name;
    private int number;
    private int atBats;
    private int hits;

    public Player(String pName, int pNum){
        name = pName;
        number = pNum;
        atBats = 0;
        hits = 0;
    }

    public Player(String pName, int pNum, int atB, int pHit){
        name = pName;
        number = pNum;
        atBats = atB;
        hits = pHit;
    }

    public double getBattingAverage(){
        return (double)hits / atBats;
    }

    public String getBattingAverageString(){
        String avg = String.valueOf(getBattingAverage());
        return avg.substring(2, 5);
    }

    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
}
