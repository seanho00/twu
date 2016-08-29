/** JUnit test framework for FruitStand.
 * This file uses JUnit version 4.
 */
package ca.twu.cmpt166.seanho;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author seanho
 *
 */
public class FruitStandTest {

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand(int, int, int)}.
	 */
	@Test
	public void testFruitStandIntIntInt() {
		// valid input
		FruitStand f1 = new FruitStand(2, 2, 2);
		assertEquals( f1.getOranges(), 2 );
		
		// invalid input: oranges < 0
		FruitStand f2 = new FruitStand(2, 2, -2);
		assertEquals( f2.getOranges(), 0 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand(int, int)}.
	 */
	@Test
	public void testFruitStandIntInt() {
		FruitStand f1 = new FruitStand(2, 2);
		assertEquals( f1.getPears(),  2 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand(int)}.
	 */
	@Test
	public void testFruitStandInt() {
		FruitStand f1 = new FruitStand(2);
		assertEquals( f1.getApples(),  2 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand()}.
	 */
	@Test
	public void testFruitStand() {
		FruitStand f1 = new FruitStand();
		assertEquals( f1.getApples(), 0 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#getApples()}.
	 */
	@Test
	public void testGetApples() {
		FruitStand f1 = new FruitStand(3);
		assertEquals( f1.getApples(), 3 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#getPears()}.
	 */
	@Test
	public void testGetPears() {
		FruitStand f1 = new FruitStand(1, 3);
		assertEquals( f1.getPears(), 3 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#getOranges()}.
	 */
	@Test
	public void testGetOranges() {
		FruitStand f1 = new FruitStand(1, 2, 3);
		assertEquals( f1.getOranges(), 3 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#toString()}.
	 */
	@Test
	public void testToString() {
		FruitStand f1 = new FruitStand(1, 2, 3);
		assertEquals( f1.toString(), "There are 1 apples, 2 pears, and 3 oranges.");
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#addApple()}.
	 */
	@Test
	public void testAddApple() {
		FruitStand f1 = new FruitStand(3);
		f1.addApple();
		assertEquals( f1.getApples(), 4 );
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#delApple()}.
	 */
	@Test
	public void testDelApple() {
		FruitStand f1 = new FruitStand(3);
		f1.delApple();
		assertEquals( f1.getApples(), 2 );
	}

}
