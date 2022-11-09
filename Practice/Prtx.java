public class Prtx {
    public static void main(String[] args){

    }

    public static double percentTrue(boolean[][] matrix){
        int totalVals = matrix.length * matrix[0].length;
        int totalTrue = 0;
        for (int r = 0; r < matrix.length; r++){
            for (int c = 0; c < matrix[0].length; c++){
                if (matrix[r][c] == true){
                    totalTrue++;
                }
            }
        }
        return (double) totalTrue / totalVals;
    }

    public static int findFirstNonBlueColumn(Color[][] picture){
        Color color = new Color(0,0,255);
        for (int c = 0; c < picture[0].length; c++){
            for (int r = 0; r < picture.length; r++){
                if (!picture[r][c].equals(color.getBlue())){
                    return c;
                }
            }
        }
        return -1; // if all pixels in the image are of blue color
    }
}
