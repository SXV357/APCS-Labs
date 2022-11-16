import java.awt.Color;

class Circle {
    int x;
    int y;
    int dx;
    int dy;
    int radius;
    Color color;

    public Circle(int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public Circle(int x, int y, int dx, int dy, int radius, Color color){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.color = color;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setDx(int dx){
        this.dx = dx;
    }

    public void setDy(int dy){
        this.dy = dy;
    }

    void draw(){
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, radius);
    }

    boolean overlaps(Circle other){
        double distance = Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
        return distance < (this.radius + other.radius);
    }
    
}
