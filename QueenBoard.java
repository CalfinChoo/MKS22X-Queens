public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size) {
    board = new int[size][size];
  }
  private boolean addQueen(int r, int c) {
    if (r >= board.length || c >= board[0].length) return false;
    if (board[r][c] == 0) {
      board[r][c] = -1;
      for (int row = r + 1; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
          if (col == c || Math.abs(r - row) == c - col || Math.abs(r - row) ==  Math.abs(c - col)) {
            if (board[row][col] == 0) board[row][col] = r + 1;
          }
        }
      }
      return true;
    }
    else return false;
  }
  private boolean removeQueen(int r, int c) {
    if (board[r][c] == -1) {
      board[r][c] = 0;
      for (int row = r + 1; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
          if (board[row][col] == r + 1) {
            board[row][col] = 0;
          }
        }
      }
      return true;
    }
    else return false;
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
        if (board[row][col] == -1) s += "Q";
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
  public boolean solve(){
    return solveHelper(0, 0);
  }
  public boolean solveHelper(int row, int col) {
    try{
      if (row < board.length) {
        for (int c : board[row]) {
          if (c == -1) throw new IllegalStateException();
        }
      }
    } catch(IllegalStateException e) {
        e.printStackTrace();
        return false;
    }
    if (row < board.length) {
      if (addQueen(row, col)) return solveHelper(row + 1, 0);
      else {
        if (col < board[row].length - 1) {
          return solveHelper(row, col + 1);
        }
        else {
          if (row > 0) {
            int index = 0;
            for (int c = 0; c < board[row].length; c++) {
              if (board[row - 1][c] == -1) index = c;
            }
            removeQueen(row - 1, index);
            return solveHelper(row - 1, index + 1);
          }
          else return false;
        }
      }
    }
    else return true;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){return 1;}
}
