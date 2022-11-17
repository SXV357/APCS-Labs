import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MapIllustrator
{
	/** the 2D array containing the elevations */
	private int[][] grid;

	/** constructor, parses input from the file into grid */
	public MapIllustrator (String fileName) throws IOException
	{
		Scanner in = new Scanner(new File(fileName));
		int rows = in.nextInt();
		int cols = in.nextInt();
		grid = new int[rows][cols];
		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < cols; c++)
			{
				grid[r][c] = in.nextInt();
			}
		}
		in.close();
	}

	/** @return the min value in the entire grid */
	public int findMin()
	{
		int min = grid[0][0];
		for (int r = 0; r < grid.length; r++)
		{
			for (int c = 0; c < grid[r].length; c++)
			{
				if (grid[r][c] < min)
				{
					min = grid[r][c];
				}
			}
		}
		return min;
	}

	/** @return the max value in the entire grid */
	public int findMax()
	{
		int max = grid[0][0];
		for (int r = 0; r < grid.length; r++)
		{
			for (int c = 0; c < grid[r].length; c++)
			{
				if (grid[r][c] > max)
				{
					max = grid[r][c];
				}
			}
		}
		return max;
	}

	/**
	 * Draws the grid using the given Graphics object.
	 * Colors should be grayscale values 0-255, scaled based on min/max values in grid
	 */
	public void drawMap(Graphics g)
	{
		int min = findMin();
		int max = findMax();
		for (int c = 0; c < grid[0].length; c++)
		{
			for (int r = 0; r < grid.length; r++)
			{
				int shade = (int) (255.0 * (grid[r][c] - min) / (max - min));
				g.setColor(new Color(shade, shade, shade));
				g.fillRect(c, r, 1, 1);
			}
		}
	}

	/**
	 * Find a path from West-to-East starting at given row.
	 * Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
	 * @return the total change in elevation traveled from West-to-East
	 */
	public int drawPath(Graphics g, int row)
	{
		int totalChange = 0;
		int currentRow = row;
		int currentCol = 0;
		int[] possibleRows = new int[3];
		int[] possibleChanges = new int[3];
		int minChange = 0;
		int minChangeIndex = 0;
		while (currentCol < grid[0].length - 1)
		{
			possibleRows[0] = currentRow - 1;
			possibleRows[1] = currentRow;
			possibleRows[2] = currentRow + 1;
			for (int i = 0; i < 3; i++)
			{
				if (possibleRows[i] < 0)
				{
					possibleRows[i] = 0;
				}
				else if (possibleRows[i] >= grid.length)
				{
					possibleRows[i] = grid.length - 1;
				}
				possibleChanges[i] = Math.abs(grid[currentRow][currentCol] - grid[possibleRows[i]][currentCol + 1]);
			}
			minChange = possibleChanges[0];
			minChangeIndex = 0;
			for (int i = 1; i < 3; i++)
			{
				if (possibleChanges[i] < minChange)
				{
					minChange = possibleChanges[i];
					minChangeIndex = i;
				}
			}
			totalChange += minChange;
			currentRow = possibleRows[minChangeIndex];
			currentCol++;
			g.fillRect(currentCol, currentRow, 1, 1);
		}
		return totalChange;
	}

	/** @return the index of the starting row for the lowest-elevation-change path in the entire grid. */
	public int getIndexOfLowestPath(Graphics g)
	{
		int lowestChange = drawPath(g, 0);
		int lowestChangeIndex = 0;
		for (int i = 1; i < grid.length; i++)
		{
			int change = drawPath(g, i);
			if (change < lowestChange)
			{
				lowestChange = change;
				lowestChangeIndex = i;
			}
		}
		return lowestChangeIndex;
	}

	/** return the number of rows in grid */
	public int getRows()
	{
		return grid.length;
	}

	/** return the number of columns in grid (assumed rectangular) */
	public int getCols()
	{
		return grid[0].length;
	}
}
