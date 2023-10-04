console.time("tiempo");


let primo = true;
async function start(len) {
	for (let n = 2; n <= len; n++) {
        if (comPrimo(n)){
            console.log(n);
            continue;
        }
        len++;
    }
}

function comPrimo(num) {
    let primo = true;

	for (let i = 2; i < num; i++) {
        if (num % i == 0) {
            primo = false;
            break;
        }
    }
    
    if (primo) {
        return true;
    }
    
    //garbage collection
    primo = null 
    num = null;
    return false;
}

start(Number(process.argv[2])+1);
console.timeEnd("tiempo");