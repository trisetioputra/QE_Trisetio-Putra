package test.automation.pages;

import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import test.automation.pageobject.BasePageObject;

public class HomeScreen extends BasePageObject {
    private By getDesignatedProductCard(int n){
        return MobileBy.xpath(String.format("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.ScrollView/android.view.View[%d]",n));
    }

//    private By getDesignatedProductTitleAndPrice(){
//        return MobileBy.xpath("//android.view.View[@content-desc=\"XBox 1 Rp 499\"]");
//    }

    private By getDesignatedBuyButton(int n){
        return MobileBy.xpath(String.format("(//android.widget.Button[@content-desc='Beli'])[%d]",n));
    }
    private By getPageTitle(){
        return MobileBy.xpath("//android.view.View[@content-desc='Products']");
    }

    private By getCartCounterByCount() {
        return MobileBy.xpath("//android.widget.Button[@index=2]");
    }
    public boolean isOnHomepage(){
        return waitUntilVisible(getPageTitle()).isDisplayed();
    }

    public boolean userCanSeeProductCard(int n){
        return waitUntilVisible(getDesignatedProductCard(n)).isDisplayed();
    }

    public void pressDesignatedBuyButton(int n){
        onClick(getDesignatedBuyButton(n));
    }
    public boolean checkFirstProduct(){
        return waitUntilVisible(getDesignatedProductCard(1)).isDisplayed();
    }

    public boolean checkAttributesOnProductCards(){
        return waitUntilVisible(getDesignatedProductCard(1)).isDisplayed();
    }

    public String checkCartCount(){
        return waitUntilVisible(getCartCounterByCount()).getAttribute("content-desc");
    }

}
