/* 
Fragment Shader 

Has diffuse and specular lights.

Mike Barnes
11/29/07
*/

varying vec3 N, L;

void main() {
   const float specularExp = 128.0;
   vec3 NN = normalize(N);
   vec3 NL = normalize(L);
   // eye is looking (0.0, 0.0, -1.0) 
   vec3 StoE = vec3(0.0, 0.0, 1.0); // vector from surface to eye
   vec3 NH = normalize(NL + StoE);
   float NdotL = max (0.0, dot(NN, NL));
   // set the intensity of the "diffuse" color
   gl_FragColor = gl_Color * max(0.0, dot(NN, NL)); // (normalize(N), normalize(L)));
   if (NdotL > 0.0) // add specularity 
      gl_FragColor.rgb += vec3(1.0, 1.00, 1.00) * 
      pow(max(0.0, dot(NN, NH)), specularExp);
   gl_FragColor.a = gl_Color.a;  // reset the alpha
   }