class RandList {
  public static void main( String args[] ) {
    double randList[] = new double[20];
    double sum = 0.0;
    for (int i=0; i<20; i++) {
      randList[i] = Math.random();
      sum += randList[i];
    }
    System.out.println( "Sum = " + sum );
  }
}
