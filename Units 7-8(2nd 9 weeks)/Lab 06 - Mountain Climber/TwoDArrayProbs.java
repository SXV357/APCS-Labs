import java.util.Arrays;
class TwoDArrayProbs {
    private int[][] nums;

    public TwoDArrayProbs(int[][] n) {
        nums = n;
    }

    public int sum() {
        int sum = 0;
        for (int[] row : nums) {
            for (int num : row) {
                sum += num;
            }
        }
        return sum;
    }

    public boolean isSquare(){
        for (int[] row : nums) {
            if (row.length != nums.length) {
                return false;
            }
        }
        return true;
    }

    public void addMatrix(int[][] other){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] += other[i][j];
            }
        }
        for (int[] row : nums) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int columnSum(int col){
        int sum = 0;
        for (int[] row : nums) {
            if (col < row.length) {
                sum += row[col];
            }
        }
        return sum;
    }

    public boolean isColumnMagic(){
        int sum = columnSum(0);
        for (int i = 1; i < nums[0].length; i++) {
            if (columnSum(i) != sum) {
                return false;
            }
        }
        return true;
    }

    public int diagDifference(){
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i][i];
            sum2 += nums[i][nums.length - i - 1];
        }
        return Math.abs(sum1 - sum2);
    }
}
