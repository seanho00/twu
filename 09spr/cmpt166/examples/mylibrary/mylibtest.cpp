/**
 * mylibtest.cpp
 *
 * Sample to demonstrate header files and #include
 * @author Sean Ho
 */

#include <iostream>
#include "mylibrary.h"

using namespace std;

int main() {
  cout << "I start with " << numApples << " apples."
    << endl;

  numApples = double_me(numApples);

  cout << "Now I have " << numApples << " apples."
    << endl;
}

