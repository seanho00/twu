import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/* JUnit test bed */
public class StudentTest {
	
	private Student joe;
	private final String joeName = "Joe Smith";
	private final int joeID = 5678;
	private Date joeDOB;

	/* Test fixture: common setup for all tests */
	@Before
	public void setUp() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		joeDOB = sdf.parse("1990-02-28");
		joe = new Student(joeName, joeID, joeDOB);
	}

	/* Test fixture: common setup for all tests */
	@After
	public void tearDown() throws Exception {
		joe = null;		// not really necessary
	}

	/* joe was created using the 3-param constructor: make sure joe is right */
	@Test
	public void testStudentStringIntDate() {
		assertEquals(joe.getName(), joeName);
		assertEquals(joe.getID(), joeID);
		assertTrue(joe.getDob().equals(joeDOB));
	}

	@Test
	public void testStudentStringInt() throws StudentError {
		Student bob = new Student(joeName, joeID);		// DOB is current time
		assertEquals(bob.getName(), joeName);
		assertEquals(bob.getID(), joeID);
		assertTrue(bob.getDob().equals(new Date()));	// cheezy bad test
		assertTrue(bob.getDob().after(joeDOB));
	}

	@Test
	public void testStudentString() throws StudentError {
		Student bob = new Student(joeName);				// ID=0, DOB is current time
		assertEquals(bob.getName(), joeName);
		assertEquals(bob.getID(), 0);
		assertTrue(bob.getDob().equals(new Date()));	// cheezy bad test
		assertTrue(bob.getDob().after(joeDOB));
	}

	@Test
	public void testStudentInt() throws StudentError {
		Student bob = new Student(joeID);				// name='', DOB is current time
		assertEquals(bob.getName(), "");
		assertEquals(bob.getID(), joeID);
		assertTrue(bob.getDob().equals(new Date()));	// cheezy bad test
		assertTrue(bob.getDob().after(joeDOB));
	}

	@Test
	public void testStudentDate() throws StudentError {
		Student bob = new Student(joeDOB);				// name='', ID=0
		assertEquals(bob.getName(), "");
		assertEquals(bob.getID(), 0);
		assertTrue(bob.getDob().equals(joeDOB));
	}

	@Test
	public void testStudent() throws StudentError {
		Student bob = new Student();
		assertEquals(bob.getName(), "");
		assertEquals(bob.getID(), 0);
		assertTrue(bob.getDob().equals(new Date()));	// cheezy bad test
		assertTrue(bob.getDob().after(joeDOB));
	}

	@Test
	public void testStudentStudent() {
		Student bob = new Student(joe);
		assertEquals(bob.getName(), joe.getName());
		assertEquals(bob.getID(), joe.getID());
		assertTrue(bob.getDob().equals(joe.getDob()));
	}

	@Test
	public void testGetName() {
		assertEquals(joe.getName(), joeName);
	}

	@Test
	public void testGetID() {
		assertEquals(joe.getID(), joeID);
	}

	@Test
	public void testGetDob() {
		assertTrue(joe.getDob().equals(joeDOB));
	}

	@Test
	public void testSetName() {
		joe.setName("Josephine");
		assertEquals(joe.getName(), "Josephine");
	}

	@Test
	public void testSetID() throws StudentError {
		joe.setID(6789);
		assertEquals(joe.getID(), 6789);
	}
	
	@Test(expected=StudentError.class)
	public void testSetIDNeg() throws StudentError {
		joe.setID(-1);
	}

	@Test
	public void testSetDOB() {
		joe.setDOB(new Date());
		assertTrue(joe.getDob().after(joeDOB));
	}

	@Test
	public void testToString() {
		assertEquals(joe.toString(), "Student [name=\"Joe Smith\", ID=5678, dob=\"Wed Feb 28 00:00:00 PST 1990\"]");
	}

}
