class CartPage{
    getDesignatedProductTitles(nthChild){
        return cy.get(`.v-list-item:nth-of-type(${nthChild}) .v-list-item__title`);
    }
    getDesignatedProductQuantity(nthChild){
        return cy.get(`.v-list-item:nth-of-type(${nthChild}) .label-quantity`);
    }
    getDesignatedIncreaseButton(nthChild){
        return cy.get(`.v-list-item:nth-of-type(${nthChild}) button:nth-of-type(2)`);
    }
    getDesignatedDecreaseButton(nthChild){
        return cy.get(`.v-list-item:nth-of-type(${nthChild}) button:nth-of-type(1)`);
    }
    getDesignatedProductPrice(nthChild){
        return cy.get(`.v-list-item:nth-of-type(${nthChild}) .label-price`);
    }
    getTotalQuantity(){
        return cy.get(`#label-total-quantity`);
    }
    getTotalPrice(){
        return cy.get(`#label-total-bayar`);
    }
    getEmptyCartWording(){
        return cy.get('.v-alert__content');
    }
    getPayButton(){
        return cy.get("#button-bayar")
    }
}
export default CartPage;