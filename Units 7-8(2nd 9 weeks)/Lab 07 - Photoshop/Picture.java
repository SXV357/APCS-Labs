import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 * A class that represents a picture made up of a rectangle of {@link Pixel}s
 */
public class Picture {

    /** The 2D array of pixels that comprise this picture */
    private Pixel[][] pixels;

    /**
     * Creates a Picture from an image file in the "images" directory
     * 
     * @param picture The name of the file to load
     */
    public Picture(String picture) {
        File file = new File(
                "C:/Users/14058/OneDrive/Desktop/Programming/AP CS Projects/Units 7-8(2nd 9 weeks)/Lab 07 - Photoshop/images/"
                        + picture);
        BufferedImage image;
        if (!file.exists())
            throw new RuntimeException("No picture at the location " + file.getPath() + "!");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        pixels = new Pixel[image.getHeight()][image.getWidth()];
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                int rgb = image.getRGB(x, y);
                /*
                 * For the curious - BufferedImage saves an image's RGB info into a hexadecimal
                 * integer
                 * The below extracts the individual values using bit-shifting and bit-wise
                 * ANDing with all 1's
                 */
                pixels[y][x] = new Pixel((rgb >> 16) & 0xff, (rgb >> 8) & 0xff, rgb & 0xff);
            }
        }
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * 
     * @param red    The red value of the color
     * @param green  The green value of the color
     * @param blue   The blue value of the color
     * @param height The height of the Picture
     * @param width  The width of the Picture
     */
    public Picture(int red, int green, int blue, int height, int width) {
        pixels = new Pixel[height][width];
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                pixels[y][x] = new Pixel(red, green, blue);
            }
        }
    }

    /**
     * Creates a solid white Picture of a given width and height
     * 
     * @param color  The {@link Color} of the Picture
     * @param height The height of the Picture
     * @param width  The width of the Picture
     */
    public Picture(int height, int width) {
        this(Color.WHITE, height, width);
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * 
     * @param color  The {@link Color} of the Picture
     * @param width  The width of the Picture
     * @param height The height of the Picture
     */
    public Picture(Color color, int height, int width) {
        this(color.getRed(), color.getGreen(), color.getBlue(), height, width);
    }

    /**
     * Creates a Picture based off of an existing {@link Pixel} 2D array
     * 
     * @param pixels A rectangular 2D array of {@link Pixel}s. Must be at least 1x1
     */
    public Picture(Pixel[][] pixels) {
        if (pixels.length == 0 || pixels[0].length == 0)
            throw new RuntimeException("Can't have an empty image!");
        int width = pixels[0].length;
        for (int i = 0; i < pixels.length; i++)
            if (pixels[i].length != width)
                throw new RuntimeException("Pictures must be rectangles. pixels[0].length!=pixels[" + i + "].length!");
        this.pixels = new Pixel[pixels.length][width];
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel(pixels[i][j].getColor());
            }
        }
    }

    /**
     * Creates a Picture based off of an existing Picture
     * 
     * @param picture The Picture to copy
     */
    public Picture(Picture picture) {
        this(picture.pixels);
    }

    /**
     * Gets the width of the Picture
     * 
     * @return The width of the Picture
     */
    public int getWidth() {
        return pixels[0].length;
    }

    /**
     * Gets the height of the Picture
     * 
     * @return The height of the Picture
     */
    public int getHeight() {
        return pixels.length;
    }

    /**
     * Gets the {@link Pixel} at a given coordinate
     * 
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @return The {@link Pixel} at the given location
     */
    public Pixel getPixel(int x, int y) {
        if (x >= getWidth() || y >= getHeight() || x < 0 || y < 0)
            throw new RuntimeException("No pixel at (" + x + ", " + y + ")");
        return pixels[y][x];
    }

    /**
     * Sets the {@link Pixel} at a given coordinate
     * 
     * @param x     The x location of the {@link Pixel}
     * @param y     The y location of the {@link Pixel}
     * @param pixel The new {@link Pixel}
     */
    public void setPixel(int x, int y, Pixel pixel) {
        if (x >= getWidth() || y >= getHeight() || x < 0 || y < 0)
            throw new RuntimeException("No pixel at (" + x + ", " + y + ")");
        if (pixel == null)
            throw new NullPointerException("Pixel is null"); // guard is required because pixel's value isn't used in
                                                             // this method
        pixels[y][x] = pixel;
    }

    /**
     * Opens a {@link PictureViewer} to view this Picture
     * 
     * @return the {@link PictureViewer} viewing the Picture
     */
    public PictureViewer view() {
        return new PictureViewer(this);
    }

    /**
     * Save the image on disk as a JPEG
     * Call programmatically on a Picture object, it will prompt you to choose a
     * save location
     * In the save dialogue window, specify the file AND extension (e.g.
     * "lilies.jpg")
     * Extension must be .jpg as ImageIO is expecting to write a jpeg
     */
    public void save() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        BufferedImage image = new BufferedImage(this.pixels[0].length, this.pixels.length, BufferedImage.TYPE_INT_RGB);

        for (int r = 0; r < this.pixels.length; r++)
            for (int c = 0; c < this.pixels[0].length; c++)
                image.setRGB(c, r, this.pixels[r][c].getColor().getRGB());

        // user's Desktop will be default directory location
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");

        chooser.setDialogTitle("Select picture save location / file name");

        File file = null;

        int choice = chooser.showSaveDialog(null);

        if (choice == JFileChooser.APPROVE_OPTION)
            file = chooser.getSelectedFile();

        // append extension if user didn't read save instructions
        if (!file.getName().endsWith(".jpg") && !file.getName().endsWith(".JPG") && !file.getName().endsWith(".jpeg")
                && !file.getName().endsWith(".JPEG"))
            file = new File(file.getAbsolutePath() + ".jpg");

        try {
            ImageIO.write(image, "jpg", file);
            System.out.println("File created at " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Can't write to location: " + file.toString());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Invalid directory choice");
        }
    }

    /**
     * return a copy of the reference to the 2D array of pixels that comprise this
     * picture
     */
    public Pixel[][] getPixels() {
        return pixels;
    }

    /********************************************************
     *************** STUDENT METHODS BELOW ******************
     ********************************************************/

    /** remove all blue tint from a picture */
    public void zeroBlue() {
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
            }
        }
    }

    /** remove everything BUT blue tint from a picture */
    public void keepOnlyBlue() {
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    /** invert a picture's colors */
    public void negate() {
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }

    /** simulate the over-exposure of a picture in film processing */
    public void solarize(int threshold) {
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                if (pixelObj.getRed() < threshold)
                    pixelObj.setRed(255 - pixelObj.getRed());
                if (pixelObj.getGreen() < threshold)
                    pixelObj.setGreen(255 - pixelObj.getGreen());
                if (pixelObj.getBlue() < threshold)
                    pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }

    /** convert an image to grayscale */
    public void grayscale() {
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                int average = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
                pixelObj.setRed(average);
                pixelObj.setGreen(average);
                pixelObj.setBlue(average);
            }
        }
    }

    /** change the tint of the picture by the supplied coefficients */
    public void tint(double red, double blue, double green) {
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(Math.min((int) (pixelObj.getRed() * red), 255));
                pixelObj.setGreen(Math.min((int) (pixelObj.getGreen() * green), 255));
                pixelObj.setBlue(Math.min((int) (pixelObj.getBlue() * blue), 255));
            }
        }
    }

    /**
     * reduces the number of colors in an image to create a "graphic poster" effect
     */
    public void posterize(int span) {
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(pixelObj.getRed() - (pixelObj.getRed() % span));
                pixelObj.setGreen(pixelObj.getGreen() - (pixelObj.getGreen() % span));
                pixelObj.setBlue(pixelObj.getBlue() - (pixelObj.getBlue() % span));
            }
        }
    }

    /** mirror an image about a vertical midline, left to right */
    public void mirrorVertical() {
        Pixel leftPixel = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < width / 2; c++) {
                leftPixel = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** mirror about a vertical midline, right to left */
    public void mirrorRightToLeft() {
        Pixel leftPixel = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < width / 2; c++) {
                leftPixel = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /** mirror about a horizontal midline, top to bottom */
    public void mirrorHorizontal() {
        Pixel topPixel = null;
        Pixel bottomPixel = null;

        int height = pixels.length;

        for (int r = 0; r < height / 2; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                topPixel = pixels[r][c];
                bottomPixel = pixels[(height - 1) - r][c];

                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /** flip an image upside down about its bottom edge */
    public void verticalFlip() {
        Pixel topPixel = null;
        Pixel bottomPixel = null;

        int height = pixels.length;

        for (int r = 0; r < height / 2; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                topPixel = pixels[r][c];
                bottomPixel = pixels[(height - 1) - r][c];

                topPixel.setColor(bottomPixel.getColor());
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /** fix roof on greek temple */
    public void fixRoof() {
        Pixel leftPixel = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < width / 2; c++) {
                leftPixel = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** detect and mark edges in an image */
    public void edgeDetection(int dist) {
        Pixel leftPixel = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < width - 1; c++) {
                leftPixel = pixels[r][c];
                rightPixel = pixels[r][c + 1];

                if (leftPixel.colorDistance(rightPixel.getColor()) > dist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /**
     * copy another picture's pixels into this picture, if a color is within dist of
     * param Color
     */
    public void chromakey(Picture other, Color color, int dist) {
        Pixel[][] otherPixels = other.getPixels();
        Pixel pixel = null;
        Pixel otherPixel = null;

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixel = pixels[r][c];
                otherPixel = otherPixels[r][c];

                if (pixel.colorDistance(color) < dist)
                    pixel.setColor(otherPixel.getColor());
            }
        }
    }

    /** steganography encode (hide the message in msg in this picture) */
    public void encode(Picture msg) {
        Pixel[][] msgPixels = msg.getPixels();
        Pixel pixel = null;
        Pixel msgPixel = null;

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixel = pixels[r][c];
                msgPixel = msgPixels[r][c];

                if (msgPixel.getRed() == 0)
                    pixel.setRed(pixel.getRed() - 1);
                else
                    pixel.setRed(pixel.getRed() + 1);
            }
        }
    }

    /**
     * steganography decode (return a new Picture containing the message hidden in
     * this picture)
     */
    public Picture decode() {
        Picture newPicture = new Picture(pixels.length, pixels[0].length);
        Pixel[][] newPixels = newPicture.getPixels();
        Pixel pixel = null;
        Pixel newPixel = null;

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixel = pixels[r][c];
                newPixel = newPixels[r][c];

                if (pixel.getRed() % 2 == 0)
                    newPixel.setColor(Color.BLACK);
                else
                    newPixel.setColor(Color.WHITE);
            }
        }
        return newPicture;
    }

    /** perform a simple blur using the colors of neighboring pixels */
    public Picture simpleBlur() {
        Picture newPicture = new Picture(pixels.length, pixels[0].length);
        Pixel[][] newPixels = newPicture.getPixels();
        Pixel pixel = null;
        Pixel newPixel = null;

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixel = pixels[r][c];
                newPixel = newPixels[r][c];

                newPixel.setColor(pixel.getColor());
            }
        }

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixel = pixels[r][c];
                newPixel = newPixels[r][c];

                if (r == 0 || r == pixels.length - 1 || c == 0 || c == pixels[0].length - 1)
                    continue;

                int red = 0;
                int green = 0;
                int blue = 0;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        red += pixels[r + i][c + j].getRed();
                        green += pixels[r + i][c + j].getGreen();
                        blue += pixels[r + i][c + j].getBlue();
                    }
                }

                newPixel.setRed(red / 9);
                newPixel.setGreen(green / 9);
                newPixel.setBlue(blue / 9);
            }
        }

        return newPicture;
    }

    /** perform a blur using the colors of pixels within radius of current pixel */
    public Picture blur(int radius) {

        Picture newPicture = new Picture(pixels.length, pixels[0].length);
        Pixel[][] newPixels = newPicture.getPixels();
        Pixel pixel = null;
        Pixel newPixel = null;

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixel = pixels[r][c];
                newPixel = newPixels[r][c];

                newPixel.setColor(pixel.getColor());
            }
        }

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                pixel = pixels[r][c];
                newPixel = newPixels[r][c];

                int red = 0;
                int green = 0;
                int blue = 0;
                int count = 0;

                for (int i = -radius; i <= radius; i++) {
                    for (int j = -radius; j <= radius; j++) {
                        if (r + i < 0 || r + i >= pixels.length || c + j < 0 || c + j >= pixels[0].length)
                            continue;

                        red += pixels[r + i][c + j].getRed();
                        green += pixels[r + i][c + j].getGreen();
                        blue += pixels[r + i][c + j].getBlue();
                        count++;
                    }
                }

                newPixel.setRed(red / count);
                newPixel.setGreen(green / count);
                newPixel.setBlue(blue / count);
            }
        }

        return newPicture;
    }

    /**
     * Simulate looking at an image through a pane of glass
     * 
     * @param dist the "radius" of the neighboring pixels to use
     * @return a new Picture with the glass filter applied
     */
    public Picture glassFilter(int dist) {
        Picture glass = new Picture(pixels.length, pixels[0].length);

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                int randR = (int) (Math.random() * dist * 2) - dist;
                int randC = (int) (Math.random() * dist * 2) - dist;

                if (r + randR >= 0 && r + randR < pixels.length && c + randC >= 0 && c + randC < pixels[0].length)
                    glass.getPixel(r, c).setColor(pixels[r + randR][c + randC].getColor());
                else
                    glass.getPixel(r, c).setColor(pixels[r][c].getColor());
            }
        }

        return glass;

    }
}
