import java.util.Random;
class PrintTask implements Runnable {
  private int sleepTime;
  private String name;
  private static Random gen = new Random();
  public PrintTask( String name ) {
    this.name = name;
    this.sleepTime = gen.nextInt( 5000 );
  }
  public void run() {
    System.out.println( name + ": good night!" );
    try {
      Thread.sleep( sleepTime );
    } catch( InterruptedException e ) {
    }
    System.out.println( name  + ": good morning, after " +
	this.sleepTime + "ms!" );
  }
}
