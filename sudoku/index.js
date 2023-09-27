let main;
let revealer;
let checker;
let resetter;
let bigcells;
let fallos_ = 0;
let currSudoku = {
    "0,0,1": "","0,2": "","0,3": "","0,4": "","0,5": "","0,6": "","0,7": "","0,8": "",
    "1,0": "","1,1": "","1,2": "","1,3": "","1,4": "","1,5": "","1,6": "","1,7": "","1,8": "",
    "2,0": "","2,1": "","2,2": "","2,3": "","2,4": "","2,5": "","2,6": "","2,7": "","2,8": "",
    "3,0": "","3,1": "","3,2": "","3,3": "","3,4": "","3,5": "","3,6": "","3,7": "","3,8": "",
    "4,0": "","4,1": "","4,2": "","4,3": "","4,4": "","4,5": "","4,6": "","4,7": "","4,8": "",
    "5,0": "","5,1": "","5,2": "","5,3": "","5,4": "","5,5": "","5,6": "","5,7": "","5,8": "",
    "6,0": "","6,1": "","6,2": "","6,3": "","6,4": "","6,5": "","6,6": "","6,7": "","6,8": "",
    "7,0": "","7,1": "","7,2": "","7,3": "","7,4": "","7,5": "","7,6": "","7,7": "","7,8": "",
    "8,0": "","8,1": "","8,2": "","8,3": "","8,4": "","8,5": "","8,6": "","8,7": "","8,8": "",
}
const template = {
    "0,0": "8","0,1": "6","0,2": "1","0,3": "3","0,4": "5","0,5": "2","0,6": "4","0,7": "9","0,8": "7",
    "1,0": "7","1,1": "9","1,2": "4","1,3": "1","1,4": "6","1,5": "8","1,6": "2","1,7": "5","1,8": "3",
    "2,0": "3","2,1": "5","2,2": "2","2,3": "7","2,4": "4","2,5": "9","2,6": "1","2,7": "8","2,8": "6",
    "3,0": "2","3,1": "1","3,2": "8","3,3": "6","3,4": "7","3,5": "5","3,6": "9","3,7": "3","3,8": "4",
    "4,0": "9","4,1": "7","4,2": "5","4,3": "3","4,4": "4","4,5": "1","4,6": "6","4,7": "8","4,8": "2",
    "5,0": "6","5,1": "3","5,2": "4","5,3": "9","5,4": "2","5,5": "8","5,6": "5","5,7": "1","5,8": "7",
    "6,0": "5","6,1": "2","6,2": "6","6,3": "7","6,4": "4","6,5": "3","6,6": "1","6,7": "8","6,8": "9",
    "7,0": "8","7,1": "1","7,2": "9","7,3": "5","7,4": "2","7,5": "6","7,6": "4","7,7": "3","7,8": "7",
    "8,0": "4","8,1": "7","8,2": "3","8,3": "8","8,4": "9","8,5": "1","8,6": "2","8,7": "6","8,8": "5",}

document.addEventListener('DOMContentLoaded', ()=>{

    main = document.getElementById("main");
    revealer = document.getElementById("revealer");
    checker = document.getElementById("checker");
    resetter = document.getElementById("resetter");
    bigcells = document.getElementsByClassName("bigcell");
    
    let i = 0;
    let j = 0;
    for (const bigcell of bigcells) {
        let cells = bigcell.getElementsByClassName("cell");
        for (const cell of cells) {
            
            cell.setAttribute("coords", [j,i]);
            cell.addEventListener('click', cellOnclick);
            i++;
        }
        j++;
        i = 0;
    }

    for (let k = 0; k <= 4; k++) {
        partlyShow();
    }

    revealer.addEventListener("mousedown", peek);
    revealer.addEventListener("mouseup", unpeek);
    checker.addEventListener("click", resolve);
    resetter.addEventListener("click", reset)
});

function peek() {
    reveal(template);
}

function unpeek() {
    reveal(currSudoku)
}

function parsecoord(coord) {
    let [i,j] = coord.split(",");
    return [i,j];
}

function getfromCoord(j,i){
    return document.querySelectorAll(`[coords="${j},${i}"]`)[0];
}


const cellOnclick = self => {
    self = self.target;
    let value;
    if (self.innerHTML == "" || self.innerHTML == 9) {
        value = 1;
    } else {
        value = Number.parseInt(self.innerHTML) + 1;
    }
    self.innerHTML = value;
    currSudoku[self.getAttribute("coords")] = value;
}

function partlyShow() {
    for (let i = 0; i < 9; i++) {
        let cellNum = Math.floor(Math.random() * 8) + 1;
        let value = template[`${i},${cellNum}`];
        let cell = getfromCoord(i, cellNum);
        cell.innerHTML = value;
        cell.removeEventListener('click', cellOnclick);
        currSudoku[`${i},${cellNum}`] = value;
    }
}

function resolve() {
    let cell;
    fallos_ = 0;
    for (const key in template) {
        coords = parsecoord(key);
        cell = getfromCoord(coords[0], coords[1])   
        if (template[key] == currSudoku[key]) {
            cell.animate([{ backgroundColor: "white"}, { backgroundColor: "green"}, ], {duration: 1000, iterations: 1,});
            cell.style.backgroundColor = "green";
        } else {
            cell.animate([{ backgroundColor: "white"}, { backgroundColor: "red"}, ], {duration: 1000, iterations: 1,});
            cell.style.backgroundColor = "red";
            fallos_ ++;
        }
    }
    fallos.innerHTML = `Fallos: ${fallos_}`;
}

function reveal(template) {
    let coords = [];
    for (const key in template) {
        coords = parsecoord(key);
        getfromCoord(coords[0], coords[1]).innerHTML = template[key];
    }
}

function reset() {
    window.location.reload();
}

