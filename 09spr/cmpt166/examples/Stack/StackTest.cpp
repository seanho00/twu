/** StackTest.cpp
 * Testbed program for the Stack class
 *
 * @author Sean Ho
 * For CMPT166
 */
#include "Stack.h"
#include <iostream>
#include <string>
using namespace std;

int main() {
  string ap1 = "Fuji", ap2 = "Rome", ap3 = "Gala";
  string* top;
  Stack myApples;

  cout << "Push " + ap1 << endl;
  myApples.push(&ap1);

  cout << "Push " + ap2 << endl;
  myApples.push(&ap2);

  top = (string*) myApples.pop();
  cout << "Pop: " << *top << endl;

  cout << "Push " + ap3 << endl;
  myApples.push(&ap3);

  top = (string*) myApples.pop();
  cout << "Pop: " << *top << endl;

  top = (string*) myApples.pop();
  cout << "Pop: " << *top << endl;

}
