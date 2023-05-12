import RegisterPage from "../pageObjects/register";


class RegisterPageNavigation{

    constructor(){
        this.registerPageObject = new RegisterPage;
        this.characters ='ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        this.email="testing"+this.generateRandomString(15)+"@gmail.com";
        this.password;
    }

    generateRandomString(length) {
        let result = '';
        const charactersLength = this.characters.length;
        for ( let i = 0; i < length; i++ ) {
            result += this.characters.charAt(Math.floor(Math.random() * charactersLength));
        }
    
        return result;
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


    inputRegistrationFields(fullname, password, email){
        this.email="testing"+this.generateRandomString(15)+"@gmail.com";
        //need to check url to make sure cypress already on register page before giving input
        cy.url().should('include','auth/register');
        this.password=password;
        if(fullname!="empty"){
            this.registerPageObject.getFullNameForm().should('be.visible').type(fullname);
        }
        if(email!="empty"){
            if(email=="randomized email"){
                this.registerPageObject.getEmailForm().should('be.visible').type(this.email);
            }
            else{
                this.handleUnregistered();
                this.registerPageObject.getEmailForm().should('be.visible').type(email);
            }
        }
        if(password!="empty"){
            this.registerPageObject.getPasswordForm().should('be.visible').type(password);
        }
    }

    checkWarningIconExist(){
        this.registerPageObject.getWarningIcon().should('be.visible');
    }

    pressRegisterButton(){
        this.registerPageObject.getRegisterButton().click();
    }

}
export default RegisterPageNavigation;