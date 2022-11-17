class Word {
    private String word;
    private int count;

    public Word(String w){
        word = w;
    }

    public String getWord(){
        return word;
    }

    public int getCount(){
        return count;
    }

    public void increment(){
        count++;
    }

    public String toString() {
        return word + "\t\t" + count;
 }
}