public class BouncingSprite extends MobileSprite {

  public BouncingSprite(
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

  public void bounce(World world) {
    if (super.getX() + super.getWidth() / 2 >= world.getWidth()) {
      super.setX(world.getWidth() - super.getWidth() / 2);
      super.setVX(-1 * super.getVX());
    } else if (super.getX() - super.getWidth() / 2 <= 0) {
      super.setX(super.getWidth() / 2);
      super.setVX(-1 * super.getVX());
    }
    if (super.getY() + super.getHeight() / 2 >= world.getHeight()) {
      super.setY(world.getHeight() - super.getHeight() / 2);
      super.setVY(-1 * super.getVY());
    } else if (super.getY() - super.getHeight() / 2 <= 0) {
      super.setY(super.getHeight() / 2);
      super.setVY(-1 * super.getVY());
    }
  }

  @Override
  public void step(World world) {
    super.step(world);
    this.bounce(world);
  }
}
