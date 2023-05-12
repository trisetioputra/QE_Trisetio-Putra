import CartPage from "../pageObjects/cart";
import LandingPage from "../pageObjects/landing";

class CartNavigation{

    constructor(){
        this.cartPage = new CartPage();
        this.landingPage =new LandingPage();
        this.multipleCounts = 4;
        this.productTitleArray=[];
        this.expectedTotalQuantity=1;
        this.expectedTotalPrice=0;
    }

    pressBuyButtonForMultipleProducts(){
        for(let i=1;i<=this.multipleCounts;i++){
            this.landingPage.getDesignatedBuyButton(i).should('be.visible').click();
            this.landingPage.getDesignatedProductTitle(i).then(($value)=>{
                this.productTitleArray.push($value.text());
            })
        }
    }

    pressBuyForSampleProducts(){
        this.landingPage.getDesignatedBuyButton(1).should('be.visible').click();
    }

    checkEmptyProductWording(){
        this.cartPage.getEmptyCartWording().should('contain.text',"Order is empty!").click();
    }

    editQuantityHandler(type, times){
        if(type=="increase"){
            this.expectedTotalQuantity=parseInt(times)+1;
            this.cartPage.getDesignatedProductPrice(1).then($value=>{
                var productPrice=$value.text();
                this.expectedTotalPrice=parseInt(productPrice)*parseInt(this.expectedTotalQuantity);
            })
            for(let i=1;i<=times;i++){
                this.cartPage.getDesignatedIncreaseButton(1).click();
            }
        }
        else if(type=="increase and decrease"){
            this.expectedTotalQuantity=1;
            this.cartPage.getDesignatedProductPrice(1).then($value=>{
                var productPrice=$value.text();
                this.expectedTotalPrice=parseInt(productPrice);
            })
            for(let i=1;i<=times;i++){
                this.cartPage.getDesignatedIncreaseButton(1).click();
            }
            for(let i=1;i<=times;i++){
                this.cartPage.getDesignatedDecreaseButton(1).click();
            }
        }
        else{
            this.cartPage.getDesignatedDecreaseButton(1).click();
        }
    }

    checkQuantityHandler(type, times){
        var expectedTimes;
        if(type=="increase"){
            //+1 due to default of 1 quantity
            expectedTimes=Number(times)+1;
            for(let i=1;i<=times;i++){
                this.cartPage.getDesignatedProductQuantity(1).should('have.text',expectedTimes.toString());
            }
        }
    }

    checkTotalsHandler(){
        this.cartPage.getTotalQuantity().should('have.text',this.expectedTotalQuantity.toString());
        this.cartPage.getTotalPrice().should('have.text',this.expectedTotalPrice.toString());
    }

    pressBuyButtonForSameProductMultipleTimes(){
        for(let i=1;i<=this.multipleCounts;i++){
            this.landingPage.getDesignatedBuyButton(1).should('be.visible').click();
        }
    }

    pressPayButton(){
        this.cartPage.getPayButton().should('be.visible').click().wait(3000);
    }

    checkIsOnLoginPage(){
        cy.url().should('include','auth/login')
    }

    checkCartIconCount(){
        this.landingPage.getCartIconCount().should('have.text',this.multipleCounts.toString());
    }

    checkCartIconCountNotIncreasing(){
        this.landingPage.getCartIconCount().should('have.text',"1");
    }

    pressCartIcon(){
        this.landingPage.getCartIconCount().click();
    }

    checkMatchingProductTitles(){
        for(let i=1;i<=this.multipleCounts;i++){
            const expectedProductTitle=this.productTitleArray[i-1]+"";
            this.cartPage.getDesignatedProductTitles(i).should('have.text',expectedProductTitle.trim());
        }
    }

    checkMatchingQuantitiesPerClick(){
        this.cartPage.getDesignatedProductQuantity(1).should('have.text',this.multipleCounts.toString());
    }
}
export default CartNavigation;