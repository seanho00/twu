import java.util.concurrent.*;
public class RunnableTester {
  private static int numTasks = 5;
  private static int numThreads = 3;

  public static void main( String args[] ) {

    PrintTask[] tasklist = new PrintTask[numTasks];
    for (int i=0; i<tasklist.length; i++)
      tasklist[i] = new PrintTask( "Task " + i );

    ExecutorService master = Executors.newFixedThreadPool( numThreads );

    for (int i=0; i<tasklist.length; i++)
      master.execute( tasklist[i] );

    master.shutdown();
  }
}
