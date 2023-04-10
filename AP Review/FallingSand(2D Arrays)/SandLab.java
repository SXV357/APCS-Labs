import java.awt.*;

public class SandLab {

  //add constants for particle types here
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER = 3;
  public static final int LAVA = 4;

  //do not add any more fields!
  private int[][] grid;
  private SandDisplay display; //SandDisplay is the GUI class

  public SandLab(int numRows, int numCols) {
    String[] names = new String[5];

    names[EMPTY] = "Empty";
    names[METAL] = "Metal";
    names[SAND] = "Sand";
    names[WATER] = "Water";
    names[LAVA] = "Lava";

    display = new SandDisplay("Falling Sand", numRows, numCols, names);
    grid = new int[numRows][numCols];
  }

  /** called when the user clicks on a location using the given tool */
  private void locationClicked(int row, int col, int tool) {
    grid[row][col] = tool;
  }

  /** copies each element of grid into the display */
  public void updateDisplay() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        switch (grid[i][j]) {
          case EMPTY:
            display.setColor(i, j, new Color(0, 0, 0));
            break;
          case METAL:
            display.setColor(i, j, new Color(163, 164, 159));
            break;
          case SAND:
            display.setColor(i, j, new Color(253, 218, 13));
            break;
          case WATER:
            display.setColor(i, j, new Color(0, 0, 255));
            break;
          case LAVA:
            display.setColor(i, j, new Color(207, 16, 32));
            break;
        }
      }
    }
  }

  /** called repeatedly, causes one random particle to maybe do something */
  public void step() {
    int randomRow = (int) Math.floor(Math.random() * grid.length);
    int randomCol = (int) Math.floor(Math.random() * grid[0].length);
    if (
      randomRow >= 0 &&
      randomRow <= grid.length - 1 &&
      randomCol >= 0 &&
      randomCol <= grid[0].length - 1
    ) {
      int gridVal = grid[randomRow][randomCol];
      if (!(gridVal == METAL)) {
        if (
          randomRow != grid.length - 1 &&
          randomCol != 0 &&
          randomCol != grid[0].length - 1
        ) {
          if (
            gridVal == SAND &&
            (
              grid[randomRow + 1][randomCol] == EMPTY ||
              grid[randomRow + 1][randomCol] == WATER
            )
          ) {
            grid[randomRow + 1][randomCol] = SAND;
            grid[randomRow][randomCol] = EMPTY;
          }
          if (gridVal == WATER) {
            if (grid[randomRow + 1][randomCol] == EMPTY) {
              grid[randomRow + 1][randomCol] = WATER;
              grid[randomRow][randomCol] = EMPTY;
            } else if (grid[randomRow][randomCol - 1] == EMPTY) {
              grid[randomRow][randomCol - 1] = WATER;
              grid[randomRow][randomCol] = EMPTY;
            } else if (grid[randomRow][randomCol + 1] == EMPTY) {
              grid[randomRow][randomCol + 1] = WATER;
              grid[randomRow][randomCol] = EMPTY;
            }
          }
          if (gridVal == LAVA && (grid[randomRow + 1][randomCol] == EMPTY || grid[randomRow + 1][randomCol] == SAND || grid[randomRow + 1][randomCol] == WATER)){
            grid[randomRow + 1][randomCol] = LAVA;
            grid[randomRow][randomCol] = EMPTY;
          }
        }
      }
    }
  }

  //do not modify!
  public void run() {
    while (true) {
      for (int i = 0; i < display.getSpeed(); i++) step();

      updateDisplay();

      display.repaint();

      display.pause(1); //wait for redrawing and for mouse

      int[] mouseLoc = display.getMouseLocation();

      if (mouseLoc != null) locationClicked(
        mouseLoc[0],
        mouseLoc[1],
        display.getTool()
      ); //test if mouse clicked
    }
  }
}
