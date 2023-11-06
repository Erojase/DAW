// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

contract GasControl{

    string private CurrStorage;

    constructor() {
        
    }

    receive() external payable { 
        
    }

    error InsufficientBalance(uint balance, uint withdrawAmount);

    event InsufficientBalanceEvent(uint balance, uint withdrawAmount);

    function getString() public view returns (string memory){
        return CurrStorage;
    }

    function retrieveETH(uint256 amount) public payable {
        if (((address(this).balance / 100) * 30) < amount) {
            emit InsufficientBalanceEvent(address(this).balance, amount);
            revert InsufficientBalance(address(this).balance, amount);
        } else {
            payable(msg.sender).transfer(amount);
        }
    }

}