import java.util.*;

class MyRectangle{
    private int length;
    private int width;
    
    // constructors
    public MyRectangle(){
        Random rand = new Random();
        length = rand.nextInt(10) + 1;
        width = rand.nextInt(10) + 1;
    }

    public MyRectangle(int l, int w){
        length = l;
        width = w;
    }

    // setter methods
    public void setLength(int l){
        length = l;
    }

    public void setWidth(int w){
        width = w;
    }

    // getter methods
    public int getLength(){
        return length;
    }

    public int getWidth(){
        return width;
    }

    public int getArea(){
        return length * width;
    }

    public int getPerimeter(){
        return 2 * (length + width);
    }

    public String toString(){
        return "L: " + length + " " + "W: " + width;
    }
}