const readline = require("readline").createInterface({
	input: process.stdin,
	output: process.stdout,
});

let randNum;
let intento;
let prevGuesses;
let userGuess;

function initGame() {
	console.clear();

	randNum = Math.floor(Math.random() * 100) + 1;
	intento = 0;
	prevGuesses = [];
	userGuess = "";

	readline.question(`Introduce un numero: `, (name) => {
		userGuess = name;
		Game();
	});
}

function Game() {
	console.clear();
	// if (intento == 0) {
	// 	console.clear();
	// 	console.log("Has perdido el juego");
	// 	retry();
	// 	return;
	// }
	if (userGuess == randNum) {
		console.log("Enhorabuena has adivinado el número");
		readline.close();
		return;
	}

	console.log("No has conseguido adivinar el número");

	if (userGuess > randNum) {
		console.log("El numero es menor a " + userGuess);
	} else {
		console.log("El numero es mayor a " + userGuess);
	}

	intento++;
	prevGuesses.push(userGuess);
	console.log("Llevas " + intento + " intentos");
	console.log("Anteriores intentos: " + prevGuesses);
	readline.question(`Introduce otro numero: `, (name) => {
		userGuess = name;
		Game();
	});
}

function retry() {
	console.log("el número era " + randNum);
	readline.question(`Quieres volver a jugar? (si, no): `, (resp) => {
		if (resp == "si") {
			initGame();
		} else {
			readline.close();
			return;
		}
	});
}

initGame();