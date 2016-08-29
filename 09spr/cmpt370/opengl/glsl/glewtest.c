/**
 * This is simple program to test Your extensions.
 * Mateusz http://www.quanticode.com/forum/phpBB3/viewtopic.php?f=4&t=66
 *
* Compile with
* gcc test.c -o test -lglut -lGL -lGLU -lX11 -lXmu -lXi -lm -lGLEW
*
* Here it works with GL_ARB_shading_language_100, however 
* GL_ARB_shading_language_120 does not compile with mesa 7.0.4 looks like 
* mesa is missing this. Not sure why glxinfo shows its available.
* While complained by game "missing" GL_ARB_vertex_buffer_object is present 
* and works.
*/

#include <GL/glew.h>
#include <GL/glut.h>
#include <stdlib.h>
#include <stdio.h>

int mainWindow;

int main(int argc, char **argv) {

  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_DEPTH | GLUT_DOUBLE | GLUT_RGBA);
  glutInitWindowPosition(100,100);
  glutInitWindowSize(200,200);
  mainWindow = glutCreateWindow("Test");

  glewInit();
  if (GLEW_ARB_vertex_shader &&
      GLEW_ARB_fragment_shader &&
      GL_ARB_vertex_buffer_object &&
      GL_ARB_shading_language_100) {

    char *glslVer = glGetString(GL_SHADING_LANGUAGE_VERSION);
    if(strstr(glslVer,"1.10") != NULL || strstr(glslVer,"1.20") != NULL) {
      printf("GLSL version is %s\n", glslVer);
      printf("Supported OpenGL extensions:\n");
      char *list = glGetString(GL_EXTENSIONS);
      char *token;
      token = strtok (list," ,.-");

      while (token != NULL){
	printf ("%s\n",token);
	token = strtok (NULL, " ,.-");
      }

    } else {
      printf("GLSL not 1.10 or 1.20 versions\n");
      exit(1);
    }

  } else {
    printf("GLSL not supported by mesa\n");
    exit(1);
  }
  glutMainLoop();
}

