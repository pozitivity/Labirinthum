/* Very simple fragment shader. It basically passes the
 * (interpolated) vertex color on to the individual pixels.
 */ 
#version 120

varying vec3 l;
varying vec3 h;
varying vec3 n;
varying vec3 v;

void main(void)
{
	const vec4 diffColor = vec4(0.5, 0.0, 0.0, 1.0);
	const vec4 specColor = vec4(0.7, 0.7, 0.0, 1.0);
	const float specPower = 30;
	
	
	vec3 n2 = normalize(n);
	vec3 l2 = normalize(l);
	vec3 h2 = normalize(h);
	vec4 diff = diffColor * max(dot(n2, l2), 0.0);
	vec4 spec = specColor * pow(max(dot(n2, h2), 0.0), specPower);
	 
    gl_FragColor = diff + spec;
    
}