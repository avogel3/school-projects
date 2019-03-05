// Viewer.js
var canvas, gl;
var modelRotationX = 0;
var modelRotationY = 0;
var modelTranslationZ = 3;
var dragging = false;
var projectionMatrixLocation, modelMatrixLocation, lightDirectionLocation, lightColorLocation, objectColorLocation;
var normals = [];
var positionArray, normalArray, triangleArray;
var vertexPositionLocation, vertexNormalLocation;
var lastClientY, lastClientX;


function main() {
    canvas = document.getElementById('webgl');
    gl = getWebGLContext(canvas, false);

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

    initShaders(gl, document.getElementById("vertexShader").text, document.getElementById("fragmentShader").text);

    init();

    positionArray = new Float32Array(flatten(vertices));
    normalArray = new Float32Array(flatten(normals));
    triangleArray = new Uint16Array(flatten(triangles));

    positionBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, positionArray, gl.STATIC_DRAW);

    normalBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, normalBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, normalArray, gl.STATIC_DRAW);

    triangleBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, triangleBuffer);
    gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, triangleArray, gl.STATIC_DRAW);

    vertexPositionLocation = gl.getAttribLocation(gl.program, "vertexPosition");
    gl.enableVertexAttribArray(vertexPositionLocation);
    vertexNormalLocation = gl.getAttribLocation(gl.program, "vertexNormal");
    gl.enableVertexAttribArray(vertexNormalLocation);

    gl.clearColor(0.0, 0.0, 0.0, 0.0);

    gl.clear(gl.COLOR_BUFFER_BIT);

    gl.enable(gl.DEPTH_TEST);

    draw();
}

function init() {
    var a, b, n, i0, i1, i2;
    for (var i = 0; i < vertices.length; i++) {
        normals.push([0, 0, 0]);
    }

    for (var i = 0; i < triangles.length; i++) {
        i0 = triangles[i][0];
        i1 = triangles[i][1];
        i2 = triangles[i][2];
        a = normalize(subtract(vertices[i1], vertices[i0]));
        b = normalize(subtract(vertices[i2], vertices[i0]));
        n = normalize(cross(a, b));
        normals[i0] = add(normals[i0], n);
        normals[i1] = add(normals[i1], n);
        normals[i2] = add(normals[i2], n);
    }

    for (var i = 0; i < normals.length; i++) {
        n = normalize(normals[i]);
    }

}

function draw() {
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

    gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

    lightDirectionLocation = gl.getUniformLocation(gl.program, "lightDirection");
    gl.uniform3f(lightDirectionLocation, 0.0, 1.0, 1.0);

    lightColorLocation = gl.getUniformLocation(gl.program, "lightColor");
    gl.uniform3f(lightColorLocation, 1.0, 1.0, 1.0);

    objectColorLocation = gl.getUniformLocation(gl.program, "objectColor");
    gl.uniform3f(objectColorLocation, 0.8, 0.8, 0.8);

    gl.bindBuffer(gl.ARRAY_BUFFER, positionBuffer);
    gl.vertexAttribPointer(vertexPositionLocation, 3, gl.FLOAT, false, 0, 0);

    gl.bindBuffer(gl.ARRAY_BUFFER, normalBuffer);
    gl.vertexAttribPointer(vertexNormalLocation, 3, gl.FLOAT, false, 0, 0);

    gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, triangleBuffer);
    gl.drawElements(gl.TRIANGLES, triangleArray.length, gl.UNSIGNED_SHORT, 0);

    requestAnimationFrame(draw);
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