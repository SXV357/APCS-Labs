public class GrayImage {
    public static final int BLACK = 0;
    public static final int WHITE = 255;

    private int[][] pixelValues;

    public int countWhitePixels() {
        int count = 0;
        for (int[] row : pixelValues) {
            for (int val : row) {
                if (val == WHITE) {
                    count++;
                }
            }
        }
        return count;
    }

    public void processImage() {
        for (int r = 0; r < pixelValues.length; r++) {
            for (int c = 0; c < pixelValues[0].length; c++) {
                if (pixelValues[r + 2][c + 2] >= 0 && pixelValues[r + 2][c + 2] <= 255
                        && pixelValues[r][c] - pixelValues[r + 2][c + 2] < 0) {
                    pixelValues[r][c] = BLACK;
                } else if (pixelValues[r + 2][c + 2] >= 0 && pixelValues[r + 2][c + 2] <= 255
                        && pixelValues[r][c] - pixelValues[r + 2][c + 2] >= 0
                        && pixelValues[r][c] - pixelValues[r + 2][c + 2] <= 255) {
                    pixelValues[r][c] -= pixelValues[r + 2][c + 2];
                } else if (pixelValues[r + 2][c + 2] == BLACK) {
                    pixelValues[r][c] = pixelValues[r][c];
                }
            }
        }
    }
}
