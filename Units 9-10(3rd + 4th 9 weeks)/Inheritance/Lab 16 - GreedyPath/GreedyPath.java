import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GreedyPath extends Path {

  private Point[] greedyPoints;
  private double totalDistance;

  public GreedyPath(String fileName) throws FileNotFoundException {
    super(fileName);
    this.greedyPoints = new Point[0]; // initializing local array so it doesn't throw a null exception
    findPath();
  }

  private void findPath() {
    ArrayList<Point> path = new ArrayList<Point>();
    Point start = super.getPoint(0);
    // always starting from very first point in the array before moving on to other ones
    if (start != null) {
      start.setVisited(true);
      path.add(start);
    }

    while (path.size() < super.getPoints().length) { // checking every single point in the points array contained in Point class
      if (path.size() > 0) { // ensure there's at least one point in the arraylist to start cgecking
        Point current = path.get(path.size() - 1);
        Point closest = super.getPoint(0); // assuming that the very first one is the closest to start off with
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < super.getPoints().length; i++) {
          if (!super.getPoints()[i].getVisited()) {
            double distance = current.getDistance(super.getPoints()[i]); // checking if a point is not visited and then getting the distance between the current point being traversed and that specific point
            if (distance < minDistance) {
              minDistance = distance; // logic for updating min distance as necessary
              closest = super.getPoints()[i];
            }
          }
        }
        // core logic to update the greedy points array and the total distance covered
        if (closest != null) {
          closest.setVisited(true);
          path.add(closest);
          this.totalDistance += minDistance;
        }
      }

      if (path.size() > 0) {
        // making the contents of Path more accessible as long as it contains Point objects that are not that far from the current point being traversed in the original array
        this.greedyPoints = path.toArray(new Point[0]);
      }
    }
  }

  @Override
  public double getDistance() {
    return this.totalDistance;
  }

  @Override
  public Point getPoint(int i) {
    if (this.greedyPoints.length > 0) {
      return this.greedyPoints[i];
    } else {
      return null;
    }
  }

  @Override
  public String toString() {
    String result = "";
    for (Point point : this.greedyPoints) {
      result += point.toString() + "\n";
    }
    return result;
  }
}
