/** A special kind of error relating to students.
 * Demo of user-defined exception classes.
 * @author seanho
 *
 */
public class StudentError extends Exception {
	int studentID = 0;

	public StudentError() {
		super("Error with student");
	}

	public StudentError(String message) {
		super(message);
	}

	public StudentError(int id) {
		this();
		studentID = id;
	}
	
	public StudentError(String message, int id) {
		super(message);
		studentID = id;
	}
	
	public int getID() { return studentID; }
	
	public String getMessage() {
		return super.getMessage() + " (ID=" + getID() + ")";
	}
	
	public String toString() { return getMessage(); }

}
