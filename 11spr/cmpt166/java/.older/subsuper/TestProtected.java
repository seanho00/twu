package SuperPack;
class Super { protected int x = 0; }

package SubPack;
import SuperPack.Super;
class Sub extends Super {
  public void inc() {
    Super mySup = new Super();
    mySup.x++;		// fails
  }
  public String toString() {
    return( "x=" + x );
  }
}

public class TestProtected {
  public static void main( String args[] ) {
    System.out.println("Hello, World!");
    Sub mySub = new Sub();
    mySub.inc();
    System.out.println(mySub.toString());
  }
}
