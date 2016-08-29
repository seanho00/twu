/**
 * exceptiontest.cpp
 *
 * Show off C++ exceptions.
 *
 * @author Sean Ho for CMPT 166
 */

#include <iostream>
using namespace std;

namespace {		// local binding
  class Trouble {			// superclass
    public:
      const char* const name;
      Trouble(const char* const n=0) : name(n) {}
  };

  class Big : public Trouble {		// subclass
    public:
      Big(const char* const n=0) : Trouble(n) {}
  };

  class TooMuch : public Trouble {	// subclass
    public:
      TooMuch(const char* const n=0) : Trouble(n) {}
  };

  void fun() {
    throw TooMuch("fun");
  }
}

int main() {
  try {
    fun();
  } catch(Trouble& t) {
    cout << "caught Trouble: " << t.name << endl;
  } catch(Big& t) {
    cout << "caught Big Trouble: " << t.name << endl;
  } catch(TooMuch& t) {
    cout << "caught TooMuch Trouble: " << t.name << endl;
  }
}

