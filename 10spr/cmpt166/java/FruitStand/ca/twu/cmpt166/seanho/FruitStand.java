/** Fruit Stand Inventory.
 * Keep track of how many of each kind of fruit I have.
 * @author seanho
 */
package ca.twu.cmpt166.seanho;

/** Fruit Stand Inventory.
 * @author seanho
 *
 */
public class FruitStand {
	// Attributes
	protected int numApples = 0;
	protected int numPears = 0;
	protected int numOranges = 0;
	
	// Constructors
	public FruitStand(int apples, int pears, int oranges) {
		setApples(apples);
		setPears(pears);
		setOranges(oranges);
	}
	public FruitStand(int apples, int pears) {
		setApples(apples);
		setPears(pears);
	}
	public FruitStand(int apples) {
		setApples(apples);
	}
	public FruitStand() {
	}
	
	// Public methods: accessors
	public int getApples() { return numApples; }
	public int getPears() { return numPears; }
	public int getOranges() { return numOranges; }
	public String toString() {
		return "There are " + numApples + " apples, " +
		numPears + " pears, and " + numOranges + " oranges.";  
	}
	
	// Public methods: mutators
	public void addApple() { numApples++; }
	public void delApple() { numApples--; }
	
	// Protected methods
	protected boolean setApples(int apples) {
		if (apples >= 0) {
			numApples = apples;
			return true;
		}
		return false;
	}
	protected boolean setPears(int pears) {
		if (pears >= 0) {
			numPears = pears;
			return true;
		}
		return false;
	}
	protected boolean setOranges(int oranges) {
		if (oranges >= 0) {
			numOranges = oranges;
			return true;
		}
		return false;
	}
	
	// Private methods
	
	// Main (optional, test case)
	public static void main(String args[]) {
		FruitStand f1 = new FruitStand(1, 2, 3);
		f1.delApple();
		System.out.println(f1);
	}
}
