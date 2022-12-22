public class Appointment extends Date {
    String text;

    public Appointment(){

    }

    public Appointment(int m, int d, int y, String txt){
        super(m,d,y);
        this.text = txt;
    }

    String getText(){
        return text;
    }

    @Override
    public String toString(){
        return super.toString() + " " + getText();
    }
}
