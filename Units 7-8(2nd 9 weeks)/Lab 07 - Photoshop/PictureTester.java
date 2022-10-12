import java.awt.*;

public class PictureTester 
{
    public static void main(String[] args) 
    {
    	//construct a Picture object from a jpg image on disk
        Picture beach = new Picture("beach.jpg"); 
		Picture koala = new Picture("koala.jpg");
		Picture lillies = new Picture("waterlilies.jpg");
		Picture gorge = new Picture("gorge.jpg");
		Picture bike = new Picture("redMotorcycle.jpg");
		Picture temple = new Picture("temple.jpg");
		Picture swan = new Picture("swan.jpg");
        
        beach.view(); //calling the view() method displays the picture with the PictureViewer GUI
        
        //PUT YOUR TESTS HERE
		beach.zeroBlue();
		beach.view(); // pass

		beach.keepOnlyBlue();
		beach.view(); // pass

		koala.negate();
		koala.view(); // pass

		lillies.solarize(127);
		lillies.view(); // pass

		gorge.grayscale();
		gorge.view(); // pass

        beach.tint(1.25, 0.75, 1);
		beach.view(); // pass

		lillies.posterize(63);
		lillies.view(); // pass

		bike.mirrorRightToLeft();
		bike.view(); // pass

		bike.mirrorHorizontal();
		bike.view(); // pass

		lillies.verticalFlip();
		lillies.view(); // pass

		temple.fixRoof();
		temple.view(); // pass

		swan.edgeDetection(25);
		swan.view(); // pass

		testChromakey(); // pass
		testSteganography(); // fail

		lillies.simpleBlur();
		lillies.view(); // pass

		lillies.blur(5);
		lillies.view(); // fail

		lillies.glassFilter(5);
		lillies.view(); // fail
        
    }
    
    
    
    
    /** this method is static, you don't need to call it on an object (just "testChromekey()") */
	public static void testChromakey()
	{
		Picture one = new Picture("blue-mark.jpg");
		Picture two = new Picture("moon-surface.jpg");
		
		one.view(); //show original mustache guy picture
		two.view(); //show the untouched moon's surface pic
		
		one.chromakey(two, new Color(10, 40, 75), 60); //replace this color if within 60
		
		one.view();
	}
	
    /** this method is static, you don't need to call it on an object (just "testSteganography()") */
	public static void testSteganography()
	{
		Picture msg   = new Picture("msg.jpg");
		Picture beach = new Picture("beach.jpg");
		
		beach.encode(msg); //hide message in beach picture
		beach.view();      //beach w/ hidden message inside, shouldn't look different
		
		beach.decode().view(); //see the hidden message in the beach picture
	}
}
