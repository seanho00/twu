/** scribble.cpp
 * A test app to demonstrate 2D drawing in FLTK by subclassing FL_Widget
 *
 * Sean Ho for CMPT166
 * Based off of Erco's "Draw X" example: http://seriss.com/people/erco/fltk/#FltkX
 */

#include "ScribbleBox.h"
#include <FL/fl_draw.H>
#include <FL/Fl_JPEG_Image.H>

void ScribbleBox::draw() {
  Fl_Box::draw();	// first draw the widget as normal

  fl_color(FL_BLACK);
  int l=x(), t=y(), wd=w(), ht=h();	// constants for our use

  fl_line( l, t, l+wd, t+ht );		// big X
  fl_line( l, t+ht, l+wd, t );

  int cx = l + wd/2, cy = t + ht/2;

  fl_point( cx, cy-10 );		// 10px above centre

  fl_rect( cx+25, cy-25, 100, 50, FL_GREEN );	// right

  fl_color(FL_BLUE);
  fl_polygon( cx-25, cy-25, cx-50, cy, cx, cy );	// left

  fl_color(FL_YELLOW);
  fl_pie( cx-25, cy+25, 50, 100, 225, 315 );	// below

  // Complex shapes
  fl_push_matrix();

  fl_rotate( 30. );
  fl_translate( cx*1.0, cy*1.0 );

  fl_color(FL_DARK_RED);
  fl_begin_polygon();
  fl_vertex( -50., -50. );
  fl_vertex(  50., -50. );
  fl_vertex(  50.,  50. );
  fl_vertex( -50.,  50. );
  fl_end_polygon();

  fl_pop_matrix();

  Fl_JPEG_Image isabel("isabel.jpg");
  isabel.draw(cx+10, cy+10, 100, 100, 160, 160);
#if 0
#endif
}
