package test.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import test.automation.pages.HomeScreen;
import test.automation.pages.LoginScreen;

public class HomepageSteps {
    @Steps
    HomeScreen homeScreen;
    @Given("I am on altashop homepage")
    public void iAmOnAltashopHomepage() {
        Assert.assertTrue(homeScreen.isOnHomepage());
    }

    @Then("I will see multiple product cards")
    public void iWillSeeMultipleProductCards() {
        for(int i=1;i<=5;i++){
            Assert.assertTrue(homeScreen.userCanSeeProductCard(i));
        }
    }

    @When("I check at the first product card")
    public void iCheckAtTheFirstProductCard() {
        Assert.assertTrue(homeScreen.checkFirstProduct());
    }

    @Then("I will see product title and price")
    public void iWillSeeProductTitleAndPrice() {
        Assert.assertTrue(homeScreen.checkAttributesOnProductCards());
    }

    @When("I press buy button on multiple product cards")
    public void iPressBuyButtonOnMultipleProductCards() {
        for(int i=1;i<=5;i++){
            homeScreen.pressDesignatedBuyButton(i);
        }
    }

    @Then("I will see increasing value on cart icon counter")
    public void iWillSeeIncreasingValueOnCartIconCounter() {
        Assert.assertEquals(homeScreen.checkCartCount(),"5");
    }
}
