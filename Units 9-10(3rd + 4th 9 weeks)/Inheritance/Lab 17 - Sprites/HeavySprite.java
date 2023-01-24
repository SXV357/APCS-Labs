public class HeavySprite extends BouncingSprite {

  public HeavySprite(
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
  public void step(World world){
    super.step(world);
    setVY(getVY() + 0.1);
  }
}
