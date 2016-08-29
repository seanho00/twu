/*
 * PhongTeapot.c
 * Based on GLSLexample.cpp by Mike Barnes 11/29/07
 * Sean Ho for CMPT370

Uses very simple vertex and fragment shaders to display a teapot.
Shows the structure of an OpenGL program with shaders.
Shows how to get information from compiling shaders.

Demo starts using shaders. 
Pressing 'f' selects the fixed functional pipeline
Pressing 's' selects the programmable pipeline

The fragment shader is minimal, so the in this "odd" case the
fixed functional pipeline looks better.

Based on code fragments from: 
   Interactive Computer Graphics: A Top Down Approach Using OpenGL, 
      E. Angel, 2006.
   OpenGL: SuperBible 4th edition, R. S. Wright, B. Lipchak, N. Haemel, 
      Addison-Wesley, 2007 

Visual Studio .NET 2005 project properties:
Menu Project | Properties |Linker | Input  
   set "Additional Dependencies" to Glee.lib
   set "Ignore Specific Library" to LIBC.lib 

Note:  The shader program source files ("vCalcNormal.glsl","fPhongShading.glsl")
must be in the same directory as the executable.
*/

#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <GL/glew.h>
#include <GL/glut.h>

#define MAX_INFO_LOG_SIZE 2048

const float nearVal     = 1.0f;
const float farVal      = 300.0f;
const float lightPos[3] = {3.0f, 3.0f, 3.0f};

int width  = 512;
int height = 512;

GLint program = 0;

/* Load shader from disk into a null-terminated string */
char *readShaderSource(const char *fileName) {
   GLchar *shaderText = NULL;
   GLint shaderLength = 0;
   FILE *fp;

   fp = fopen(fileName, "r");
   if (fp != NULL) {
      while (fgetc(fp) != EOF) shaderLength++;     
      rewind(fp);
      shaderText = (GLchar *) malloc(shaderLength+1);
      if (shaderText != NULL) fread(shaderText, 1, shaderLength, fp);      
      shaderText[shaderLength] = '\0';  // NULL termination
      fclose(fp);
      }
   return shaderText;
}

/* check create calls */
void checkCreate(GLint object, char * msg) {
   if (object == 0) printf("Failed:  create %s \n", msg);
   else printf("Success:  create %s\n", msg);
}

/* check and report status of GLSL functions */
void checkStatus(GLint object, GLint status, char * msg) {
   if(! status) {
      GLchar infoLog[MAX_INFO_LOG_SIZE];
      glGetShaderInfoLog(object, MAX_INFO_LOG_SIZE, NULL, infoLog);   
      printf("Failed:  %s\n", msg);
      printf("Info log:  %s\n", infoLog);
      /* exit(EXIT_FAILURE); */
      }
      else printf("Success:  %s\n", msg);
   }

/* standard OpenGL initialization */
static void init() {
   const float teapotColor[]     = {0.3f, 0.5f, 0.4f, 1.0f};
   const float teapotSpecular[]  = {0.8f, 0.8f, 0.8f, 1.0f};
   const float teapotShininess[] = {80.0f};

   glMaterialfv(GL_FRONT, GL_AMBIENT_AND_DIFFUSE, teapotColor);
   glMaterialfv(GL_FRONT, GL_SPECULAR, teapotSpecular);
   glMaterialfv(GL_FRONT, GL_SHININESS, teapotShininess);

   glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

   glMatrixMode(GL_MODELVIEW);
   glLoadIdentity();

   glLightfv(GL_LIGHT0, GL_POSITION, lightPos);
   glEnable(GL_LIGHTING);
   glEnable(GL_LIGHT0);
   glEnable(GL_DEPTH_TEST);
}

/* GLSL initialization  */
static void initShader(const GLchar* vShaderFile, const GLchar* fShaderFile) {

   GLint vShader = 0;
   GLint fShader = 0;
   GLint status = 0;

   /* read shader files -- make null terminated strings */
   GLchar* vSource = readShaderSource(vShaderFile);
   GLchar* fSource = readShaderSource(fShaderFile);

   /* create program and shaders */
   vShader = glCreateShader(GL_VERTEX_SHADER);
   checkCreate(vShader, "vShader");
   fShader = glCreateShader(GL_FRAGMENT_SHADER);
   checkCreate(fShader, "fShader");

   program = glCreateProgram();
   checkCreate(program, "program");

   /* attach shaders to program */
   glAttachShader(program, vShader);
   printf("attach vShader\n");
   glAttachShader(program, fShader);
   printf("attach fShader\n");

   /* read shader source */
   glShaderSource(vShader, 1, (const GLchar**) &vSource, NULL); 
   printf("read vShader source \n");   
   glShaderSource(fShader, 1,  (const GLchar**) &fSource, NULL); 
   printf("read fShader source\n");   

   /* compile shaders */
   glCompileShader(vShader);
   glGetShaderiv(vShader, GL_COMPILE_STATUS, &status);
   checkStatus(vShader, status, "vShader compile");
   
   glCompileShader(fShader);
   glGetShaderiv(fShader, GL_COMPILE_STATUS, &status);
   checkStatus(fShader, status, "fShader compile");

   /* link program */
   glLinkProgram(program);
   glGetProgramiv(program, GL_LINK_STATUS, &status);
   checkStatus(program, status, "linking");

   glValidateProgram(program);
   glGetProgramiv(program, GL_VALIDATE_STATUS, &status);
   checkStatus(program, status, "validation");
   
   /* glUseProgram(program); */
}

static void draw()  {
   glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

   glMatrixMode(GL_MODELVIEW);
   glLoadIdentity();

   gluLookAt(
      0.0f, 0.0f, 10.0f,
      0.0f, 0.0f, 0.0f,
      0.0f, 1.0f, 0.0f);

   glTranslatef(0.0f, 0.0f, -2.0f);
   glutSolidTeapot(2.0);
   glutSwapBuffers();
}

static void reshape(int w, int h)  {
   width  = w;
   height = h;

   glMatrixMode(GL_PROJECTION);
   glLoadIdentity();
   gluPerspective(45.0, (double)width / (double)height, nearVal, farVal);
   glutPostRedisplay();
}

static void keyboard(unsigned char key, int x, int y) {
   switch (key) {
      case 27:
      case 'Q':
      case 'q':
         exit(EXIT_SUCCESS);
         break;
      case 'f' : 
         glUseProgram(0);
         printf("fixed pipeline\n");
         glutPostRedisplay();
         break;
      case 's':
         glUseProgram(program); 
         printf("programed pipeline\n");
         glutPostRedisplay();
         break;   
      default:
         break;
      }
   }


int main(int argc, char** argv) {
   glutInit(&argc, argv);
   glutInitDisplayMode(GLUT_RGBA | GLUT_DOUBLE | GLUT_DEPTH);
   glutInitWindowSize(width, height);
   glutCreateWindow("GLSL example");
   glutDisplayFunc(draw);
   glutReshapeFunc(reshape);
   glutKeyboardFunc(keyboard);

   init();

    GLenum err = glewInit();
    if (err != GLEW_OK) {
      fprintf(stderr, "glewInit() failed: %s\n", glewGetErrorString(err));
    } else {
      fprintf(stdout, "Using GLEW %s\n", glewGetString(GLEW_VERSION));
    }

   initShader("vCalcNormal.glsl","fPhongShading.glsl");
   glutMainLoop();
}
