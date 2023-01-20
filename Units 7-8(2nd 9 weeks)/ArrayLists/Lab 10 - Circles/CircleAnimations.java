import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class CircleAnimations {
	private ArrayList<Circle> circles;
	private int size;
	private Random rng;

	public CircleAnimations(int s) {
		circles = new ArrayList<>();
		size = s;
		rng = new Random();

		StdDraw.setCanvasSize(size, size);
		StdDraw.setXscale(0, size);
		StdDraw.setYscale(0, size);
	}

	void drawCircles() {
		for (int i = 0; i < circles.size(); i++) {
			circles.get(i).draw();
		}
	}

	void addCircles() {
		for (int i = 0; i < 3; i++) {
			int x = rng.nextInt(size);
			int y = rng.nextInt(size);
			int radius = rng.nextInt(50);
			Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
			circles.add(new Circle(x, y, radius, color));
			drawCircles();
		}
	}

	void addCircles(int number, int radius) {
		for (int i = 0; i < number; i++) {
			int x = rng.nextInt(size - 2 * radius) + radius;
			int y = rng.nextInt(size - 2 * radius) + radius;
			Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
			circles.add(new Circle(x, y, radius, color));
			drawCircles();
		}
	}

	void noOverlapping(int number) {
		for (int i = 0; i < number; i++) {
			int x = rng.nextInt(size);
			int y = rng.nextInt(size);
			int radius = rng.nextInt(75);
			Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
			Circle circle = new Circle(x, y, radius, color);
			boolean overlaps = false;
			for (int j = 0; j < circles.size(); j++) {
				if (circle.overlaps(circles.get(j))) {
					overlaps = true;
				}
			}
			if (!overlaps) {
				circles.add(circle);
			}
			drawCircles();
		}
	}

	void update() {
		for (int i = 0; i < circles.size(); i++) {
			circles.get(i).x += circles.get(i).dx;
			circles.get(i).y += circles.get(i).dy;
			if (circles.get(i).x + circles.get(i).radius > size) {
				circles.get(i).dx = -circles.get(i).dx;
			}
			if (circles.get(i).x - circles.get(i).radius < 0) {
				circles.get(i).dx = -circles.get(i).dx;
			}
			if (circles.get(i).y + circles.get(i).radius > size) {
				circles.get(i).dy = -circles.get(i).dy;
			}
			if (circles.get(i).y - circles.get(i).radius < 0) {
				circles.get(i).dy = -circles.get(i).dy;
			}
		}

	}

	void movingCircles() {
		noOverlapping(100);
		for (int i = 0; i < circles.size(); i++) {
			circles.get(i).dx = rng.nextInt(5) + 1;
			circles.get(i).dy = rng.nextInt(5) + 1;
		}
		while (true) {
			StdDraw.clear();
			update();
			drawCircles();
			StdDraw.show(10);
		}
	}

	void removeClicked() {
		movingCircles();
		while (true) {
			if (StdDraw.mousePressed()) {
				int x = (int) StdDraw.mouseX();
				int y = (int) StdDraw.mouseY();
				for (int i = 0; i < circles.size(); i++) {
					if (circles.get(i).getX() == x && circles.get(i).getY() == y) {
						circles.remove(i);
						i--;
					}
				}
			}
		}
	}
}
