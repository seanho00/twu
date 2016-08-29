/* 
Vertex Shader 

Changes color, so programmable pipeline teapot is 
blue and fixed functional pipeline teapot is green.

Mike Barnes
11/27/07
*/

varying vec3 N, L;

void main() {
   gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
   N = gl_NormalMatrix * gl_Normal;  // get normal
   L = gl_LightSource[0].position.xyz; // get light position
   gl_FrontColor = vec4(0.5, 0.5, 0.8, 1.0); //change color in shader
   }