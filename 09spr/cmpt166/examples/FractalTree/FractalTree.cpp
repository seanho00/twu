/** FractalTree.cpp
 * A test app to demonstrate 2D drawing in FLTK by subclassing FL_Widget
 *
 * Sean Ho for CMPT166
 */

#include "FractalTree.h"
#include <FL/Fl.H>
#include <FL/fl_draw.H>
#include <iostream>	// debugging

void FractalTree::drawBranch(double len) {
  if (len < 2) return;				// quit at 2 pixels

  fl_push_matrix();				// save old transform
  fl_rotate( angle );				// rotate clockwise

  fl_color(FL_RED);
  fl_begin_line();				// draw the branch
  fl_vertex( 0.0, 0.0 );
  fl_vertex( 0.0, -len );
  fl_end_line();

  fl_translate( 0.0, -len );			// move to end of branch
  drawBranch( len * shrink );			// recurse
  fl_pop_matrix();				// back to start

  fl_push_matrix();				// save old transform
  fl_rotate( -angle );				// rotate counterclockwise

  fl_color(FL_BLUE);
  fl_begin_line();				// draw the branch
  fl_vertex( 0.0, 0.0 );
  fl_vertex( 0.0, -len );
  fl_end_line();

  fl_translate( 0.0, -len );			// move to end of branch
  drawBranch( len * shrink );			// recurse
  fl_pop_matrix();				// back to start
}

void FractalTree::draw() {
  Fl_Box::draw();	// first draw the widget as normal

  trunkLen = h()/2;

  fl_color(FL_BLACK);

  fl_push_matrix();
  fl_translate( x()+w()/2, y()+h() );		// middle bottom
  fl_begin_line();				// draw the trunk
  fl_vertex( 0.0, 0.0 );
  fl_vertex( 0.0, -trunkLen );
  fl_end_line();
  fl_translate( 0.0, -trunkLen );		// move to top of trunk

  drawBranch( trunkLen * shrink/2 );		// recurse
  fl_pop_matrix();
}

int FractalTree::handle(int e) {
  switch(e) {
    case FL_PUSH:
    case FL_DRAG:
      if (Fl::event_button() == FL_LEFT_MOUSE) {
	double mx = 1.0*(Fl::event_x() - x())/w();
	double my = 1.0*(Fl::event_y() - y())/h();

	mx = ( (mx<0) ? 0.0 : (mx>1) ? 1.0 : mx);	// clamp to [0,1]
	my = ( (my<0) ? 0.0 : (my>1) ? 1.0 : my);

	angle = 180 * 0.95 * mx;		// degrees
	shrink = my/2 + 0.25;

	damage(1);		// force redraw of whole widget
	redraw();
	return(1);		// we've handled the event
      };
      break;
  }
  return( Fl_Box::handle(e) );
}

