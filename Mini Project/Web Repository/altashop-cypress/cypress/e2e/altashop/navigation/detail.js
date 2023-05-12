import DetailPage from "../pageObjects/detail";
import LandingPage from "../pageObjects/landing";

class DetailNavigation{

    constructor(){
        this.detailPageObject = new DetailPage();
        this.productTitleOnCard;
        this.landingPage =new LandingPage();
    }
    pressDetailButton(){
        this.landingPage.getDesignatedProductTitle(1).then(($value)=>{
            this.productTitleOnCard=$value.text();
        })
        this.landingPage.getDesignatedDetailButton(1).should('be.visible').click();
    }
    checkMatchingDetailPageTitle(){
        this.detailPageObject.getProductTitle().should('contain.text',this.productTitleOnCard.trim());
    }
    checkDetailPageComponents(){
        this.detailPageObject.getProductPrice().should('be.visible');
        this.detailPageObject.getRatingIcons().should('be.visible');
        this.detailPageObject.getRatingCounts().should('be.visible');
    }

}
export default DetailNavigation;