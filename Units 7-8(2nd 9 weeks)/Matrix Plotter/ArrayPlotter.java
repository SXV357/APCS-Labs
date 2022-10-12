import java.util.*;
/**
 * ArrayPlotter.java  10/18/14
 *
 * @author - Robert Glen Martin
 * @author - School for the Talented and Gifted
 * @author - Dallas ISD
 *
 * The ArrayPlotter class provides methods for drawing in
 *    a grid by setting the boolean values of a 2D array.
 *
 *    Each drawing method must
 *    - take zero arguments,
 *    - have a void return type, and
 *    - have a name that conforms to the on...ButtonClick format.
 *      (This restriction allows the GridPlotterGUI to recognize methods,
 *       for which it automatically generates buttons.)
 *
 * License Information:
 *   This class is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation.
 *
 *   This class is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 */

public class ArrayPlotter
{
    /** The Array Plotter Graphical User Interface. */
    private ArrayPlotterGUI gui;

    /** The Color Array.  The element values indicate how to color a grid cell:
     *  - true: Color the cell with the Drawing Color.
     *  - false: Color the cell with the Background Color.
     */
    private boolean[][] colorArray;

    /** Constructs an Array Plotter */
    public ArrayPlotter()
    {
        gui = new ArrayPlotterGUI(this);
        colorArray = null;
    }

    /** Initialize this's Color Array to a new 2D array of boolean values
     *  with the given dimensions.
     *  @param rows the number of rows in the new array.
     *  @param cols the number of columns in the new array.
     *  Postcondition: All of the Color Array's elements have the value false.
     */
    public void initializeColorArray(int rows, int cols)
    {
        colorArray = new boolean[rows][cols];
    }

    // Drawing Methods
    /** Removes all objects from the grid. */
    public void clearGrid()
    {
        colorArray = new boolean[colorArray.length][colorArray[0].length];
        gui.update(colorArray);
    }

    /** This button calls the method above, which clears the grid. */
    public void onClearGridButtonClick()
    {
        clearGrid();
    }

    /** NOTE FROM MR. MCCOY ON HOW THIS THING WORKS. ------------------------------------------------------- 
     * 
     * Complete the methods below using for loops to fill the matrix in a specific orders/patterns.
     * 
     * Your instance variable is a 2-dimensional boolean array called colorArray.
     * To make a cell appear as filled, you have to set it as true and then tell the gui to update.
     * 
     * Example:         colorArray[3][7] = true;
     *                  gui.update(colorArray);
     * 
     * To ensure that you are coding wisely, this should be done efficiently using for loops.
     * Therefore, I am limiting the number of times you are allowed to inclde the gui.update()
     * command in each method.  See the method description for limit.
     * 
     * You can add your own methods also!  Buttons will be created automatically, as long as you follow
     * the correct naming convention.  The authors of this lab built that feature into the GUI!
     * 
     *-----------------------------------------------------------------------------------------------------*/

    /** Fills in all the cells of the grid using a row-major traversal. */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 1  ******/
    public void onRowMajorFillButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            //I've provided some code below, but it is obviously wrong since it only fills 1 cell.
            // colorArray[5][5] = true;
            // gui.update(colorArray);
            for (int i = 0; i < colorArray.length; i++) {
                for (int j = 0; j < colorArray[0].length; j++) {
                    colorArray[i][j] = true;
                    gui.update(colorArray);
                }
            }

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in all the cells of the grid using a column-major traversal. */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 1  ******/
    public void onColMajorFillButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            for (int i = 0; i < colorArray.length; i++) {
                for (int j = 0; j < colorArray[0].length; j++) {
                    colorArray[j][i] = true;
                    gui.update(colorArray);
                }
            }

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in all the cells of the grid bottom-up, going left-to-right across each row.  */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 1  ******/
    public void onReverseRowMajorFillButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            for (int i = colorArray.length - 1; i >= 0; i--) {
                for (int j = 0; j < colorArray[0].length; j++) {
                    colorArray[i][j] = true;
                    gui.update(colorArray);
                }
            }

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in all the cells of the grid right-to-left, going up each column from the bottom. */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 1  ******/
    public void onReverseColMajorFillButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            for (int i = colorArray[0].length - 1; i >= 0; i--) {
                for (int j = 0; j < colorArray.length; j++) {
                    colorArray[j][i] = true;
                    gui.update(colorArray);
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in the cells creating a diagonal from the upper-left corner down and to the right. */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 1  ******/
    public void onMainDiagonalLineButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            for (int i = 0; i < colorArray.length; i++) {
                for (int j = 0; j < colorArray[0].length; j++) {
                    if (i == j) {
                        colorArray[i][j] = true;
                        gui.update(colorArray);
                    }
                }
            } 

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in the cells of the grid on and below the main diagonal. */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 1  ******/
    public void onMainTriangleFillButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            for (int i = 0; i < colorArray.length; i++) {
                for (int j = 0; j < colorArray[0].length; j++) {
                    if (i >= j) {
                        colorArray[i][j] = true;
                        gui.update(colorArray);
                    }
                }
            }
            
            
        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in the cells creating a diagonal from the upper-right corner down and to the left. */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 1  ******/
    public void onOtherDiagonalLineButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            for (int i = 0; i < colorArray.length; i++) {
                for (int j = 0; j < colorArray[0].length; j++) {
                    if (i == colorArray[0].length - j - 1) {
                        colorArray[i][j] = true;
                        gui.update(colorArray);
                    }
                }
            }
            

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in the cells of the grid on and below the other diagonal. */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 1  ******/
    public void onOtherTriangleFillButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            for (int i = 0; i < colorArray.length; i++) {
                for (int j = colorArray[0].length - 1; j >= 0; j--) {
                    if (i + j >= colorArray[0].length - 1) {
                        colorArray[i][j] = true;
                        gui.update(colorArray);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in the cells of the grid on the two diagonals */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 2  ******/
    public void onBothDiagonalsButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            for (int i = 0; i < colorArray.length; i++) {
                for (int j = 0; j < colorArray[0].length; j++) {
                    if (i == j || i == colorArray[0].length - j - 1) {
                        colorArray[i][j] = true;
                        gui.update(colorArray);
                    }
                }
            }
            

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in the cells of the grid in a serpentine fashion from the top left corner*/
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 2  ******/
    public void onSerpentineFillButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            for (int i = 0; i < colorArray.length; i++) {
                for (int j = 0; j < colorArray[0].length; j++) {
                    if (i % 2 == 0) {
                        colorArray[i][j] = true;
                        gui.update(colorArray);
                    } else {
                        colorArray[i][colorArray[0].length - j - 1] = true;
                        gui.update(colorArray);
                    }
                }
            }
            

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in the cells of the grid along the outside border starting in the upper left corner and going clockwise. */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 4  ******/
    public void onBorderLinesButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            for (int i = 0; i < colorArray.length; i++) {
                for (int j = 0; j < colorArray[0].length; j++) {
                    if (i == 0 || i == colorArray.length - 1) {
                        colorArray[i][j] = true;
                        gui.update(colorArray);
                    } else if (j == 0 || j == colorArray[0].length - 1) {
                        colorArray[i][j] = true;
                        gui.update(colorArray);
                    }
                }
            }
            

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in the cells of the grid in a spiral toward center, starting in the upper left corner and going clockwise. */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 4  ******/
    public void onSpiralFillButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            int left = 0;
            int right = colorArray[0].length - 1;
            int top = 0;
            int bottom = colorArray.length - 1;
            while (left <= right && top <= bottom) {
                for (int i = left; i <= right; i++) {
                    colorArray[top][i] = true;
                    gui.update(colorArray);
                }
                top++;
                for (int i = top; i <= bottom; i++) {
                    colorArray[i][right] = true;
                    gui.update(colorArray);
                }
                right--;
                for (int i = right; i >= left; i--) {
                    colorArray[bottom][i] = true;
                    gui.update(colorArray);
                }
                bottom--;
                for (int i = bottom; i >= top; i--) {
                    colorArray[i][left] = true;
                    gui.update(colorArray);
                }
                left++;
            }

           
        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills from top left to bottom right using upward diagonal lines */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 2  ******/
    public void onDiagonalFillButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            //TO DO
            for (int i = 0; i < colorArray.length; i++) {
                for (int j = 0; j < colorArray[0].length; j++) {
                    if (i == j) {
                        colorArray[i][j] = true;
                        gui.update(colorArray);
                    }
                }
            }

            
        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** Fills in the cells of the grid in a spiral toward center, starting in the upper left corner and going clockwise. */
    /******** MAXIMUM NUMBER OF gui.update(colorArray) STATEMENTS: 1  ******/
    public void onRandomFillButtonClick()
    {
        try {
            clearGrid();  //We should always start with a clean grid.
            //Your solution should be here in the try block.
            Random rand = new Random();
            int count = 0;
            while (count < colorArray.length * colorArray[0].length) {
                int row = rand.nextInt(colorArray.length);
                int col = rand.nextInt(colorArray[0].length);
                if (!colorArray[row][col]) {
                    colorArray[row][col] = true;
                    gui.update(colorArray);
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong! " + e + "\n");
            clearGrid();  //
        }
    }

    /** main method that creates the grid plotter application. */
    public static void main(String[] args)
    {
        new ArrayPlotter();
    }
}
