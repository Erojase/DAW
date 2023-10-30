// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/utils/Strings.sol";

contract Registro {
    address private owner;

    uint256 private balance;

    struct user {
        string nombre;
        uint256 edad;
    }

    mapping(address => user) userdict;

    modifier onlyOwner() {
        require(msg.sender == owner);
        _;
    }

    constructor() {
        owner = msg.sender;
    }

    function getNombre(address targetAdress) public view onlyOwner returns (string memory Nombre){
        require(msg.sender != address(0), "La direccion no puede ser cero.");
        return userdict[targetAdress].nombre;
    }

    function getMyNombre() public view returns (string memory Nombre) {
        return userdict[msg.sender].nombre;
    }

    function getEdad(address targetAdress) public onlyOwner view returns (uint256 Edad) {
        require(msg.sender != address(0), "La direccion no puede ser cero.");
        return userdict[targetAdress].edad;
    }

    function getMyEdad() public view returns (uint256 Edad) {
        return userdict[msg.sender].edad;
    }

    function getAll(address targetAdress) public onlyOwner view returns (string memory nombre, uint256 Edad){
        require(msg.sender != address(0), "La direccion no puede ser cero.");
        return (userdict[targetAdress].nombre, userdict[targetAdress].edad);
    }

    function getMyAll() public view returns (string memory nombre, uint256 Edad){
        return (userdict[msg.sender].nombre, userdict[msg.sender].edad);
    }

    function sauldar(address targetAdress) public view returns (string memory saludo)
    {
        require(msg.sender != address(0), "La direccion no puede ser cero.");
        address workingAddress;
        if (msg.sender == owner) {
            workingAddress = targetAdress;
        } else if (msg.sender == targetAdress) {
            workingAddress = msg.sender;
        }

        return string.concat(
                "Buenas tardes, soy ",
                userdict[workingAddress].nombre,
                " y mi edad es ",
                Strings.toString(userdict[workingAddress].edad)
            );
    }

    function registrarUsuario(string memory _nombre,uint256 _edad, address targetAdress) public onlyOwner {
        require(msg.sender != address(0), "La direccion no puede ser cero.");
        require(bytes(_nombre).length == 0, "El nombre no puede estar vacio");
        userdict[targetAdress].nombre = _nombre;
        userdict[targetAdress].edad = _edad;
    }

    function registrarme(string memory _nombre, uint256 _edad) public payable{
        require(msg.value == 0.5 ether, "Must pay 0.5 ETH");
        require(bytes(_nombre).length > 0, "El nombre no puede estar vacio");
        balance += msg.value;
        userdict[msg.sender].nombre = _nombre;
        userdict[msg.sender].edad = _edad;
    }

    function getBalance() public view onlyOwner returns(uint256){
        return address(this).balance;
    }

    function retrieve() public onlyOwner {
        payable(owner).transfer(address(this).balance);
    }
}
