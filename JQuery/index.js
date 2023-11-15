let noticias = [
    ["Españoles", "Franco ha muerto"],
    ["Futbol", "ha ganado el Madrid al Barca 3 - 0"],
    ["Noticia3", "esta es la tercera noticia"]
]

let colors = ["red", "black", "green"]
let results = []
let num = 0;

document.addEventListener('DOMContentLoaded', ()=>{
    console.log([,,,].length);
    addNoticias();
    casino();
    linkado();
});


function linkado() {
    $("#btnlink1").click((e) => { 
        $("#link").attr('href', $("#btnlink1").attr('link'));
        console.log( $("#btnlink1").attr('link'));
        $("#link").text($("#btnlink1").attr('link'));
        //$("#link").click();
    });
    $("#link").click((e) => { 
        $("#link").attr('href', $("#txtlink").val());
        $("#link").text($("#txtlink").val());
    });
}



function addNoticias() {
    let i = 0;
    noticias.forEach(noti => {
        let noticia = document.createElement("div");
        noticia.className = "noticia";
        let titulo = document.createElement("h3");
        titulo.innerText = noti[0];
        let subtitulo = document.createElement("p");
        subtitulo.innerText = noti[1];
        subtitulo.style.backgroundColor = colors[i];

        noticia.appendChild(titulo);
        noticia.appendChild(subtitulo);
        $(noticia).appendTo("#noticias");
        i++;
        if (i > noticias.length) {
            i = 0;
        }
    });
    
}

function casino() {
    $("#btn").click(() => { 
        results = [];
        $("p").each((index, element) => { 
            num = Math.floor(Math.random()*3);
            $(element).css("backgroundColor", colors[num]);
            results.push(num)
        });
        let final = results.filter(x => x == num)
        if (final.length == 3) {
            $("#dineros").text(parseInt($("#dineros").text()) + 10);
        } else {
            $("#dineros").text(parseInt($("#dineros").text()) - 1);
        }
        isNegative($("#dineros"), $("#btn"));
    });
}

function isNegative(num, btn) {
    console.log(num.text());
    if ((parseInt(num.text()) == 0)) {
        btn.hide();
    } else {
        btn.show();
    }
}