import java.awt.event.KeyEvent;

public class ControllableSprite extends MobileSprite {

  public ControllableSprite(
    double x,
    double y,
    int width,
    int height,
    String image,
    double vx,
    double vy
  ) {
    super(x, y, width, height, image, vx, vy);
  }

  @Override
  public void step(World world) {
    if (
      StdDraw.isKeyPressed(KeyEvent.VK_LEFT) &&
      super.getX() - super.getWidth() / 2 > 0
    ) {
      super.setVX(-1);
    } else if (
      StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) &&
      super.getX() + super.getWidth() / 2 < world.getWidth()
    ) {
      super.setVX(1);
    } else {
      super.setVX(0);
    }
    if (
      StdDraw.isKeyPressed(KeyEvent.VK_UP) &&
      super.getY() + super.getHeight() / 2 < world.getHeight()
    ) {
      setVY(1);
    } else if (
      StdDraw.isKeyPressed(KeyEvent.VK_DOWN) &&
      super.getY() - super.getHeight() / 2 > 0
    ) {
      super.setVY(-1);
    } else {
      super.setVY(0);
    }
    if (
      StdDraw.isKeyPressed(KeyEvent.VK_LEFT) &&
      StdDraw.isKeyPressed(KeyEvent.VK_UP) &&
      super.getX() - super.getWidth() / 2 > 0 &&
      super.getY() + super.getHeight() / 2 < world.getHeight()
    ) {
      super.setVX(-1);
      super.setVY(1);
    } else if (
      StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) &&
      StdDraw.isKeyPressed(KeyEvent.VK_UP) &&
      super.getX() + super.getWidth() / 2 < world.getWidth() &&
      super.getY() + super.getHeight() / 2 < world.getHeight()
    ) {
      super.setVX(1);
      super.setVY(1);
    } else if (
      StdDraw.isKeyPressed(KeyEvent.VK_LEFT) &&
      StdDraw.isKeyPressed(KeyEvent.VK_DOWN) &&
      super.getX() - super.getWidth() / 2 > 0 &&
      super.getY() - super.getHeight() / 2 > 0
    ) {
      super.setVX(-1);
      super.setVY(-1);
    } else if (
      StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) &&
      StdDraw.isKeyPressed(KeyEvent.VK_DOWN) &&
      super.getX() + super.getWidth() / 2 < world.getWidth() &&
      super.getY() - super.getHeight() / 2 > 0
    ) {
      super.setVX(1);
      super.setVY(-1);
    }
    super.step(world);
  }
}
