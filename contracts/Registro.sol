// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/utils/Strings.sol";
import "contracts/UserList.sol";

contract Registro {
    address private owner;

    UserList private Users;

    modifier onlyOwner() {
        require(msg.sender == owner);
        _;
    }
    modifier whitelisted() {
        require(Users.isUserWhitelisted(msg.sender));
        _;
    }

    event datosActualizados(address user, string nombre, uint256 edad);

    constructor()
    {
        owner = msg.sender;
        Users = new UserList();
    }

    function getNombre(address targetAdress) public view onlyOwner returns (string memory){
        require(msg.sender != address(0), "La direccion no puede ser cero.");
        return Users.getUserName(targetAdress);
    }

    function getMyNombre() public view whitelisted returns (string memory Nombre) {
        return Users.getUserName(msg.sender);
    }

    function getEdad(address targetAdress) public onlyOwner view returns (uint256 Edad) {
        require(msg.sender != address(0), "La direccion no puede ser cero.");
        return Users.getUserAge(targetAdress);
    }

    function getMyEdad() public view whitelisted returns (uint256 Edad) {
        return Users.getUserAge(msg.sender);
    }

    function getAllInfo(address targetAdress) public onlyOwner view returns (string memory, uint256, string memory){
        require(msg.sender != address(0), "La direccion no puede ser cero.");
        string memory whitelist = "User is blacklisted";
        if (Users.isUserWhitelisted(targetAdress)) {
            whitelist = "User is whitelisted";
        }
        return (Users.getUserName(targetAdress), Users.getUserAge(targetAdress), whitelist);
    }

    function getAllMyInfo() public view whitelisted returns (string memory, uint256, string memory){
        string memory whitelist = "User is blacklisted";
        if (Users.isUserWhitelisted(msg.sender)) {
            whitelist = "User is whitelisted";
        }
        return (Users.getUserName(msg.sender), Users.getUserAge(msg.sender), whitelist);
    }

    function registrarme(string memory _nombre, uint256 _edad) public{
        Users.addUser(msg.sender, _nombre, _edad);
    }

    function otorgarAcceso() public payable{
        require(msg.value >= 0.05 ether, "must pay at least 0,05 ETH");
        Users.whitelistUser(msg.sender);
        Users.approve(address(Users), 1);
        Users.transferFrom(address(Users), msg.sender, 1);
    }

    function getBalance() public view onlyOwner returns(uint256){
        return address(this).balance;
    }
}
