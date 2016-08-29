/** badness.cpp
 * Demo of throwing and catching exceptions
 *
 * Sean Ho for CMPT166 midterm exam
 */

#include <iostream>
using namespace std;

class Badness {
  private:
    int level;
  public:
    Badness(int l=0) : level(l) {};
    int howbad() { return level; }
};

int main() {
  try {
    throw Badness(100);
  } catch( Badness& b ) {
    cout << "caught Badness of level " << b.howbad() << endl;
  }
}
