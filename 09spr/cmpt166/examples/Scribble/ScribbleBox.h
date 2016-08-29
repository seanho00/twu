/** ScribbleBox.h
 * Header for ScribbleBox, custom subclass of Fl_Box
 *
 * Sean Ho for CMPT166
 */

#ifndef SCRIBBLEBOX_H
#define SCRIBBLEBOX_H
#include <FL/Fl_Box.H>

class ScribbleBox : public Fl_Box {
  public:
    ScribbleBox(int X, int Y, int W, int H, const char* L=0) :
      Fl_Box(X, Y, W, H, L) { };

    void draw();
};

#endif /* SCRIBBLEBOX_H */
