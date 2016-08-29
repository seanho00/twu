#include <cstdlib>
#include <iostream>
using namespace std;

void move(char from, char to) {
  cout << "move " << from << " --> " << to << endl;
}

void dohanoi(int numdisks, char from, char to, char temp) {
  if (numdisks <= 0) return;
  dohanoi(numdisks-1, from, temp, to);
  move(from, to);
  dohanoi(numdisks-1, temp, to, from);
}

int main (int argc, char** argv) {
  if (argc < 2) {
    cout << "Usage: hanoi <numdisks>" << endl;
    return 1;
  }

  int numdisks = atoi(argv[1]);
  dohanoi(numdisks, 'X', 'Y', 'Z');
}
