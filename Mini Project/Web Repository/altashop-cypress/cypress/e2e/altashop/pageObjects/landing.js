class LandingPage{
    getDesignatedProductCard(nCard){
        return cy.get(`.col-6:nth-of-type(${nCard})`);
    }
    getAllCardTitle(){
        return cy.get('.col-6 .product-title');
    }
    getDesignatedProductTitle(nCard){
        return cy.get(`.col-6:nth-of-type(${nCard}) .product-title`);
    }
    getDesignatedProductPrice(nCard){
        return cy.get(`.col-6:nth-of-type(${nCard}) .product-price`);
    }
    getDesignatedProductDescription(nCard){
        return cy.get(`.col-6:nth-of-type(${nCard}) .product-description`);
    }
    getDesignatedDetailButton(nthChild){
        return cy.get(`.col-6:nth-of-type(${nthChild}) .button-beli:nth-of-type(1)`);
    }
    getDesignatedBuyButton(nthChild){
        return cy.get(`.col-6:nth-of-type(${nthChild}) .button-beli:nth-of-type(2)`);
    }
    getCartIconCount(){
        return cy.get(".v-badge__badge")
    }
    getLoginButton(){
        return cy.get(".fa-sign-in")
    }
    getUserButton(){
        return cy.get(".fa-user")
    }
    getTransactionButton(){
        return cy.get('.v-list-item__title').contains("Transaksi");
    }
}
export default LandingPage;