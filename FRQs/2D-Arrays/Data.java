import java.util.*;
import java.util.Arrays;

class Data {
    public static int MAX;
    private int[][] grid;

    public Data(int MAX, int[][] grid) {
        this.MAX = MAX;
        this.grid = grid;
    }

    public void repopulate() {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int low = 1;
                int high = MAX;
                int rand = (int) (Math.random() * (high - low)) + low;
                while (rand % 10 == 0 && rand % 100 != 0) {
                    rand = (int) (Math.random() * (high - low)) + low;
                }
                grid[r][c] = rand;
            }
        }
        System.out.println(Arrays.deepToString(grid));
    }

    public int countIncreasingCols() {
        int count = 0;
        boolean isIncreasing = false;
        for (int c = 0; c < grid[0].length; c++){
            for (int r = 0; r < grid.length - 1; r++){
                if (grid[r][c] < grid[r + 1][c]){
                    isIncreasing = true;
                } else {
                    isIncreasing = false;
                    break;
                }
            }
            if (isIncreasing){
                count++;
            }
        }
        return count;
    }
}