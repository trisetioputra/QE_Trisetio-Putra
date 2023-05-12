import {Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";
import { should } from "chai";
import DetailNavigation from "../navigation/detail";

const detailNav= new DetailNavigation();


When("I press detail button for a random product card", ()=>{
    detailNav.pressDetailButton();
})

Then("I will see the same product detail page", ()=>{
    detailNav.checkDetailPageComponents();
})

And("I will see product price, rating icon for the product, and rating count", ()=>{
    detailNav.checkDetailPageComponents();
})
