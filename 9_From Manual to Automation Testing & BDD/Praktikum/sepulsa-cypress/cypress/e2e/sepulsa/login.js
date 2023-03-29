import {Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";
import LoginPage from "./pageObjects/loginPage";
import { should } from "chai";
const pageUrl= "https://www.sepulsa.com/signin";

const loginPage= new LoginPage();

Given("I open sepulsa.com login page", ()=>{
    cy.visit(pageUrl);
})

When("I enter credentials on {} and {} fields", (email,password)=>{
    loginPage.getEmailForm().should('be.visible').type(email);
    loginPage.getPasswordForm().should('be.visible').type(password);
})

And("I press submit button", ()=>{
    loginPage.getSubmitForm().should('be.visible').click();
})

Then("I will successfully redirect to homepage", ()=>{
    cy.wait(5000);
    cy.url().should('eq', 'https://www.sepulsa.com/') // => true
})

Then("I will see error message", ()=>{
    cy.wait(5000);
    loginPage.getErrorMessage().should('contain',"Masih ada yang salah nih")
})