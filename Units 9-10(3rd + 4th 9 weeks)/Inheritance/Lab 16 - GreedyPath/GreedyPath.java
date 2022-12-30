import java.util.ArrayList;

public class GreedyPath extends Path {

  private Point[] greedyPoints;
  private ArrayList<Point> path;
  private double totalDistance;

  public GreedyPath(String fileName) {
    super(fileName);
    findPath();
    path = new ArrayList<>();
    greedyPoints = path.toArray(new Point[0]);
  }

  private void findPath() {
    Point start = getPoint(0);
    start.setVisited(true);
    path.add(start);

    while (path.size() < getPoints().length) {
      Point current = path.get(path.size() - 1);
      Point closest = getPoints()[0];
      double minDistance = Double.MAX_VALUE;
      for (Point point : getPoints()) {
        if (!point.getVisited()) {
          double distance = current.getDistance(point);
          if (distance < minDistance) {
            minDistance = distance;
          }
        }
      }
      if (closest != null) {
        closest.setVisited(true);
        path.add(closest);
        totalDistance += minDistance;
      }
    }
    greedyPoints = path.toArray(new Point[0]);
  }

  @Override
  public double getDistance() {
    return totalDistance;
  }

  @Override
  public Point getPoint(int i) {
    return greedyPoints[i];
  }

  @Override
  public String toString() {
    String result = "";
    for (Point point : greedyPoints) {
      result += point.toString() + "\n";
    }
    return result;
  }
}
