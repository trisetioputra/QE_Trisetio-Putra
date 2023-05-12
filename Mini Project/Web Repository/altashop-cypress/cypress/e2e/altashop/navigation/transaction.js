import TransactionPage from "../pageObjects/transaction";


class TransactionPageNavigation{

    constructor(){
        this.transactionPageObject = new TransactionPage;
    }

    checkHasTransactionData(){
        cy.reload();
        this.transactionPageObject.getFooterCount().should('be.visible');
        this.transactionPageObject.getDesignatedTransactionDataRow(1).should('be.visible');
    }

    checkOnTransactionPage(){
        cy.url().should('contain',"/transaction");
    }

    checkIsShowingCorrectDataAmount(length){
        this.transactionPageObject.getAllTransactionVisible().should('have.length',length);
    }

    changeRowLimitTo(length){
        this.transactionPageObject.getRowLengthChangeButton().should('be.visible').click();
        this.transactionPageObject.getRowLenOption(length).click();
    }
    
    checkDataStartCount(expectedStart){
        this.transactionPageObject.getFooterCount().should('contain.text',expectedStart);
    }

    pressChevronButton(direction){
        this.transactionPageObject.getSpecifiedChevronButton(direction).should('be.visible').click();
    }
}
export default TransactionPageNavigation;