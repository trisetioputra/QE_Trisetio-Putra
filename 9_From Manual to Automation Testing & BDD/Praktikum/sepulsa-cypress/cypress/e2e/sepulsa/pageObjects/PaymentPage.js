class PaymentPage{
    getEmailForm(){
        return cy.get('#guest_email');
    }
    getPaymentMethod(){
        return cy.get('.MuiListItem-gutters').first();
    }
    getPayNowButton(){
        return cy.get('#submit_payment');
    }
}
export default PaymentPage;