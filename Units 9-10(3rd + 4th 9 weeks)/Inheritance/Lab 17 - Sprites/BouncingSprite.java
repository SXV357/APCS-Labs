public class BouncingSprite extends MobileSprite {

    public BouncingSprite(
        double x,
        double y,
        int width,
        int height,
        String image,
        double vx,
        double vy
    ){
        super(x, y, width, height, image, vx, vy);
    }

    public void bounce(World world){
        if (getX() + getWidth() / 2 >= world.getWidth() || getX() - getWidth() / 2 <= 0) {
            setVX(-1*getVX());
        }
        if (getY() + getHeight() / 2 >= world.getHeight() || getY() - getHeight() / 2 <= 0) {
            setVY(-1*getVY());
        }
    }

    @Override
    public void step(World world){
        super.step(world);
        this.bounce(world);
    }

    
}
