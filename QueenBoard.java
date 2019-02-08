public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size) {
    board = new int[size][size];
  }
  public boolean addQueen(int r, int c) {
    if (board[r][c] == 0) {
      board[r][c] = -1;
      for (int row = r; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
          if (row == r || col == c || Math.abs(r - row) == c - col || Math.abs(r - row) ==  Math.abs(c - col)) {
            if (board[row][col] == 0) board[row][col] = row + 1;
            else if (board[row][col] != -1) return false;
          }
        }
      }
      return true;
    }
    else return false;
  }
  private boolean removeQueen(int r, int c) {
    return true;
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
  public String toString(){
    String s = "";
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if (board[row][col] != 0) s += "Q";
        else s += "_";
        if (col < board[row].length - 1) s += " ";
        else s += "\n";
      }
    }
    return s;
  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){return true;}

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){return 1;}
}
