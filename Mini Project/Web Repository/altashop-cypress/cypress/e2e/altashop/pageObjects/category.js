class CategoryPage{
    getCategoryButton(){
        return cy.get(".v-input__slot");
    }   

    getAllCategories(){
        return cy.get('.v-list-item');
    }

    getDesignatedCategoryOption(nthChild){
        return cy.get(`.v-list-item:nth-of-type(${nthChild}) .v-list-item__title`);
    }

    getCategoryPlaceholder(){
        return cy.get(".v-select__selection");
    }

    getRemoveCategoryButton(){
        return cy.get("button.v-icon")
    }
}
export default CategoryPage;