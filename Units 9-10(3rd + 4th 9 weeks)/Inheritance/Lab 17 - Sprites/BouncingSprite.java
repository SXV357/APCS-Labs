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

    private void bounce(World world){
        if(this.getX() + this.getWidth() >= world.getWidth()){
            this.setVX(-this.getVX());
        }
        if(this.getX() <= 0){
            this.setVX(-this.getVX());
        }
        if(this.getY() + this.getHeight() >= world.getHeight()){
            this.setVY(-this.getVY());
        }
        if(this.getY() <= 0){
            this.setVY(-this.getVY());
        }
    }

    @Override
    public void step(World world){
        super.step(world);
        this.bounce(world);
    }

    
}
