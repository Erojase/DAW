import {
  ethers,
  formatEther,
  parseUnits
} from "https://cdnjs.cloudflare.com/ajax/libs/ethers/6.7.0/ethers.min.js";

let _connectMetamask;
let _getTokenBalance;
let _sendToken;

let signer = null;
let provider;
let contract;
const abi = [
    "function name() public view returns (string)",
    "function balanceOf(address account) public view returns (uint256)",
    "function symbol() public view returns (string)",
    "function decimals() public view returns (uint8)",
    "function totalSupply() public view returns (uint256)",
    "function approve(address _spender, uint256 _value) public returns (bool success)",
    "function transfer(address to, uint256 value) public returns (bool)"
  ];

document.addEventListener("DOMContentLoaded", () => {
  _connectMetamask = document.getElementById("connectMetamask");
  _getTokenBalance = document.getElementById("getTokenBalance");
  _sendToken = document.getElementById("sendToken");

  _connectMetamask.addEventListener("click", connectMetamask);
  _getTokenBalance.addEventListener("click", getTokenBalance);
  _sendToken.addEventListener("click", sendToken);
});

async function connectMetamask() {
  if (window.ethereum == null) {
    console.log("MetaMask not installed; using read-only defaults");
    provider = ethers.getDefaultProvider();
  } else {
    provider = new ethers.BrowserProvider(window.ethereum);
    signer = await provider.getSigner();
    console.log(signer);
  }
}

async function getTokenBalance() {
  let contractAddr = "0x63a7f826524bd3abba7669fbd826d578253115e2";
  contract = new ethers.Contract(contractAddr, abi, provider);

  console.log(`El token se llama ${await contract.name()},
su totalsupply es de ${formatEther(
    await contract.totalSupply()
  )} ${await contract.symbol()},
y tiene ${await contract.decimals()} decimales`);

  // console.log(`${formatEther(await contract.balanceOf(signer.address))} ${await contract.symbol()}`);
}

async function sendToken() {
  const toAddress = "0xb6BeC91C4c773Fb84071152A212394786A7a31Ef";
  const tokenAddress = "0x63a7f826524bd3abba7669fbd826d578253115e2";
  contract = new ethers.Contract(tokenAddress, abi, signer);
  // Define and parse token amount. Each token has 18 decimal places. In this example we will send 1 LINK token
  const amount = parseUnits("1.0", 18);

  //Define the data parameter
  const tx = await contract.transfer(toAddress,amount);

  // Waiting for the transaction to be mined
  const receipt = await tx.wait();

  // The transaction is now on chain!
  console.log(`Mined in block ${receipt.blockNumber}`);
}
