// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

import "@openzeppelin/contracts/token/ERC20/ERC20.sol";

contract UserList is ERC20 {
    address private owner;

    struct user {
        string nombre;
        uint256 edad;
        bool whitelisted;
        uint balance;
    }

    mapping(address => user) public userdict;

    constructor() ERC20("Patoken", "PTK")
    {
        owner = msg.sender;
        _mint(owner, 10000);
    }

    function getUserName(address addr) public view returns (string memory){
        return userdict[addr].nombre;
    }

    function getUserAge(address addr) public view returns (uint256){
        return userdict[addr].edad;
    }

    // function getUserBalance(address addr) public view returns (uint256)

    function isUserWhitelisted(address addr) public view returns (bool){
        return userdict[addr].whitelisted;
    }

    function whitelistUser(address addr) public {
        userdict[addr].whitelisted = true;
    }

    function blacklistUser(address addr) public {
        userdict[addr].whitelisted = false;
    }

    function addUser(address addr, string memory nombre, uint256 edad) public {
        userdict[addr].nombre = nombre;
        userdict[addr].edad = edad;
        userdict[addr].whitelisted = false;
    }


}