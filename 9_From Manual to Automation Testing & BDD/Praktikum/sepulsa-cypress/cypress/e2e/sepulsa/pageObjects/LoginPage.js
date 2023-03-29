class LoginPage{
    getEmailForm(){
        return cy.get('#email');
    }
    getPasswordForm(){
        return cy.get('#password');
    }
    getSubmitForm(){
        return cy.get('.signup-button');
    }
    getErrorMessage(){
        return cy.get('#alert_description');
    }
}
export default LoginPage;