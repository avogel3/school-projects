// Grapher.js
// Vertex shader program

var n = 16; //the number of vertices
var length = 3*n*n; //length of the vertices array
var lengthT = 6*(n-1)*(n-1); //length of the triangles array

var VSHADER_SOURCE =
  'attribute vec4 a_Position;\n' +
  'varying mediump vec4 v_Color;\n' +
  'void main() {\n' +
  'v_Color = (a_Position + 1.0) / 2.0;\n' +
  '  gl_Position = a_Position;\n' +
  '}\n';

// Fragment shader program
var FSHADER_SOURCE =
'varying mediump vec4 v_Color;\n' +
  'void main() {\n' +
  '  gl_FragColor = v_Color;\n' +
  '}\n';

function main() {
  // Retrieve <canvas> element
  var canvas = document.getElementById('webgl');

  // Get the rendering context for WebGL
  var gl = getWebGLContext(canvas);
  if (!gl) {
    console.log('Failed to get the rendering context for WebGL');
    return;
  }

  // Initialize shaders
  if (!initShaders(gl, VSHADER_SOURCE, FSHADER_SOURCE)) {
    console.log('Failed to intialize shaders.');
    return;
  }

  // Write the positions of vertices to a vertex shader
  var n = initVertexBuffers(gl);
  if (n < 0) {
    console.log('Failed to set the positions of the vertices');
    return;
  }

  //enable depth test
  gl.enable(gl.DEPTH_TEST);

  // Specify the color for clearing <canvas>
  gl.clearColor(0.0, 0.0, 0.0, 1.0);

  // Clear <canvas>
  gl.clear(gl.COLOR_BUFFER_BIT);

  //Draw the array of traingles
  gl.drawElements(gl.TRIANGLES, length, gl.UNSIGNED_SHORT, 0);
}

function initVertexBuffers(gl) {
  var vertices = new Float32Array(length);
  var triangles = new Uint16Array(lengthT);
  var vTemp = [];
  var trianglesTemp = [];
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

  // Create a buffer object
  var vertexBuffer = gl.createBuffer();
  var triangleBuffer = gl.createBuffer();
  if (!vertexBuffer) {
    console.log('Failed to create the buffer object');
    return -1;
  }

  // Bind the buffer object to target - vertices array
  gl.bindBuffer(gl.ARRAY_BUFFER, vertexBuffer);
  // Write data into the buffer object - vertices array
  gl.bufferData(gl.ARRAY_BUFFER, vertices, gl.STATIC_DRAW);

  //Bind the buffer object to target - triangles array
  gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, triangleBuffer);
  //Write data into the buffer object - triangles array
  gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, triangles, gl.STATIC_DRAW);

  var a_Position = gl.getAttribLocation(gl.program, 'a_Position');
  if (a_Position < 0) {
    console.log('Failed to get the storage location of a_Position');
    return -1;
  }
  // Assign the buffer object to a_Position variable
  gl.vertexAttribPointer(a_Position, 3, gl.FLOAT, false, 0, 0);

  // Enable the assignment to a_Position variable
  gl.enableVertexAttribArray(a_Position);

  return n;
}