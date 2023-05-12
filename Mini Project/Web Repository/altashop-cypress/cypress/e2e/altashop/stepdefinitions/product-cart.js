import {Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";
import { should } from "chai";
import CartNavigation from "../navigation/cart";

const cartNav= new CartNavigation();


When("I press buy button on multiple product cards", ()=>{
    cartNav.pressBuyButtonForMultipleProducts();
})

When("I press buy button on sample product cards", ()=>{
    cartNav.pressBuyForSampleProducts();
})

When("I press buy button on for the same product multiple times", ()=>{
    cartNav.pressBuyButtonForSameProductMultipleTimes();
})

Then("I will see increasing value on cart icon counter", ()=>{
    cartNav.checkCartIconCount();
})

Then("I will not see increasing value on cart icon counter", ()=>{
    cartNav.checkCartIconCountNotIncreasing();
})

When("I click at cart icon", ()=>{
    cartNav.pressCartIcon();
})

Then("I will see the matching products displayed on cart", ()=>{
    cartNav.checkMatchingProductTitles();
})

Then("I will see the quantity for the product matching the amounts of clicks", ()=>{
    cartNav.checkMatchingQuantitiesPerClick();
})

And("I click at {} quantity icon for {} times", (type,times)=>{
    cartNav.editQuantityHandler(type,times);
})

Then("I will see the item quantity changed according with the click times {} and type {}", (times, type)=>{
    cartNav.checkQuantityHandler(type,times);
})

And("I will see total price and total quantity also edited", ()=>{
    cartNav.checkTotalsHandler();
})

And("I click at {} quantity icon for {} times", (type,times)=>{
    cartNav.checkTotalsHandler();
})

And("I press pay button", (type,times)=>{
    cartNav.pressPayButton();
})

Then("I will see order is empty message", ()=>{
    cartNav.checkEmptyProductWording();
})

Then("I will be directed to login page", ()=>{
    cartNav.checkIsOnLoginPage();
})
