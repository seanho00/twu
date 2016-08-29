import java.util.concurrent.*;

class AppleBin {
  int numApples;
  public AppleBin() {
    numApples = 0;
  }
}

public class AddApples implements Runnable {

  private int ID;
  private int inc;
  private static AppleBin myAppleBin;	// shared object

  // Constructor: thread ID number and how many apples we will add
  public AddApples(int taskID) {
    this.ID = taskID;
    this.inc = (int) Math.pow(10., (double) ID);
  }

  // When this thread is run, add apples to the bin several times
  public void run() {
    int sleepTime;
    for (int i=0; i<3; i++) {

      sleepTime = (int) (Math.random() * 1000);
      System.out.println( "Task " + ID + ": sleeping for " + sleepTime + "ms" );
      try {
	Thread.sleep( sleepTime );
      } catch( InterruptedException e ) {
      }

      synchronized (myAppleBin) {

	int oldNumApples = myAppleBin.numApples;	// read from shared obj
	sleepTime = (int) (Math.random() * 1000);
	System.out.println( "Task " + ID + ": "
	    + "I see " + oldNumApples + " apples; "
	    + "after " + sleepTime + "ms, "
	    + "I will add " + inc + " apples." );

	try {
	  Thread.sleep( sleepTime );
	} catch( InterruptedException e ) {
	}

	myAppleBin.numApples = oldNumApples + inc;	// write to shared obj
	System.out.println( "Task " + ID + " ==> "
	    + myAppleBin.numApples + " apples!" );

      }
    }
  }

  public static void main( String[] args ) {

    myAppleBin = new AppleBin();	// new shared object

    AddApples[] taskList = new AddApples[2];		// init tasks
    for (int i=0; i<taskList.length; i++)
      taskList[i] = new AddApples(i);

    ExecutorService executor = Executors.newFixedThreadPool(2);

    for (int i=0; i<taskList.length; i++)		// fire off tasks
      executor.execute( taskList[i] );

    executor.shutdown();
    System.out.println("Master executor is done!");

    try {
      if (executor.awaitTermination( 1, TimeUnit.MINUTES )) {
	System.out.println("All threads have finished.  Goodbye!");
      } else {
	System.out.println("Threads took too long to finish.");
      }
    } catch ( InterruptedException e ) {
      System.out.println("Interrupted while waiting for threads to finish.");
    }
  }
}
