// Grapher.js
// Vertex shader program
var gl, canvas;
var n = 16; //the number of vertices
var length = 3*n*n; //length of the vertices array
var lengthT = 6*(n-1)*(n-1); //length of the triangles array
var vertices = new Float32Array(length);
var triangles = new Uint16Array(lengthT);
var lines;
var vertexBuffer, triangleBuffer, linesBuffer;
var rotateX, rotateY, rotateZ;

var VSHADER_SOURCE =
  'uniform mat4 Model;\n' +
  'uniform mat4 Projection;\n' +
  'attribute vec4 vPosition;\n' +
  'varying mediump vec4 v_Color;\n' +
  'void main() {\n' +
  '  gl_Position = Projection * Model * vPosition;\n' +
  '  v_Color = (vPosition + 1.0) / 2.0;\n' +
  '}\n';

var FSHADER_SOURCE =
  'uniform mediump vec4 Light;\n' +
  'varying mediump vec4 v_Color;\n' +
  'void main() {\n' +
  '  gl_FragColor = Light * v_Color;\n' +
  '}\n';

function main() {

  canvas = document.getElementById('webgl');
  
  gl = getWebGLContext(canvas, false);

  initShaders(gl, VSHADER_SOURCE, FSHADER_SOURCE);
 
  generate();

  vertexBuffer = gl.createBuffer();
  triangleBuffer = gl.createBuffer();
  lineBuffer = gl.createBuffer();

  gl.bindBuffer(gl.ARRAY_BUFFER, vertexBuffer);
  gl.bufferData(gl.ARRAY_BUFFER, vertices, gl.STATIC_DRAW);

  gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, triangleBuffer);
  gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, triangles, gl.STATIC_DRAW);
	
  gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, lineBuffer);
  gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, lines, gl.STATIC_DRAW);
	
  var vPositionLocation = gl.getAttribLocation(gl.program, 'vPosition');

  gl.vertexAttribPointer(vPositionLocation, 3, gl.FLOAT, false, 0, 0);

  gl.enableVertexAttribArray(vPositionLocation);

  // Specify the color for clearing <canvas>
  gl.clearColor(0.0, 0.0, 0.0, 1.0);

  // Clear <canvas>
  gl.clear(gl.COLOR_BUFFER_BIT);

  //enable depth test
  gl.enable(gl.DEPTH_TEST);

  rotateX = 0.0;
  rotateY = 0.0;
  rotateZ = 0.0;

  draw();
}

function move(event){

  if(event.which == 1){
    rotateY = rotateY + event.movementX;
    rotateX = rotateX + event.movementY;
		
  if(rotateX > 90.0){
    rotateX = 90.0;
    }
    if(rotateX < -90.0){
      rotateX = -90.0;
    }
		
    if(rotateY > 180.0){
      rotateY -= 360.0;
    }
    if(rotateY < -180.0){
      rotateY += 360.0;
    }
  }
}

function generate() {

  var vTemp = [];
  var trianglesTemp = [];
  var linesTemp = [];
  var x, y, z, i0, i1, i2, i3, i4, i5;
  for(var r = 0; r < n; r++) {
    for(var c = 0; c < n; c++) {
      x = 2*(c/(n-1))-1;
      z = 2*(r/(n-1))-1;
      y = 1 - (x*x) - (z*z);
      vTemp.push(x);
      vTemp.push(y);
      vTemp.push(z);
    }
  }
  vertices.set(vTemp);

  for(var r = 0; r < n-1; r++) {
    for(var c = 0; c < n-1; c++) {
      i0 = (r+0)*n+(c+0);
      i1 = (r+1)*n+(c+0);
      i2 = (r+0)*n+(c+1);
      i3 = (r+0)*n+(c+1);
      i4 = (r+1)*n+(c+0);
      i5 = (r+1)*n+(c+1);
      trianglesTemp.push(i0);
      trianglesTemp.push(i1);
      trianglesTemp.push(i2);
      trianglesTemp.push(i3);
      trianglesTemp.push(i4);
      trianglesTemp.push(i5);
    }
  }
  triangles.set(trianglesTemp);

  for(r = 0; r < (n); r++){
    for(c = 0; c < (n-1); c++){
      i0 = r*n+c;
      i2 = r*n+(c+1);
      linesTemp.push(i0);
      linesTemp.push(i2);
    }
  }
	
  for(r = 0; r < (n-1); r++){
    for(c = 0; c < (n); c++){
      i0 = r*n+c;
      i1 = (r+1)*n+c;
      linesTemp.push(i0);
      linesTemp.push(i1);
  }
}

  lines = new Uint16Array(linesTemp);
}

function draw() {

  var z = parseFloat(document.getElementById("zinput").value);  
  document.getElementById("zoutput").innerHTML = z; 
	
  var ProjectionLocation = gl.getUniformLocation(gl.program, 'Projection');
  var Projection = new Matrix4();
  Projection.setPerspective(45, 1, 1, 10);
  gl.uniformMatrix4fv(ProjectionLocation, false, Projection.elements);
  
  var ModelLocation = gl.getUniformLocation(gl.program, 'Model');
  var Model = new Matrix4();
  Model.setTranslate(0, -0.5, -z);
  Model.rotate(rotateX, 1, 0, 0);
  Model.rotate(rotateY, 0, 1, 0);
  gl.uniformMatrix4fv(ModelLocation, false, Model.elements);
  
  var LightLocation = gl.getUniformLocation(gl.program, 'Light');
  var Light = new Matrix4();

  gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

  gl.uniform4f(LightLocation, 1, 1, 1, 1);
  gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, triangleBuffer);
  gl.drawElements(gl.TRIANGLES, triangles.length, gl.UNSIGNED_SHORT, 0);

  gl.uniform4f(LightLocation, 0, 0, 0, 1);
  gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, lineBuffer);
  gl.drawElements(gl.LINES, lines.length, gl.UNSIGNED_SHORT, 0);

  requestAnimationFrame(draw);
}