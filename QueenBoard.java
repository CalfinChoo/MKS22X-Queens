public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size) {
    board = new board[size][size];
  }
  private boolean addQueen(int r, int c) {
    if (board[r][c] == 0) {
      board[r][c] == -1;
      if (r < board.length - 1) {
        for (int row = r + 1; row < board.length; row++) {
          for (int col = 0; col < board[row].length; col++) {
            if (board[row][col] == 0 && (col == c || row - r == col - r || row - r == col + r)) {

            }
          }
        }
      }
      return true;
    }
    else return false;
  }
  private boolean removeQueen(int r, int c) {

  }
  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){}


  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){}

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){}

}