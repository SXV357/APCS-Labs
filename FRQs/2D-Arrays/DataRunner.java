public class DataRunner {
    public static void main(String[] args){

        int[][] arr = new int[10][10];

        Data runner = new Data(10000, arr);
        runner.repopulate();
        System.out.println(runner.countIncreasingCols());
    }
}
