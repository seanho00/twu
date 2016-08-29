/** scribble.cpp
 * A test app to demonstrate 2D drawing in FLTK by subclassing FL_Widget
 *
 * Sean Ho for CMPT166
 * Based off of Erco's "Draw X" example: http://seriss.com/people/erco/fltk/#FltkX
 */

#include "Sierpinski.h"
#include <FL/Fl.H>
#include <FL/fl_draw.H>
#include <cstdlib>
#include <iostream>
using namespace std;

void Sierpinski::debug() {
  cout << "iters=" << iterations << "; ";
  cout << "corners={ ";
  for (int i=0; i<NUM_CORNERS; i++)
    cout << "(" << corners[i][0] << ", " << corners[i][1] << ") ";
  cout << "}; ";
  cout << "seed=(" << seed[0] << ", " << seed[1] << ")" << endl;
}

int Sierpinski::randx() {
  return x() + (int) (1.0*w()*rand()/RAND_MAX);
}
int Sierpinski::randy() {
  return y() + (int) (1.0*h()*rand()/RAND_MAX);
}

void Sierpinski::chaosGame() {
  delete[] points;
  delete[] colors;

  points = new int[iterations][2];
  colors = (Fl_Color *) new Fl_Color[iterations];

  int curpt[2];
  curpt[0] = seed[0];
  curpt[1] = seed[1];

  for (int i=0; i<iterations; i++) {
    int die = rand()%3;
    for (int xy=0; xy<2; xy++) {
      curpt[xy] += (corners[die][xy] - curpt[xy])/2;
      points[i][xy] = curpt[xy];
    }
    colors[i] = ( die==0 ? FL_RED : (die==1 ? FL_GREEN : FL_BLUE) );
  }
}

void Sierpinski::draw() {
  Fl_Box::draw();	// first draw the widget as normal
  initCorners();
  for (int i=0; i<iterations; i++) {
    fl_color( colors[i] );
    fl_point( points[i][0], points[i][1] );
  }
}

int Sierpinski::handle(int e) {
  switch(e) {
    case FL_PUSH:
    case FL_DRAG:
      if (Fl::event_button() == FL_LEFT_MOUSE) {
	seed[0] = Fl::event_x();
	seed[1] = Fl::event_y();
	chaosGame();
	damage(1);
	redraw();
	return(1);
      };
      break;
  }
  return( Fl_Box::handle(e) );
}

void Sierpinski::initCorners() {
  int l=x(), t=y(), wd=w(), ht=h();
  int cx = l + wd/2, cy = t + ht/2;
  int def_corners[][2] = { {cx, t}, {l, t+ht}, {l+wd, t+ht} };

  for (int i=0; i<NUM_CORNERS; i++) for (int xy=0; xy<2; xy++)
    corners[i][xy] = def_corners[i][xy];
}

void Sierpinski::init() {
  seed[0] = randx();
  seed[1] = randy();
  iterations = 5000;
  initCorners();
  chaosGame();
};

