import LandingPage from "../pageObjects/landing";


class LandingPageNavigation{

    constructor(){
        this.pageUrl= "https://alta-shop.vercel.app/";
        this.landingPageObject = new LandingPage();
    }

    openPage() {
        cy.visit(this.pageUrl);
        
    }

    checkProductCardIsMoreThanOne(){
        this.landingPageObject.getAllCardTitle().should('have.length.above',1);
    }

    checkDesignatedProductCard(nProduct){
        this.landingPageObject.getDesignatedProductCard(nProduct).should('be.visible');
        this.landingPageObject.getDesignatedProductTitle(nProduct).should('be.visible');
    }

    checkDesignatedProductAttributes(nProduct){
        this.landingPageObject.getDesignatedProductTitle(nProduct).should('be.visible');
        this.landingPageObject.getDesignatedProductDescription(nProduct).should('be.visible');
        this.landingPageObject.getDesignatedProductPrice(nProduct).should('be.visible');
    }

    pressLoginIcon(){
        this.landingPageObject.getLoginButton().should('be.visible').click();
    }
    pressTransactionButton(){
        this.landingPageObject.getUserButton().click();
        this.landingPageObject.getTransactionButton().should('be.visible').click();
    }
    checkUserButton(){
        this.landingPageObject.getUserButton().should('be.visible');
        cy.reload();
    }
}
export default LandingPageNavigation;