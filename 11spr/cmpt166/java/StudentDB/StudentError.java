/** A special kind of error relating to students.
 * Demo of user-defined exception classes.
 * @author seanho
 *
 */
public class StudentError extends Exception {
	private static final long serialVersionUID = 1L;		// for Serializable
	int studentID = 0;

	/* Constructors */
	public StudentError() { super("Student Error"); }
	public StudentError(String message) { super(message); }
	public StudentError(int id) {
		this();
		studentID = id;
	}
	public StudentError(String message, int id) {
		super(message);
		studentID = id;
	}
	
	/* Getters */
	public int getID() { return studentID; }
	@Override
    public String getMessage() {
		return super.getMessage() + " (ID=" + getID() + ")";
	}
	@Override
    public String toString() { return getMessage(); }

}
