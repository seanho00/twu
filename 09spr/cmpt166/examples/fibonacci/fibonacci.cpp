/**
 * fibonacci.cpp
 *
 * Every time the fib() function is called,
 * get the next Fibonacci number.
 *
 * @author CMPT 166
 */

#include <iostream>
using namespace std;

unsigned long int fib() {
  // Fill this in
  long int cur;
  static long int prev = 1;
  static long int prevPrev = 0;

  cur = prev + prevPrev;

  prevPrev = prev;
  prev = cur;

  return cur;
}

int main() {
  cout << "Here are some Fibonacci numbers: ";
  for (int i=0; i<100; i++) {
    cout << fib() << " ";
  }
  cout << endl;
}

