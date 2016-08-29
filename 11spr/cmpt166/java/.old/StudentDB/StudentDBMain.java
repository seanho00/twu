/** Main program starts from here.
 * @author seanho
 *
 */
public class StudentDBMain {

	/** This is where all the action starts.
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create a list of empty students
		Student[] classList = new Student[10];
		for (int i=0; i<classList.length; i++) {
			classList[i] = new Student();
		}
		
		try {
			
			// Set the first student to be Joe
			classList[0].setName("Joe Smith");
			classList[0].setID(3910);
			System.out.println("Student 0: " + classList[0]);
			
			// Throw an exception manually
//			throw new StudentError(1234);

			// Set invalid ID (and raise exception)
			classList[0].setID(-5018);
			System.out.println("Student 0: " + classList[0]);
			
		} catch (StudentError e) {
			
			System.out.println("Sorry, " + e.getMessage());
			
		}

	}

}
