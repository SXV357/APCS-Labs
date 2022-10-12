public class Runner {
    public static void main(String[] args){
        MyRectangle one = new MyRectangle(3,4);
        MyRectangle two = new MyRectangle(2,2);
        MyRectangle three = new MyRectangle(1,6);
        System.out.println(one);
        System.out.println(one.getWidth());
        System.out.println(two.getArea());
        System.out.println(three.getPerimeter());

        MyRectangle[] rects; // declare array of MyRectangle class
        rects = new MyRectangle[10]; // create space for 10 MyRectangle objects
        for (int i = 0; i < rects.length; i++){
            rects[i] = new MyRectangle(); // invoke default constructor for each index in the array
        }
        int areaTotal = 0;
        for (int i = 0; i < rects.length; i++){
            areaTotal += rects[i].getArea(); // call getArea method on each instance of MyRectangle class
            System.out.println("The area of rectangle " + i + " is " + rects[i].getArea());
        }
        System.out.println("The total area of all rectangles is: " + areaTotal);
    }
}
