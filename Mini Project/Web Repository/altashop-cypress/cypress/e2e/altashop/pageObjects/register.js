class RegisterPage{
    getFullNameForm(){
        return cy.get(".v-text-field:nth-of-type(1) input")
    }
    getEmailForm(){
        return cy.get(".v-text-field:nth-of-type(2) input")
    }
    getPasswordForm(){
        return cy.get(".v-text-field:nth-of-type(3) input")
    }
    getRegisterButton(){
        return cy.get(".v-btn.primary");
    }
    getWarningIcon(){
        return cy.get(".fa-exclamation-triangle");
    }
}

export default RegisterPage;