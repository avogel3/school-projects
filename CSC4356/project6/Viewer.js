// Viewer.js
var canvas, gl;
var modelRotationX = 0;
var modelRotationY = 0;
var modelTranslationZ = 3;
var dragging = false;
var projectionMatrixLocation, modelMatrixLocation, lightPositionLocation, lightColorLocation;
var positionArray, normalArray, triangleArray, texCoordArray;
var vertexPositionLocation, vertexNormalLocation, vertexTexCoordLocation;
var lastClientY, lastClientX;
var modelImage;

function loadTexture(image, texture) {
    gl.bindTexture(gl.TEXTURE_2D, texture);
    gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, image);
    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR);
    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MAG_FILTER, gl.LINEAR);
    requestAnimationFrame(draw);
}

function main() {
    canvas = document.getElementById('webgl');
    gl = getWebGLContext(canvas, false);

    initShaders(gl, document.getElementById("vertexShader").text, document.getElementById("fragmentShader").text);

    positionArray = new Float32Array(flatten(vertices));
    normalArray = new Float32Array(flatten(normals));
    triangleArray = new Uint16Array(flatten(triangles));
    texCoordArray = new Float32Array(flatten(texCoords));

    positionBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, positionArray, gl.STATIC_DRAW);

    normalBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, normalBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, normalArray, gl.STATIC_DRAW);

    triangleBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, triangleBuffer);
    gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, triangleArray, gl.STATIC_DRAW);

    texCoordBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, texCoordBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, texCoordArray, gl.STATIC_DRAW);

    vertexPositionLocation = gl.getAttribLocation(gl.program, "vertexPosition");
    gl.enableVertexAttribArray(vertexPositionLocation);
    vertexNormalLocation = gl.getAttribLocation(gl.program, "vertexNormal");
    gl.enableVertexAttribArray(vertexNormalLocation);
    vertexTexCoordLocation = gl.getAttribLocation(gl.program, "vertexTexCoord");
    gl.enableVertexAttribArray(vertexTexCoordLocation);

    gl.pixelStorei(gl.UNPACK_FLIP_Y_WEBGL, true);

    modelTexture = gl.createTexture();
    modelImage = new Image();
    modelImage.onload = function() {
        loadTexture(modelImage, modelTexture);
    }
    modelImage.crossOrigin = "anonymous";
    modelImage.src = "http://i.imgur.com/7thU1gD.jpg";

    gl.clearColor(0.0, 0.0, 0.0, 0.0);

    gl.enable(gl.DEPTH_TEST);

    requestAnimationFrame(draw);

    canvas.onmousedown = function(event) {
        dragging = true;
        lastClientX = event.clientX;
        lastClientY = event.clientY;
    }

    canvas.onmouseup = function(event) {
        dragging = false;
    }

    canvas.onmousemove = function(event) {
        if (dragging) {
            modelRotationX = modelRotationX + event.clientY - lastClientY;
            modelRotationY = modelRotationY + event.clientX - lastClientX;
            if (modelRotationX > 90.0) {
                modelRotationX = 90.0;
            }
            if (modelRotationX < -90.0) {
                modelRotationX = -90.0;
            }
            requestAnimationFrame(draw);
        }
        lastClientX = event.clientX;
        lastClientY = event.clientY;
    }
}

function draw() {
    var x = parseFloat(document.getElementById("xinput").value);
    document.getElementById("xoutput").innerHTML = x;

    var y = parseFloat(document.getElementById("yinput").value);
    document.getElementById("youtput").innerHTML = y;

    var z = parseFloat(document.getElementById("zinput").value);
    document.getElementById("zoutput").innerHTML = z;

    var projectionMatrix = new Matrix4();
    var modelMatrix = new Matrix4();

    projectionMatrixLocation = gl.getUniformLocation(gl.program, "projectionMatrix");
    projectionMatrix.setPerspective(45, 1, 1, 10);

    modelMatrixLocation = gl.getUniformLocation(gl.program, "modelMatrix");
    modelMatrix.setTranslate(0, 0, -modelTranslationZ);
    modelMatrix.rotate(modelRotationX, 1, 0, 0);
    modelMatrix.rotate(modelRotationY, 0, 1, 0);

    gl.uniformMatrix4fv(projectionMatrixLocation, false, projectionMatrix.elements);
    gl.uniformMatrix4fv(modelMatrixLocation, false, modelMatrix.elements);

    lightPositionLocation = gl.getUniformLocation(gl.program, "lightPosition");
    gl.uniform4fv(lightPositionLocation, [x, y, z, 1.0]);

    lightColorLocation = gl.getUniformLocation(gl.program, "lightColor");
    gl.uniform3f(lightColorLocation, 1.0, 1.0, 1.0);

    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    gl.vertexAttribPointer(vertexPositionLocation, 3, gl.FLOAT, false, 0, 0);

    gl.bindBuffer(gl.ARRAY_BUFFER, normalBuffer);
    gl.vertexAttribPointer(vertexNormalLocation, 3, gl.FLOAT, false, 0, 0);

    gl.bindBuffer(gl.ARRAY_BUFFER, texCoordBuffer);
    gl.vertexAttribPointer(vertexTexCoordLocation, 2, gl.FLOAT, false, 0, 0);

    gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
    gl.enable(gl.DEPTH_TEST);

    gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, triangleBuffer);
    gl.drawElements(gl.TRIANGLES, triangleArray.length, gl.UNSIGNED_SHORT, 0);
}

function add(a, b) {
    return [
        a[0] + b[0],
        a[1] + b[1],
        a[2] + b[2]
    ];
}

function subtract(a, b) {
    return [
        a[0] - b[0],
        a[1] - b[1],
        a[2] - b[2]
    ];
}

function dot(a, b) {
    return a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
}

function cross(a, b) {
    return [
        a[1] * b[2] - a[2] * b[1],
        a[2] * b[0] - a[0] * b[2],
        a[0] * b[1] - a[1] * b[0]
    ];
}

function normalize(a) {
    var len = Math.sqrt(dot(a, a));
    return [
        a[0] / len,
        a[1] / len,
        a[2] / len
    ];
}

function flatten(a) {
    return a.reduce(function(b, v) {
        b.push.apply(b, v);
        return b
    }, [])
}
