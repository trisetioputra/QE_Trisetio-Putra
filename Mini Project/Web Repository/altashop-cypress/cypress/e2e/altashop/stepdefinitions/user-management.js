import {Given, When, And, Then} from "cypress-cucumber-preprocessor/steps";
import { should } from "chai";
import LoginPageNavigation from "../navigation/login";
import RegisterPageNavigation from "../navigation/register";

const registraterPageNav= new RegisterPageNavigation();

const loginPageNav= new LoginPageNavigation();


And("I press register hyperlink",()=>{
    loginPageNav.pressRegisterHyperlink();
})

And("I enter valid full name as {}, password as {}, and email as: {}",(fullname, password, email)=>{
    registraterPageNav.inputRegistrationFields(fullname,password, email);
})

And("I press register button",()=>{
    registraterPageNav.pressRegisterButton();
})

When("I use the same credentials on the email and password form",()=>{
    loginPageNav.setEmail(registraterPageNav.email);
    loginPageNav.setPassword(registraterPageNav.password);
    loginPageNav.inputLoginFields();
})

When("I use different credentials on the email and password form",()=>{
    loginPageNav.setEmail(registraterPageNav.email);
    loginPageNav.setPassword("testsalah");
    loginPageNav.inputLoginFields();
})

And("I enter {} credentials on form: {} and {}",(type,email,password)=>{
    loginPageNav.setEmail(email);
    loginPageNav.setPassword(password);
    loginPageNav.inputLoginFields();
})

And("I enter unregistered credentials on form",()=>{
    loginPageNav.setEmail(registraterPageNav.email);
    loginPageNav.setPassword("testing123");
    loginPageNav.inputLoginFields();
})

And("I press login submit button",()=>{
    loginPageNav.pressLoginButton();
})

And("I enter invalid datas: full name as {}, password as {}, and email as {}",(fullname, password, email)=>{
    registraterPageNav.inputRegistrationFields(fullname,password,email);
})

Then("I will see warning icon",()=>{
    registraterPageNav.checkWarningIconExist();
})

And("I will see error message for {}", (error)=>{
    loginPageNav.checkErrorMessage(error);
})

When("I press logout option",()=>{
    loginPageNav.pressLogoutOption();
})
