class TransactionPage{
    getDesignatedTransactionDataRow(nthType){
        return cy.get(`tr:nth-of-type(${nthType})`);
    }
    getAllTransactionVisible(){
        return cy.get(`tbody tr`);
    }
    getFooterCount(){
        return cy.get(".v-data-footer__pagination");
    }
    getRowLengthChangeButton(){
        return cy.get('.fa-caret-down');
    }
    getRowLenOption(length){
        return cy.get(`.v-list-item__title`).contains(length);
    }
    getSpecifiedChevronButton(direction){
        return cy.get(`.fa-chevron-${direction}`);
    }
}

export default TransactionPage;