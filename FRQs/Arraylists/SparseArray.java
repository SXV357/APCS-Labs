package FRQs.Arraylists;
import java.util.ArrayList;

public class SparseArray {

  /** The number of rows and columns in the sparse array. */
  private int numRows;
  private int numCols;
  /** The list of entries representing the non-zero elements of the sparse array. Entries are stored in the
   * list in no particular order. Each non-zero element is represented by exactly one entry in the list.
   */
  private ArrayList<SparseArrayEntry> entries;

  /** Constructs an empty SparseArray. */
  public SparseArray() {
    entries = new ArrayList<SparseArrayEntry>();
  }

  /** Returns the number of rows in the sparse array. */
  public int getNumRows() {
    return numRows;
  }

  /** Returns the number of columns in the sparse array. */
  public int getNumCols() {
    return numCols;
  }

  /** Returns the value of the element at row index row and column index col in the sparse array.
   * Precondition: 0  row < getNumRows()
   * 0  col < getNumCols()
   */
  public int getValueAt(int row, int col) {
    for (int i = 0; i < entries.size(); i++) {
        /*Compare rows and columns to find a possible match */
      if (entries.get(i).getRow() == row && entries.get(i).getCol() == col) {
        return entries.get(i).getValue();
      }
    }
    return 0;
  }

  /** Removes the column col from the sparse array.
   * Precondition: 0  col < getNumCols()
   */
  public void removeColumn(int col) {
    for (int i = 0; i < entries.size(); i++) {
      if (entries.get(i).getCol() == col) {
        entries.remove(i); /*Column indexes matching col are removed */
      } else if (entries.get(i).getCol() > col) { /*For column indexes greater than col */
        entries.set(
          i,
          new SparseArrayEntry(
            entries.get(i).getRow(),
            entries.get(i).getCol() - 1, /*Replaced by entries with column index less than 1 */
            entries.get(i).getValue()
          )
        );
      }
      i++;
    }
    numCols--; /*Overall number of columns decremented to reflect new changes */
  }
}
