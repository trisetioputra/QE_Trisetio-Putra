class DetailPage{
    getProductTitle(){
        return cy.get(`.text-h4`);
    }
    getProductPrice(){
        return cy.get(`.v-card__text p b`);
    }
    getRatingIcons(){
        return cy.get(`.v-rating`);
    }
    getRatingCounts(){
        return cy.get(`.text-caption`);
    }
}
export default DetailPage;