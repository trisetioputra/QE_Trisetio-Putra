import {Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";
import { should } from "chai";
import PaymentPage from "./pageObjects/PaymentPage";

const paymentPage= new PaymentPage();


When("I enter valid {} at form field", (email)=>{
    paymentPage.getEmailForm().should('be.visible').type(email);
})

And("I select payment method", ()=>{
    paymentPage.getPaymentMethod().should('be.visible').click();
})

And("I select Bayar Sekarang button", ()=>{
    paymentPage.getPayNowButton().should('be.visible').click();
})

Then("I will be directed to finish transaction page", ()=>{
    cy.url().should('not.equal',"https://www.sepulsa.com/transaction/checkout")
})

