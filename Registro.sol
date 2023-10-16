// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/utils/Strings.sol";

contract Registro {
    address private owner;

    struct user{
        string nombre;
        uint256 edad;
    }

    mapping (address => user) userdict;


    constructor() {
        owner = msg.sender;

    }

    function getNombre(address targetAdress) public view returns (string memory Nombre){
        if (msg.sender == owner) {
            return userdict[targetAdress].nombre;
        } else if (msg.sender == targetAdress) {
            return userdict[msg.sender].nombre;
        }
    }

    function getEdad(address targetAdress) public view returns (uint256 Edad) {
        if (msg.sender == owner) {
            return userdict[targetAdress].edad;
        } else if (msg.sender == targetAdress) {
            return userdict[msg.sender].edad;
        }
    }

    function getAll(address targetAdress) public view returns (string memory nombre, uint256 Edad) {
        if (msg.sender == owner) {
            return (userdict[targetAdress].nombre, userdict[targetAdress].edad);
        } else if (msg.sender == targetAdress) {
            return (userdict[msg.sender].nombre, userdict[msg.sender].edad);
        }
    }

    function sauldar(address targetAdress) public view returns (string memory saludo) {
        address workingAddress;
        if (msg.sender == owner) {
            workingAddress = targetAdress;
        } else if (msg.sender == targetAdress) {
            workingAddress = msg.sender;
        }

        return string.concat("Buenas tardes, soy ",userdict[workingAddress].nombre,
         " y mi edad es ", Strings.toString(userdict[workingAddress].edad));
    }

    function registrarNombre(string memory _nombre, address targetAdress) public {
        if (msg.sender == owner) {
            userdict[targetAdress].nombre = _nombre;
        } else if (msg.sender == targetAdress) {
            userdict[msg.sender].nombre = _nombre;
        }
    }

    function registrarEdad(uint256 _edad, address targetAdress) public {
        if (msg.sender == owner) {
            userdict[targetAdress].edad = _edad;
        } else if (msg.sender == targetAdress) {
            userdict[msg.sender].edad = _edad;
        }
    }

   
}