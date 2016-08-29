/**
 * Stores info on a song.
 * Solution to midterm exam question.
 * @author Sean Ho
 */

import java.io.Serializable;

public class Song implements Serializable {
  String title;
  String artist;
  int year;

  public Song( String title, String artist, int year ) {
    if (title == null) title = "Amazing Grace";
    if (artist == null) artist = "John Newton";
    this.title = title;
    this.artist = artist;
    this.year = year;
  }

  public Song() { this( null, null, 1779 ); }

  public Song( Song other ) {
    if (other == null) {
      this.title = "Amazing Grace";
      this.artist = "John Newton";
      this.year = 2011;
    } else {
      this.title = other.title;
      this.artist = other.artist;
      this.year = other.year;
    }
  }

  @Override
  public String toString() {
    return this.artist + ", \"" + this.title + "\" (" + this.year + ")";
  }

}
