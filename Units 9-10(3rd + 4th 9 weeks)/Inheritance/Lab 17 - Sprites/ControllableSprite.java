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
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && getX() - getWidth() / 2 > 0) {
            setVX(-1);
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && getX() + getWidth() / 2 < world.getWidth()) {
            setVX(1);
        } else {
            setVX(0);
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && getY() + getHeight() / 2 < world.getHeight()) {
            setVY(1);
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && getY() - getHeight() / 2 > 0) {
            setVY(-1);
        } else {
            setVY(0);
        }
        super.step(world);
    }

}
