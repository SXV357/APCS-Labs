public class LightBoard {
    private boolean[][] lights;

    public LightBoard(int numRows, int numCols){
        lights = new boolean[numRows][numCols];
        for (int r = 0; r < lights.length; r++){
            for (int c = 0; c < lights[r].length; c++){
                lights[r][c] = Math.random() < 0.4;
            }
        }
    }

    public boolean evaluateLight(int row, int col){
        if (lights[row][col]){

        }
        return true;
    }
}
