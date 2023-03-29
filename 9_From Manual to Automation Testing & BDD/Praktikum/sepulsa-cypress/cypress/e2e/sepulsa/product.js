import {Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";
import { should } from "chai";
import ProductPage from "./pageObjects/ProductPage";

const productPage= new ProductPage();


And("I enter {} at form field", (phoneNumber)=>{
    productPage.getPhoneNumberForm().should('be.visible').type(phoneNumber);
})


And("I select the 100.000 pulsa package", ()=>{
    productPage.getPulsaProduct().should('be.visible').click();
})

Then("I will be directed to payment page", ()=>{
    cy.url().should('eq', 'https://www.sepulsa.com/transaction/checkout') // => true
})
