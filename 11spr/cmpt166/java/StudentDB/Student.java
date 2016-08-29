/** Represents all the data associated with a single student.
 * @author seanho
 *
 */


import java.util.Date;

public class Student {
	private String name;
	private int ID;
	private Date dob;
	
	/* Constructors */
	public Student(String name, int ID, Date dob) throws StudentError {
		setName(name);
		setID(ID);
		setDOB(dob);
	}
	public Student(String name, int ID) throws StudentError { this(name, ID, null);	}
	public Student(String name) throws StudentError { this(name, 0, null); }
	public Student(int ID) throws StudentError { this(null, ID, null); }
	public Student(Date dob) throws StudentError { this(null, 0, dob); }
	public Student() throws StudentError { this(null, 0, null); }
	
	/* Copy constructor */
	public Student(Student other) {
		if (other != null) {
			try {
				setName(other.name);
				setID(other.ID);
				setDOB(other.dob);
			} catch (StudentError e) {
				System.err.println("Error copying Student "
						+ other + ": " + e.getMessage());
			}
		}
	}
	
	/* Getters (accessors) */
	public String getName() { return name; }
	public int getID() { return ID;	}
	public Date getDob() { return dob; }

	/* Setters (mutators) */
	public void setName(String name) {
		if (name != null) {
			this.name = new String(name);
		} else {
			this.name = "";
		}
	}
	public void setID(int ID) throws StudentError {
		if (ID >= 0) {
			this.ID = ID;
		} else {
			throw new StudentError("ID must be positive!");
		}
	}
	public void setDOB(Date dob) {
		if (dob != null) {
			this.dob = new Date(dob.getTime());
		} else {
			this.dob = new Date();		// current time
		}
	}

	@Override
    public String toString() {
		return "Student [name=\"" + name + "\", ID=" + ID + ", dob=\"" + dob +  "\"]";
	}
	
}
