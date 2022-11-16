public class LightBoard {
    private boolean[][] lights;

    public LightBoard(int numRows, int numCols){
        lights = new boolean[numRows][numCols];
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                lights[i][j] = Math.random() < 0.4;
            }
        }
    }

    public boolean evaluateLight(int row, int col){
        if (lights[row][col]){
            int numLightsOn = 0;
            for (int r = 0; r < lights.length; r++){
                if (lights[r][col]){
                    numLightsOn++;
                }
            }
            if (numLightsOn % 2 == 0){
                return false;
            }
        }
        else if (!lights[row][col]){
            int lightsOnDivisibleByThree = 0;
            for (int r = 0; r < lights.length; r++){
                if (lights[r][col]){
                    lightsOnDivisibleByThree++;
                }
            }
            if (lightsOnDivisibleByThree % 3 == 0){
                return true;
            }
        }
        return lights[row][col];
    }
}
