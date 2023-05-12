class LoginPage{
    registerHyperlink(){
        return cy.get(`a[href*="register"]`)
    }
    getEmailForm(){
        return cy.get(".v-text-field:nth-of-type(1) input")
    }
    getPasswordForm(){
        return cy.get(".v-text-field:nth-of-type(2) input")
    }
    getLoginButton(){
        return cy.get(".text-center > .v-btn");
    }
    getErrorMessage(){
        return cy.get('.v-alert__content');
    }
    getUserButton(){
        return cy.get(".fa-user");
    }
    getLogoutButton(){
        return cy.get('.v-list-item__title').contains("Logout");
    }
}

export default LoginPage;