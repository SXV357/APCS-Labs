package src;
import java.util.*;
import java.io.*;

class SoundClip {
	double[] clip;

   public SoundClip(){
	   clip = null;
   }

   public SoundClip(double[] c){
	   clip = c;
   }

   void adjustVolume(double factor){
	   for (int i = 0; i < clip.length; i++){
		   clip[i] *= factor;
	   }
   }

   void mix(double[] clip1, double[] clip2){
        int maxLen = Math.max(clip1.length, clip2.length);
        double[] newArr = new double[maxLen];
        for(int i = 0; i < maxLen; i++){
            if(i < clip1.length && i < clip2.length){
                newArr[i] = clip1[i] + clip2[i];
            } else if(i < clip1.length){
                newArr[i] = clip1[i];
            } else {
                newArr[i] = clip2[i];
            }
        }
            clip = newArr;
   }

   void append(String fileName) throws IOException{
			Scanner input = new Scanner(new File(fileName));
			double[] result = new double[clip.length + Integer.parseInt(input.nextLine())];
	   		for (int i = 0; i < clip.length; i++){
		   		result[i] = clip[i];
	   		}
            for (int i = clip.length; i < result.length; i++){
                result[i] = input.nextDouble();
            }
	   		clip = result;
   }

   void fadeIn(double seconds){
	   int numSamples = Sound.toNumSamples(seconds);
	   for (int i = 0; i < numSamples; i++){
		   clip[i] *= (double)i / numSamples;
	   }
   }

   void fadeOut(double seconds){
	   int numSamples = Sound.toNumSamples(seconds);
	   for (int i = 0; i < numSamples; i++){
		   clip[clip.length - i - 1] *= (double)i / numSamples;
	   }
   }

   void reverse(){
	   double[] result = new double[clip.length];
	   for (int i = 0; i < clip.length; i++){
		   result[i] = clip[clip.length - i - 1];
	   }
	   clip = result;

   }

   void speedUp(double factor){
	   double[] result = new double[(int)(clip.length / factor)];
	   for (int i = 0; i < result.length; i++){
		   result[i] = clip[(int)(i * factor)];
	   }
	   clip = result;
   }
}


