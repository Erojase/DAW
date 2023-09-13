let randNum;
let intento;
let prevGuesses;
let userGuess;


document.addEventListener('DOMContentLoaded', ()=>{
    initGame();
    btnGuess.addEventListener('click', Game)
});


function initGame() {
	textBox.innerHTML = "";

	randNum = Math.floor(Math.random() * 100) + 1;
	intento = 0;
	prevGuesses = [];
	userGuess = "";

    console.log(randNum);
}

function Game() {
    userGuess = document.getElementById("guess").value;
    document.getElementById("guess").value = "";
	textBox.innerHTML = "";
	if (userGuess == randNum) {
		textBox.innerHTML = "Enhorabuena has adivinado el número<br>";
        retry();
		return;
	}

	textBox.innerHTML += "No has conseguido adivinar el número<br>";

	if (userGuess > randNum) {
		textBox.innerHTML += "El numero es menor a " + userGuess+"<br>";
	} else {
		textBox.innerHTML += "El numero es mayor a " + userGuess+"<br>";
	}

	intento++;
	prevGuesses.push(userGuess);
	textBox.innerHTML += "Llevas " + intento + " intentos<br>";
	textBox.innerHTML += "Anteriores intentos: " + prevGuesses+"<br>";
}


function retry() {
    setTimeout(() => {
        document.getElementById("guess").value = "";
        initGame();
    }, 5000);
}
