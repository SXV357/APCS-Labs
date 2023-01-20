public class MobileSprite extends Sprite {

  private double vx;
  private double vy;

  public MobileSprite(
    double x,
    double y,
    int width,
    int height,
    String image,
    double vx,
    double vy
  ) {
    super(x, y, width, height, image);
    this.vx = vx;
    this.vy = vy;
  }

  public double getVX() {
    return this.vx;
  }

  public double getVY() {
    return this.vy;
  }

  public void setVX(double vx) {
    this.vx = vx;
  }

  public void setVY(double vy) {
    this.vy = vy;
  }

    @Override
    public void step(World world) {
        this.setX(this.getX() + this.getVX());
        this.setY(this.getY() + this.getVY());
    }
}
