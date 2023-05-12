import {Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";
import { should } from "chai";
import CategoryNavigation from "../navigation/category";

const categoryNav= new CategoryNavigation();


When("I press select category button", ()=>{
    categoryNav.pressCategoryButton();
})

Then("I will see all available categories in a list", ()=>{
    categoryNav.checkCategoryList();
})

When("I click at one of the categories", ()=>{
    categoryNav.pressFirstCategory();
})

Then("I will see the same categories on the category placeholder", ()=>{
    categoryNav.checkCategoryPlaceholder();
})

When("I press remove category button", ()=>{
    categoryNav.pressRemoveCategoryButton();
})

Then("I will see the category removed from the placeholder", ()=>{
    categoryNav.checkEmptyCategoryPlaceholder();
})