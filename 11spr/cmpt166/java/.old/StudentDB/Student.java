/** Represents all the data associated with a single student.
 * @author seanho
 *
 */
import java.util.Date;
public class Student {
	private String name;
	private int ID;
	private Date dob;
	

	public Student(String name, int ID, Date dob) {
		this.name = name;
		this.ID = ID;
		this.dob = dob;
	}
	public Student(String name, int ID) { this(name, ID, null);	}
	public Student(String name) { this(name, 0, null); }
	public Student(int ID) { this(null, ID, null); }
	public Student(Date dob) { this(null, 0, dob); }
	public Student() { this(null, 0, null); }
	
	public String getName() { return name; }
	public int getID() { return ID;	}
	public Date getDob() { return dob; }

	public void setName(String name) {
		if (name != null) {
			this.name = name;
		} else {
			this.name = "";
		}
	}
	public void setID(int ID) throws StudentError {
		if (ID >= 0) {
			this.ID = ID;
		} else {
			this.ID = 0;
			throw new StudentError("invalid ID", ID);
		}
	}
	public void setDOB(Date dob) {
		if (dob != null) {
			this.dob = dob;
		} else {
			this.dob = new Date();		// current time
		}
	}

	public String toString() {
		return "Student [name=\"" + name + "\", ID=" + ID + ", dob=\"" + dob +  "\"]";
	}
	
}
