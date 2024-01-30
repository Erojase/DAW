import {
    time,
    loadFixture,
} from "@nomicfoundation/hardhat-toolbox/network-helpers";
import { anyValue } from "@nomicfoundation/hardhat-chai-matchers/withArgs";
import { expect } from "chai";
import { ethers } from "hardhat";

describe("Token", function () {
    /**
     * el nombre del token es MJT
     * el totalSupply inicial es 2000000
     * el owner del Token es la cuenta desde la que se ha desplegadoel token
     */

    async function getContractDetails() {

        const [owner] = await ethers.getSigners();

        const Token = await ethers.getContractFactory("Token");
        const token = await Token.deploy();

        return {token, owner}
    }

    describe("Development", function () {
        it("Token should be named 'MJT'", async () => {
            const { token } = await loadFixture(getContractDetails);

            expect(await token.symbol()).to.equal("MJT");
        })
        it("Initial totalSupply must be 2000000", async () => {
            const { token } = await loadFixture(getContractDetails);

            expect(await token.totalSupply()).to.equal(2000000);
        })
        it("Token owner must be the address to deploy the contract", async () => {
            const { token, owner } = await loadFixture(getContractDetails);

            expect(await token.owner()).to.equal(owner.address);
        })
        it("Transfer tokens test",async () => {
            const { owner, token } = await loadFixture(getContractDetails);
            // token.transfer()
        })
    })
})