/**
 * 
 */
package ca.twu.cmpt166.seanho;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author seanho
 *
 */
public class FruitStandTest extends FruitStand {

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand(int, int, int)}.
	 */
	@Test
	public void testFruitStandIntIntInt() {
		FruitStand myStand = new FruitStand(2, 3, 5);
		assertEquals(myStand.numApples, 2);
		assertEquals(myStand.numPears, 3);
		assertEquals(myStand.numOranges, 5);
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand(int, int)}.
	 */
	@Test
	public void testFruitStandIntInt() {
		FruitStand myStand = new FruitStand(2, 3);
		assertEquals(myStand.numApples, 2);
		assertEquals(myStand.numPears, 3);
		assertEquals(myStand.numOranges, 0);
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand(int)}.
	 */
	@Test
	public void testFruitStandInt() {
		FruitStand myStand = new FruitStand(2);
		assertEquals(myStand.numApples, 2);
		assertEquals(myStand.numPears, 0);
		assertEquals(myStand.numOranges, 0);
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand()}.
	 */
	@Test
	public void testFruitStand() {
		FruitStand myStand = new FruitStand();
		assertEquals(myStand.numApples, 0);
		assertEquals(myStand.numPears, 0);
		assertEquals(myStand.numOranges, 0);
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#FruitStand(ca.twu.cmpt166.seanho.FruitStand)}.
	 */
	@Test
	public void testFruitStandFruitStand() {
		FruitStand myStand = new FruitStand(2, 3, 5);
		FruitStand yrStand = new FruitStand(myStand);
		myStand.numApples = 7;					// check yrStand is a copy not an alias
		myStand.numPears = 9;
		myStand.numOranges = 11;
		assertEquals(yrStand.numApples, 2);
		assertEquals(yrStand.numPears, 3);
		assertEquals(yrStand.numOranges, 5);
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#getApples()}.
	 */
	@Test
	public void testGetApples() {
		FruitStand myStand = new FruitStand(2, 3, 5);
		myStand.numApples = 7;
		assertEquals(myStand.getApples(), 7);
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#getPears()}.
	 */
	@Test
	public void testGetPears() {
		FruitStand myStand = new FruitStand(2, 3, 5);
		myStand.numPears = 7;
		assertEquals(myStand.getPears(), 7);
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#getOranges()}.
	 */
	@Test
	public void testGetOranges() {
		FruitStand myStand = new FruitStand(2, 3, 5);
		myStand.numOranges = 7;
		assertEquals(myStand.getOranges(), 7);
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#toString()}.
	 */
	@Test
	public void testToString() {
		FruitStand myStand = new FruitStand(2, 3, 5);
		assertEquals(myStand.toString(), "There are 2 apples, 3 pears, and 5 oranges.");
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#addApple()}.
	 */
	@Test
	public void testAddApple() {
		FruitStand myStand = new FruitStand(2, 3, 5);
		assertTrue(myStand.addApple());
		assertEquals(myStand.numApples, 3);
	}

	/**
	 * Test method for {@link ca.twu.cmpt166.seanho.FruitStand#delApple()}.
	 */
	@Test
	public void testDelApple() {
		FruitStand myStand = new FruitStand(2, 3, 5);
		assertTrue(myStand.delApple());
		assertEquals(myStand.numApples, 1);
		assertTrue(myStand.delApple());
		assertEquals(myStand.numApples, 0);
		assertFalse(myStand.delApple());
		assertEquals(myStand.numApples, 0);
	}

}
