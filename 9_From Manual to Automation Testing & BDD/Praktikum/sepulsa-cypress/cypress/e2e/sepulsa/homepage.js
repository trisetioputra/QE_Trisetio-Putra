import {Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";
import { should } from "chai";
import HomePage from "./pageObjects/HomePage";
import ProductPage from "./pageObjects/ProductPage";
const pageUrl= "https://www.sepulsa.com";

const homepage= new HomePage();

const productPage= new ProductPage();


Given("I open sepulsa.com homepage", ()=>{
    cy.visit(pageUrl);
})

When("I press at {} product icon", (product)=>{
    homepage.getProductIcon(product).should('be.visible').click();
})

Then("I will be directed to the correct {} product page", (product)=>{
    productPage.getPageTitle().should('contain', product);
})