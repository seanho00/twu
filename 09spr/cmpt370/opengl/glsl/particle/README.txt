This is a sample program to demonstrate GLSL vertex and fragment shaders.

=== It consists of:

* particle.c:
  Main program; uses GLUT for GUI (windowing and events)
  Generates initial geometry (vertices)
  Reads in text of vertex and fragment shaders
  Compiles and uses shaders

* vparticle.glsl:
  Vertex shader program: moves vertices according to gravity

* fPassthrough.glsl:
  Fragment shader program: does nothing (normal fragment processing)

=== Dependencies:
* GLEW: for OpenGL extensions, needed for GLSL on Windows
  Includes: glew.h, wglew.h, glxew.h
  Library: glew32.lib (static) or glew32.dll (dynamic)

* GLUT: for windowing, event handling, timers, etc.
  Include: glut.h
  Library: glut32.lib

* OpenGL:
  Include: (not needed if #include <GL/glew.h>)
  Library: glu32.lib, opengl32.lib

=== Tested platform(s):

* Cygwin on Windows, using MingW compiler and Win32 libraries

  + Just run 'make' (theoretically!)

  + Since the binary releases of GLEW appear to be compiled differently
    (using MSVC?), and GLEW is pretty small, we just compile GLEW into
    our program.  The source is in one file (glew.c), in current dir.
    The headers are in the GL/ dir under current dir -- this is so that
    "#include <GL/glew.h>", together with "-I.", will find them.
    We set -DGLEW_STATIC when compiling GLEW.

  + See http://glew.sourceforge.net/install.html for other possible
    options of using GLEW in your program.  You may want to try
    downloading the source distribution and using their Makefile
    to compile GLEW static and shared libraries.

  + I've chosen to link with the native Windows GLUT/OpenGL libraries
    (glut32.lib, glu32.lib, opengl32.lib) instead of Cygwin's FreeGLUT 
    libraries for X11 (glut.lib).  Cygwin has a package for FreeGLUT;
    it is not installed by default.

  + Because we're linking with the native Windows GLUT, we have to
    compile/link with Cygwin's GCC in MingW compatibility mode, without
    Cygwin extensions: gcc -mno-cygwin

* Linux (2.6.28-gentoo-r3), using GCC 4.3.3 and packaged GLEW 1.5

  + I linked with GLUT using -lglut and the regular GL libraries,
    rather than asking fltk-config --use-glut

  + I installed a package for GLEW (using Gentoo's portage)

  + I linked GLEW in statically (/usr/lib/libGLEW.a) to increase the chance
    someone else might be able to run my binary (particle-linux) 
    but dynamic linking works as well.

  + I couldn't actually test it on my system, as GLSL on my laptop's
    i945 graphics chip isn't supported by Mesa OpenGL yet (and the
    hardware wouldn't support vertex shaders anyway).

=== Other notes:

* The sample code uses GLUT because it's simple, but you can swap out
  the GLUT stuff for FLTK if you like.  FLTK also provides a Fl_Glut_Window
  and a <FL/glut.h> to use instead of <GL/glut.h> so you can put a GLUT
  window inside your FLTK application.
  http://fltk.org/doc-1.1/glut.html

