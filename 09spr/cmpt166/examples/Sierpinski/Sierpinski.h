/** ScribbleBox.h
 * Header for ScribbleBox, custom subclass of Fl_Box
 *
 * Sean Ho for CMPT166
 */

#ifndef SIERPINSKI_H
#define SIERPINSKI_H
#include <FL/Fl_Box.H>

#define NUM_CORNERS 3

class Sierpinski : public Fl_Box {
  private:
    int seed[2];
    int corners[NUM_CORNERS][2];
    int iterations;
    int (*points)[2];
    Fl_Color* colors;

    void debug();
    int randx();
    int randy();
    void chaosGame();
    void init();
    void initCorners();
  public:
    Sierpinski(int X, int Y, int W, int H, const char* L=0) :
      Fl_Box(X, Y, W, H, L) { init(); };

    void draw();
    int handle(int e);
};

#endif /* SIERPINSKI_H */
