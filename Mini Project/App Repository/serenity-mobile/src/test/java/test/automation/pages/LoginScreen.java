package test.automation.pages;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import test.automation.pageobject.BasePageObject;

public class LoginScreen extends BasePageObject {
    private By getLoginButtonOnHomepage(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    }
    private By getEmailForm(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
    }
    private By getPasswordForm(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
    }
    private By getLoginSubmitButton(){
        return MobileBy.xpath("//android.widget.Button[@index=3]");
    }
    private By getEmailUnregisteredError(){
        return MobileBy.xpath("//android.view.View[@index=6]");
    }
    private By getEmailError(){
        return MobileBy.xpath("//android.view.View[@content-desc='email can not empty']");
    }
    private By getPasswordError(){
        return MobileBy.xpath("//android.view.View[@content-desc='password can not empty']");
    }
    public void clickLoginButtonOnHomepage(){
        onClick(getLoginButtonOnHomepage());
    }

    public String checkEmailUnregisteredError(){
        return waitUntilVisible(getEmailUnregisteredError()).getAttribute("content-desc");
    }
    public void fillEmailForm(String email){
        onClick(getEmailForm());
        onType(getEmailForm(),email);
    }
    public void fillPasswordForm(String password){
        onClick(getPasswordForm());
        onType(getPasswordForm(),password);
    }
    public void clickLoginButton(){
        onClick(getLoginSubmitButton());
    }
    public boolean checkEmailError(){
        return waitUntilVisible(getEmailError()).isDisplayed();
    }
    public boolean checkPasswordError(){
        return waitUntilVisible(getPasswordError()).isDisplayed();
    }
}
