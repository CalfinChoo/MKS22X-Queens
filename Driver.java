public class Driver{
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(8);
    test.solve();
    System.out.println(test.toString());
  }
}
