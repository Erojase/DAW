import { ethers } from "hardhat";

async function lockDeploy() {
  const currentTimestampInSeconds = Math.round(Date.now() / 1000);
  const unlockTime = currentTimestampInSeconds + 60;

  const lockedAmount = ethers.parseEther("0.001");

  const lock = await ethers.deployContract("Lock", [unlockTime], {
    value: lockedAmount,
  });

  await lock.waitForDeployment();

  console.log(
    `Lock with ${ethers.formatEther(
      lockedAmount
    )}ETH and unlock timestamp ${unlockTime} deployed to ${lock.target}`
  );
  
}

async function tokenDeploy() {
  
  const token = await ethers.deployContract("Token");

  await token.waitForDeployment();
}

// We recommend this pattern to be able to use async/await everywhere
// and properly handle errors.
// lockDeploy().catch((error) => {
//   console.error(error);
//   process.exitCode = 1;
// });

tokenDeploy().catch((error) => {
  console.error(error);
  process.exitCode = 1;
});
