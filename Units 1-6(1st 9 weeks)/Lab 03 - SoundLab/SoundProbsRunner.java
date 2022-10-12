import java.util.Arrays;
public class SoundProbsRunner {
    public static void main(String[] args){
        SoundLabProbs sound =  new SoundLabProbs();
        sound.triangle(7);
        //lastIndexOf method
        System.out.println(sound.lastIndexOf(new int[] {8, 2, 4, 6, 8}, 8));
        System.out.println(sound.lastIndexOf(new int[] {2, 4, 6, 12}, 8));
        //range method
        System.out.println(sound.range(new int[] {8, 3, 5, 7, 2, 4}));
        System.out.println(sound.range(new int[] {15, 22, 8, 19, 31}));
        //minDifference method
        System.out.println(sound.minDifference(new int[] {4, 8, 6, 1, 5, 9, 4}));
        //priceIsRight method
        System.out.println(sound.priceIsRight(new int[] {900, 885, 990, 1}, 800));
        System.out.println(sound.priceIsRight(new int[] {1500, 1600, 2000, 2500}, 1900));
        //productExceptSelf method
        System.out.println(Arrays.toString(sound.productExceptSelf((new int[] {1, 2, 3, 4}))));
    }
}