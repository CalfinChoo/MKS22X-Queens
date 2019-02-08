public class Driver{
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(8);
    test.addQueen(0, 3);
    System.out.print(test.toString());
  }
}
