/** ascii.cpp
 * Build a string with all non-null ASCII chars
 *
 * Sean Ho for CMPT166 exam
 */

#include <string>
#include <iostream>
using namespace std;

string ascii(int len) {
  string result = "";
  result.reserve(len);
  for (int i=1; i<=len; i++) {
    result += (char) i;
  }
  return result;
};

int main() {
  cout << "Here are all the ASCII chars (some unprintable):" << endl;
  cout << ascii(127) << endl;
}

