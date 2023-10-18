document.getElementById("loadData").addEventListener("click", ()=>{ajaxGet("datos.json", displayData)});
document.getElementById("loadCatalogo").addEventListener("click", ()=>{ajaxGet("catalogo.json", displayCatalogo)});
document.addEventListener('DOMContentLoaded', ()=>{
    ajaxGet("catalogo.json", displayCatalogo);
});

function ajaxGet(filename, callback) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", filename, true);

    xhr.onload = function () {
        if (xhr.status >= 200 && xhr.status < 300) {
            var data = JSON.parse(xhr.responseText);
            callback(data);
        } else {
            console.error("Error al cargar los datos: " + xhr.status);
        }
    };

    xhr.onerror = function () {
        console.error("Error de red al cargar los datos.");
    };

    xhr.send();
}


function displayCatalogo(data) {
    let catCont = document.getElementById("catalogo");
    catCont.innerHTML = "";

    catCont.className = "catCont";

    let categoria = data["catalogo"]["categoria"];
    let productos = data["catalogo"]["productos"];

    let h1 = document.createElement("h1");
    h1.innerHTML = `${Object.keys(data)[0]}<hr>`.toUpperCase();
    catCont.appendChild(h1);

    let h3 = document.createElement("h3");
    h3.innerText = categoria;
    catCont.appendChild(h3);

    let elemCont = document.createElement("div");
    elemCont.className = "elementContainer";

    productos.forEach(prod => {
        let div = document.createElement("div");
        div.classList.toggle("item");
        Object.keys(prod).forEach(key => {
            let keycont = document.createElement("div");
            let key_ = document.createElement("div");
            let value = document.createElement("div");
            keycont.className = "keycont";
            key_.innerText = key+": ";
            key_.className = "key";
            value.innerText = prod[key];
            keycont.appendChild(key_);
            keycont.appendChild(value);
            div.appendChild(keycont);
        });
        elemCont.appendChild(div);
    });
    catCont.appendChild(elemCont);

}

function displayData(data) {
    var result = document.getElementById("result");
    console.log(data);
    data.forEach(usr => {
        result.innerHTML += "Nombre: " + usr.nombre + "<br>Edad: " + usr.edad + "<br>";
    });
}
