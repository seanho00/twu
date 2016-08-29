/** tee.cpp
 * Usage: ./tee <input file> <output file>
 * Read contents of <input file> and copy it to <output file>, as well as
 * to stdout.
 *
 * Sean Ho for CMPT 166 midterm exam.
 */

#include <string>
#include <iostream>
#include <fstream>
using namespace std;

int main(int argc, char* argv[]) {
  string usage = "Usage: ./tee <input file> <output file>";
  if (argc <= 2) {
    cout << usage << endl;
    return -1;
  }

  ifstream infile(argv[1]);
  ofstream outfile(argv[2]);

  string line;
  while (getline(infile, line)) {
    outfile << line << endl;
    cout << line << endl;
  }

  return 0;
}
