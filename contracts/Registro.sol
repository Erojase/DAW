// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/utils/Strings.sol";

contract Registro {
    address private owner;

    struct user {
        string nombre;
        uint256 edad;
        uint256 prepayCount;
    }

    mapping(address => user) userdict;

    modifier onlyOwner() {
        require(msg.sender == owner);
        _;
    }

    event datosActualizados(address user, string nombre, uint256 edad);

    constructor() {
        owner = msg.sender;
    }

    receive() external payable { 
        userdict[msg.sender].prepayCount ++;
        emit datosActualizados(msg.sender, userdict[msg.sender].nombre, userdict[msg.sender].edad);
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

    function getAll(address targetAdress) public onlyOwner view returns (string memory, uint256, uint256){
        require(msg.sender != address(0), "La direccion no puede ser cero.");
        return (userdict[targetAdress].nombre, userdict[targetAdress].edad, userdict[targetAdress].prepayCount);
    }

    function getMyAll() public view returns (string memory, uint256, uint256){
        return (userdict[msg.sender].nombre, userdict[msg.sender].edad, userdict[msg.sender].prepayCount);
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
        require(bytes(_nombre).length > 0, "El nombre no puede estar vacio");
        userdict[targetAdress].nombre = _nombre;
        userdict[targetAdress].edad = _edad;
    }

    function registrarme(string memory _nombre, uint256 _edad) public payable{
        if (userdict[msg.sender].prepayCount > 0) {
            require(msg.value == 0.25 ether, "Must pay 0.25 ETH");
        } else {
            require(msg.value == 0.5 ether, "Must pay 0.5 ETH");
        }
        require(bytes(_nombre).length > 0, "El nombre no puede estar vacio");
        userdict[msg.sender].nombre = _nombre;
        userdict[msg.sender].edad = _edad;
        userdict[msg.sender].prepayCount --;
    }

    function getBalance() public view onlyOwner returns(uint256){
        return address(this).balance;
    }

    function retrieve() public onlyOwner {
        payable(owner).transfer(address(this).balance);
    }
}
