/* Very simple vertex shader that applies the model view
 * and projection matrix to the given vertex and overrides
 * the color with a constant for all vertices. 
 */
#version 120
 
varying vec3 l;
varying vec3 h;
varying vec3 n;
varying vec3 v;

uniform vec4 lightPos;
uniform vec4 eyePos;
 
void main(void)
{
	vec3 p = vec3(gl_ModelViewMatrix * gl_Vertex);
	
	l = normalize(vec3(lightPos) - p);
	
	v = normalize(vec3(eyePos) - p);
	h = normalize(l + v);
	
	n = normalize(gl_NormalMatrix * gl_Normal);
	gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
}