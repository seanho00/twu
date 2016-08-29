/** complex.cpp
 * Demo of complex number class library
 *
 * Sean Ho for CMPT166 exam
 */
#include <fstream>
#include <iostream>
using namespace std;

class Complex {
  private:
    float real, imag;
  public:
    Complex(float r=0., float i=0.) : real(r), imag(i) {};
    const Complex operator+(const Complex& c) {
      return Complex(real + c.real, imag + c.imag);
    }
    const Complex operator-(const Complex& c) {
      return Complex(real - c.real, imag - c.imag);
    }
  friend ostream& operator<<(ostream& output, const Complex& c);
};

// Overload << for text output
ostream& operator<<(ostream& output, const Complex& c) {
  output << "(" << c.real;
  if (c.imag < 0) {
    output << "-" << -c.imag;
  } else {
    output << "+" << c.imag;
  }
  output << "i)";
  return output;	// so we can chain << operators
}

int main() {
  Complex c1(2, -3), c2(1.5, 0.7);
  cout << c1 << " + " << c2 << " = " << c1 + c2 << endl;
  cout << c1 << " - " << c2 << " = " << c1 - c2 << endl;
}
