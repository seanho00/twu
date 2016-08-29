public class Sorter {

  public static void bubbleSort(int array[]) {
    for (int i=array.length-1; i >= 0; i--) {
      for (int j = 0; j<i; j++) {
	if (array[j] > array[j+1]) {	// swap!
	  int temp = array[j];
	  array[j] = array[j+1];
	  array[j+1] = temp;
	}
      }
    }
  }

  public static void main( String[] args ) {
    int ARRAY_LEN = 100;			// can change this
    int[] myArray = new int[ARRAY_LEN];

    for (int i=0; i<myArray.length; i++) 	// fill with random
      myArray[i] = (int) (100 + 900*Math.random());

    System.out.println("Random array: of " + ARRAY_LEN + " 3-digit numbers:");
    for (int i=0; i<myArray.length; i++)
      System.out.print(" " + myArray[i]);
    System.out.println("");

    bubbleSort(myArray);		// sorts in-place

    System.out.println("Sorted:");
    for (int i=0; i<myArray.length; i++)
      System.out.print(" " + myArray[i]);
    System.out.println("");

  }
}

