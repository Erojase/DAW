const userCookies = "userData";

let username;
let passwd;

let btnDelUsrCooks;

let cookieUserData = {};

document.addEventListener('DOMContentLoaded', ()=>{
    cookieUserData = getCookies();
    username = document.getElementById("username");
    passwd = document.getElementById("pass");
    btnDelUsrCooks = document.getElementById("deleteUsrCooks");


    document.getElementById("btn").addEventListener('click', validateForm);
    btnDelUsrCooks.addEventListener('click', ()=>{deleteCookie(userCookies)});
    console.log(getCookies());
    console.log(getCookie(userCookies));
});

function validateForm() {
    if (username.value.length < 1 || passwd.value.length < 1) {
        alert("hay algun campo vacío");
        return;
    }
    let tmpUsrData = {
        usr: username.value,
        pass: passwd.value
    }
    addCookie(userCookies, JSON.stringify(tmpUsrData));
}

function addCookie(key, value) {
    document.cookie = `${key}=${value}; Path=/; Expires=Thu, 01 Jan 2024 00:00:01 GMT;`;
}

function cookieExists(key) {
    let exists = false
    Object.keys(cookieUserData).forEach(cook =>{
        if (cook == key) {
            exists = true;
        }
    })
    return exists;
}

function getCookies() {
    let cookies = document.cookie;
    let parsedCookies = {};

    cookies.split("; ").forEach(cook =>{
        parsedCookies[cook.split("=")[0]] = cook.split("=")[1]
    });

    return parsedCookies;
}

function getCookie(key) {
    if (cookieExists(key)) {
        return JSON.parse(cookieUserData[key]);
    }
}

function deleteCookie(key) {
    if (cookieExists(key)) {
        document.cookie = key +'='+JSON.stringify(getCookie(key))+'; Path=/; Expires=Thu, 01 Jan 2003 00:00:01 GMT;';
        console.log(key +'='+JSON.stringify(getCookie(key))+'; Path=/; Expires=Thu, 01 Jan 2003 00:00:01 GMT;');
        return;
    }
    console.log("no pasa");
}