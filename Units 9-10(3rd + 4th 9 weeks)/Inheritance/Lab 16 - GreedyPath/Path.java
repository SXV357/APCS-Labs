import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Path {

  private Point[] points;
  private double minX, minY; //min X and Y values, for setting canvas scale
  private double maxX, maxY; //maxes

  /** construct a path from a given file */
  public Path(String fileName) {
    try {
      Scanner scanner = new Scanner(new File(fileName));
      int n = scanner.nextInt();
      points = new Point[n];

      minX = Double.MAX_VALUE;
      minY = Double.MAX_VALUE;
      maxX = Double.MIN_VALUE;
      maxY = Double.MIN_VALUE;

      for (int i = 0; i < n; i++) {
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        points[i] = new Point(x, y);

        minX = Math.min(minX, x);
        minY = Math.min(minY, y);
        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /** returns the distance traveled going point to point, in order given in file */
  public double getDistance() {
    double distance = 0;
    for (int i = 1; i < points.length; i++) {
      distance += points[i - 1].getDistance(points[i]);
    }
    return distance;
  }

  public Point getPoint(int i) {
    return points[i];
  }

  public Point[] getPoints() {
    return points;
  }

  public int getNumPoints() {
    return points.length;
  }

  public double getMinX() {
    return minX;
  }

  public double getMinY() {
    return minY;
  }

  public double getMaxX() {
    return maxX;
  }

  public double getMaxY() {
    return maxY;
  }

  @Override
  public String toString() {
    String result = "";
    for (Point point : points) {
      result += point.toString() + "\n";
    }
    return result;
  }
}
