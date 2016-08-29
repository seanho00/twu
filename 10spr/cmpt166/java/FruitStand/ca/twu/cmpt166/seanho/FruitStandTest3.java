/** JUnit3 test framework for FruitStand
 * This file uses JUnit version 3.
 */
package ca.twu.cmpt166.seanho;

import junit.framework.TestCase;

/** Container for JUnit test cases
 * @author seanho
 *
 */
public class FruitStandTest3 extends TestCase {

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand(int, int, int)}.
	 */
	public void testFruitStandIntIntInt() {
		// valid input
		FruitStand f1 = new FruitStand(2, 2, 2);
		assertTrue( f1.getOranges() == 2 );
		
		// invalid input: oranges < 0
		FruitStand f2 = new FruitStand(2, 2, -2);
		assertTrue( f2.getOranges() == 0 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand(int, int)}.
	 */
	public void testFruitStandIntInt() {
		FruitStand f1 = new FruitStand(2, 2);
		assertTrue( f1.getPears() == 2 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand(int)}.
	 */
	public void testFruitStandInt() {
		FruitStand f1 = new FruitStand(2);
		assertTrue( f1.getApples() == 2 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand()}.
	 */
	public void testFruitStand() {
		FruitStand f1 = new FruitStand();
		assertTrue( f1.getApples() == 0 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#getApples()}.
	 */
	public void testGetApples() {
		FruitStand f1 = new FruitStand(3);
		assertTrue( f1.getApples() == 3 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#getPears()}.
	 */
	public void testGetPears() {
		FruitStand f1 = new FruitStand(1, 3);
		assertTrue( f1.getPears() == 3 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#getOranges()}.
	 */
	public void testGetOranges() {
		FruitStand f1 = new FruitStand(1, 2, 3);
		assertTrue( f1.getOranges() == 3 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#toString()}.
	 */
	public void testToString() {
		FruitStand f1 = new FruitStand(1, 2, 3);
		assertTrue( f1.toString().equals("There are 1 apples, 2 pears, and 3 oranges.") );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#addApple()}.
	 */
	public void testAddApple() {
		FruitStand f1 = new FruitStand(3);
		f1.addApple();
		assertTrue( f1.getApples() == 4 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#delApple()}.
	 */
	public void testDelApple() {
		FruitStand f1 = new FruitStand(3);
		f1.delApple();
		assertTrue( f1.getApples() == 2 );
	}
}
