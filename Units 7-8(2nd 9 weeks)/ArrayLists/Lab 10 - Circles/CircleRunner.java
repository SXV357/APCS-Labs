import java.awt.*;

public class CircleRunner {
	public static void main(String[] args) {
		CircleAnimations app = new CircleAnimations(600);
		app.removeClicked();

	}

	public static void testCircleOverlap() {
		Circle a = new Circle(1, 1, 1, null);
		Circle b = new Circle(3, 3, 1, null);
		Circle c = new Circle(3, 3, 5, null);

		System.out.println(a.overlaps(b));
		System.out.println(a.overlaps(c));
	}
}
