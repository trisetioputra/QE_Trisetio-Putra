import LoginPage from "../pageObjects/login";


class LoginPageNavigation{

    constructor(){
        this.loginPageObject = new LoginPage;
        this.email;
        this.password;
    }

    pressRegisterHyperlink(){
        this.loginPageObject.registerHyperlink().should('be.visible').click();
    }

    setEmail(email){
        this.email=email;
    }

    setPassword(password){
        this.password=password;
    }

    handleUnregistered(){
        cy.request({
            url:'https://altashop-api.fly.dev/api/auth/register',
            method: 'POST',
            body: {
                email: 'testingdev@gmail.com',
                password: 'testing123',
                fullname: 'testingman'
            },
            failOnStatusCode:false
        })
    }

    inputLoginFields(){
        this.handleUnregistered()
        cy.url().should('contain',"/login");
        if(this.email!="empty"){
            this.loginPageObject.getEmailForm().should('be.visible').type(this.email);
        }
        if(this.password!="empty"){
            this.loginPageObject.getPasswordForm().should('be.visible').type(this.password);
        }
    }

    pressLoginButton(){
        this.loginPageObject.getLoginButton().click();
    }

    checkErrorMessage(errorMessage){
        this.loginPageObject.getErrorMessage().should('contain.text',errorMessage);
    }

    pressLogoutOption(){
        this.loginPageObject.getUserButton().click();
        this.loginPageObject.getLogoutButton().should('be.visible').click();
    }
}

export default LoginPageNavigation;