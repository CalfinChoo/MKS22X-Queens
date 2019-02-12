public class QueenBoard{
  private int[][] board;
  public QueenBoard(int size) {
    board = new int[size][size];
  }
  public boolean addQueen(int r, int c) { // adds a Queen to row r, col c and places threatened markers for the next rows/cols
    if (r >= board.length || c >= board[0].length) return false;
    if (board[r][c] == 0) {
      board[r][c] = -1;
      for (int row = r; row < board.length; row++) {
        for (int col = 0; col < board[row].length; col++) {
          if (row == r || col == c || Math.abs(r - row) == c - col || Math.abs(r - row) ==  Math.abs(c - col)) {
            if (board[row][col] == 0) board[row][col] = r + 1;
          }
        }
      }
      return true;
    }
    else return false;
  }
  private boolean removeQueen(int r, int c) { // removes a Queen at row r, col c as well as its corresponding markers
    if (board[r][c] == -1) {
      board[r][c] = 0;
      for (int row = r; row < board.length; row++) {
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
        if (board[row][col] == - 1) s += "Q";
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
    return solveHelper(0, false);
  }
  public boolean solveHelper(int row, boolean checked) {
    if (board.length > 0 && row == board.length) return true;  // base case
    if (!checked) { //checks once to see if board is clear
      try{
          for (int[] r : board) {
            for (int c : r) {
              if (c != 0) throw new IllegalStateException();
            }
          }
        checked = true;
      } catch(IllegalStateException e) {
          e.printStackTrace();
          return false;
      }
    }
    for (int c = 0; c < board.length; c++) { // attempts to addQueen to each row and removes it if it if it cannot add to the next
      if (addQueen(row, c)) {
        if (solveHelper(row + 1, checked)) return true; // returns true if a solution is found
        removeQueen(row, c);
      }
    }
    return false; //returns false otherwise
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    return countHelper(0, 0, board.length, false);
  }
  public int countHelper(int row, int count, int n, boolean checked) {
    if (board.length > 0 && row == board.length) count++; // base case
    if (!checked) {  //checks once to see if board is clear
      try{
          for (int[] r : board) {
            for (int c : r) {
              if (c != 0) throw new IllegalStateException();
            }
          }
        checked = true;
      } catch(IllegalStateException e) {
          e.printStackTrace();
      }
    }
    for (int c = 0; c < board.length; c++) {
      if (addQueen(row, c)) { // attempts to addQueen to each row
        int countUpdate = countHelper(row + 1, count, n-1, checked); // checks to see if a solution is made, updates the counter and proceeds to removeQueen and continue
        if (countUpdate > count) count = countUpdate;
        removeQueen(row, c);
      }
    }
    return count; // if no (more) solutions are found, return count
  }
}
