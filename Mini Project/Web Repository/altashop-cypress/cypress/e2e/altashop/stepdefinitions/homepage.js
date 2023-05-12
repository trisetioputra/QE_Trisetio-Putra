/// <reference types="Cypress" />

import {Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";
import { should } from "chai";
import LandingPageNavigation from "../navigation/landing";

const landingPageNav= new LandingPageNavigation();

When("I press login button", ()=>{
    landingPageNav.pressLoginIcon();
})

Given("I open altashop homepage", ()=>{
    landingPageNav.openPage();
})

Then("I will see multiple product cards", ()=>{
    landingPageNav.checkProductCardIsMoreThanOne();
})

When("I check at the first product card", ()=>{
    landingPageNav.checkDesignatedProductCard(1);
})

Then("I will see product title, price, and description", ()=>{
    landingPageNav.checkDesignatedProductAttributes(1);
})

Then("I will be directed to homepage with user permission", ()=>{
    landingPageNav.checkUserButton();
})

When("I press transaction option", ()=>{
    landingPageNav.pressTransactionButton();
})

