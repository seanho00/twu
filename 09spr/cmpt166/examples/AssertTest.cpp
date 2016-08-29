/* AssertTest.cpp
 * Test of <cassert> for design-by-contract
 *
 * Sean Ho for CMPT166
 */

#include <cassert>
#include <vector>
#include <iostream>
using namespace std;

template <typename Elt>
class Stack {
  private:
    vector<Elt> theStack;
  public:
    Stack() {}
    unsigned int size() {
      return theStack.size();
    }
    void push(Elt item) {
      theStack.push_back(item);
      assert( theStack.size() > 0 );
    }
    Elt pop() {
      assert( theStack.size() > 0 );
      Elt item = theStack.back();
      theStack.pop_back();
      return item;
    }
};

int main() {
  Stack<int> myStack;
  myStack.push(5);
  myStack.push(10);
  assert( myStack.size() == 2 );

  int item = myStack.pop();
  assert( item == 10 );

  item = myStack.pop();
  assert( item == 5 );

  myStack.pop();
}
