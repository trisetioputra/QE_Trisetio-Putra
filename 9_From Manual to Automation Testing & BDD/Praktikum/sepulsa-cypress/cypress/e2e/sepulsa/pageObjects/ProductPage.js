class ProductPage{
    getPageTitle(){
        return cy.get('.title-main');
    }
    getPhoneNumberForm(){
        return cy.get('#phone_number');
    }
    getPulsaProduct(){
        return cy.get('.nominal-item').contains("Rp100.000")
    }
}
export default ProductPage;