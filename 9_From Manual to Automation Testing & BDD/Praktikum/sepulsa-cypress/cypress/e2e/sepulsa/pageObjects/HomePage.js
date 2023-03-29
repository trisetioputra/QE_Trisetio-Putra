class HomePage{
    getProductIcon(product){
        return cy.get('.product-name').contains(product);
    }
}
export default HomePage;