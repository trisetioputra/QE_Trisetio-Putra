package test.automation.pages;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import test.automation.pageobject.BasePageObject;

public class RegistrationScreen extends BasePageObject {
    private By getFullnameForm(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
    }
    private By getEmailForm(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
    }
    private By getPasswordForm(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]");
    }
    private By getLoginButtonOnHomepage(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    }
    private By getRegisterHyperlink(){
        return MobileBy.xpath("//android.widget.Button[@index=5]");
    }
    private By registrationPageTitle(){
        return MobileBy.xpath("//android.view.View[@content-desc='Register']");
    }
    private By getRegisterSubmitButton(){
        return MobileBy.xpath("//android.widget.Button[@index=4]");
    }
    private By getPageTitle(){
        return MobileBy.xpath("//android.view.View[@content-desc='Products']");
    }

    private By getFullNameError(){
        return MobileBy.xpath("//android.view.View[@content-desc='fullname can not empty']");
    }

    private By getEmailError(){
        return MobileBy.xpath("//android.view.View[@content-desc='email can not empty']");
    }

    private By getPasswordError(){
        return MobileBy.xpath("//android.view.View[@content-desc='password can not empty']");
    }

    public void clickRegisterHyperlink(){
        onClick(getRegisterHyperlink());
    }

    public boolean isOnHomepage(){
        return waitUntilVisible(getPageTitle()).isDisplayed();
    }

    public boolean isOnRegistrationPage(){
        return waitUntilVisible(registrationPageTitle()).isDisplayed();
    }

    public void fillFullNameForm(String fullName){
        onClick(getFullnameForm());
        clear(getFullnameForm());
        onType(getFullnameForm(),fullName);
    }
    public void fillEmailForm(String email){
        onClick(getEmailForm());
        clear(getEmailForm());
        onType(getEmailForm(),email);
    }
    public void fillPasswordForm(String password){
        onClick(getPasswordForm());
        clear(getPasswordForm());
        onType(getPasswordForm(),password);
    }

    public void clickRegisterButton(){
        onClick(getRegisterSubmitButton());
    }

    public void clickLoginButtonOnHomepage(){
        onClick(getLoginButtonOnHomepage());
    }

    public boolean checkFullNameError(){
        return waitUntilVisible(getFullNameError()).isDisplayed();
    }
    public boolean checkEmailError(){
        return waitUntilVisible(getEmailError()).isDisplayed();
    }
    public boolean checkPasswordError(){
        return waitUntilVisible(getPasswordError()).isDisplayed();
    }
}
