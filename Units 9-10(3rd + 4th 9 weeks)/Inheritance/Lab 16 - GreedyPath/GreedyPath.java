import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GreedyPath extends Path {

  private Point[] greedyPoints;
  private double totalDistance;

  public GreedyPath(String fileName) throws FileNotFoundException {
    super(fileName);
    this.greedyPoints = new Point[0];
    findPath();
  }

  private void findPath() {
    ArrayList<Point> path = new ArrayList<Point>();
    Point start = super.getPoint(0);
    if (start != null) {
      start.setVisited(true);
      path.add(start);
    }

    while (path.size() < super.getPoints().length) {
      if (path.size() > 0) {
        Point current = path.get(path.size() - 1);
        Point closest = super.getPoint(0);
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < super.getPoints().length; i++) {
          if (!super.getPoints()[i].getVisited()) {
            double distance = current.getDistance(getPoints()[i]);
            if (distance < minDistance) {
              minDistance = distance;
              closest = super.getPoints()[i];
            }
          }
        }
        if (closest != null) {
          closest.setVisited(true);
          path.add(closest);
          this.totalDistance += minDistance;
        }
      }

      if (path.size() > 0) {
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
