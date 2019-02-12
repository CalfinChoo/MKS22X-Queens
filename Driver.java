public class Driver{
  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(6);
    //test.solve();
    //System.out.println(test.solve());
    System.out.println(test.countSolutions());
    //test.addQueen(3,2);
    System.out.println(test.toString());
  }
}
