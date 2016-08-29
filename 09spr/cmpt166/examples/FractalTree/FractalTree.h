/** FractalTree.h
 *
 * Sean Ho for CMPT166
 */

#ifndef FRACTALTREE_H
#define FRACTALTREE_H
#include <FL/Fl_Box.H>

#define NUM_CORNERS 3

class FractalTree : public Fl_Box {
  private:
    int trunkLen;
    double angle, shrink;

    void drawBranch(double len);
  public:
    FractalTree(int X, int Y, int W, int H, const char* L=0) :
      Fl_Box(X, Y, W, H, L), angle(30.), shrink(2/3.0) {};

    void draw();
    int handle(int e);
};

#endif /* FRACTALTREE_H */
