public class Point {

  private double x, y;
  private boolean visited;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
    this.visited = false;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  /** get the Euclidean distance between two points */
  public double getDistance(Point other) {
    return Math.sqrt(
      (Math.pow(other.getX() - this.getX(), 2)) +
      Math.pow(other.getY() - this.getY(), 2)
    );
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public boolean getVisited() {
    return visited;
  }

  @Override
  public String toString() {
    return (
      "X-coordinate: " +
      this.x +
      ", Y-coordinate: " +
      this.y +
      ", Visited: " +
      this.visited
    );
  }
}
