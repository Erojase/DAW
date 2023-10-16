// SPDX-License-Identifier: MIT
// Contrato de "Hola Mundo" en Solidity
pragma solidity ^0.8.0; 

contract HolaMundo {
    string public mensaje = "Hola mundo";

    function obtenerMensaje() public view returns (string memory) {

        return mensaje;
    }
}