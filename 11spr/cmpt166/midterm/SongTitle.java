/**
 * Add year to title of song stored in "song.obj".
 * Solution to midterm question.
 *
 * @author Sean Ho
 * @course CMPT 166
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SongTitle {
  public static void main(String args[]) {
    Song theSong = null;

    // Read in song object
    try {
      ObjectInputStream ios = 
	new ObjectInputStream(new FileInputStream("song.obj"));
      theSong = (Song) ios.readObject();
      ios.close();
    } catch (FileNotFoundException e) {
      initFile();
      System.exit(0);
    } catch (IOException e) {
    } catch (ClassNotFoundException e) {
    }

    // Update the song title
    theSong.title += " (" + Integer.toString(theSong.year) + ")";
    System.out.println("Song updated to: " + theSong);

    // Write it back out
    try {
      ObjectOutputStream oos = 
	new ObjectOutputStream(new FileOutputStream("song.obj"));
      oos.writeObject(theSong);
      oos.close();
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
    }
  }

  // Create "song.obj" file (not necessary for exam purposes)
  static public void initFile() {
    Song theSong = new Song();
    System.out.println("Creating song.obj with: " + theSong);
    try {
      ObjectOutputStream oos = 
	new ObjectOutputStream(new FileOutputStream("song.obj"));
      oos.writeObject(theSong);
      oos.close();
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
    }
  }
}
