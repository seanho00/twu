/**
 * Frequency table and histogram on lists of integers.
 * Only works for integers between 0 and 99.
 *
 * @author Sean Ho
 * @course CMPT 166
 */

import java.text.DecimalFormat;

public class FreqTable {
  private static final int MAXVAL = 100;
  private int numvals;
  private int freqs[];

  FreqTable(int list[]) {
    freqs = new int[MAXVAL];
    for (int i=0; i<freqs.length; i++)
      freqs[i] = 0;
    for (int i=0; i<list.length; i++)
      freqs[list[i]]++;
  }

  String showFreqs() {
    DecimalFormat fmt = new DecimalFormat("00");
    String output = "Val Freq\n";
    for (int i=0; i<freqs.length; i++) {
      if (freqs[i] > 0) {
	output += fmt.format(i);
	output += ": ";
	output += freqs[i];
	output += "\n";
      }
    }
    return output;
  }

  // testbed not necessary for midterm exam
  public static void main(String args[]) {
    int myList[] = new int[100];
    for (int i=0; i<myList.length; i++)
      myList[i] = (int) (Math.random()*MAXVAL);

    FreqTable myFreqTable = new FreqTable(myList);
    System.out.print(myFreqTable.showFreqs());
  }
}
