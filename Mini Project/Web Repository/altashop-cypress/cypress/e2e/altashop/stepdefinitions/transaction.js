import {Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";
import { should } from "chai";
import TransactionPageNavigation from "../navigation/transaction";

const transactionNav= new TransactionPageNavigation();

Then("I will be directed to transaction page",()=>{
    transactionNav.checkOnTransactionPage();
})

And("I will see purchased item being present on the list",()=>{
    transactionNav.checkHasTransactionData();
})

Then("I will see the item shown as {} item per page",(length)=>{
    transactionNav.checkIsShowingCorrectDataAmount(length);
})

And("I change rows per page shown to: {}",(length)=>{
    transactionNav.changeRowLimitTo(length);
})

Then("I can see the data start from count: {}",(start)=>{
    transactionNav.checkDataStartCount(start+"-");
})

When("I press {} arrow",(direction)=>{
    transactionNav.pressChevronButton(direction);
})