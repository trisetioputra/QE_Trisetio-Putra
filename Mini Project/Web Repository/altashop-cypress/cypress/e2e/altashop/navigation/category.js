import CategoryPage from "../pageObjects/category";


class CategoryNavigation{

    constructor(){
        this.selectedCategoryName;
        this.categoryPageObject = new CategoryPage();
    }

    pressCategoryButton(){
        this.categoryPageObject.getCategoryButton().wait(3000).should('be.visible').click();
    }

    checkCategoryList(){
        this.categoryPageObject.getAllCategories().should('have.length.above',1);
    }

    pressFirstCategory(){
        this.categoryPageObject.getDesignatedCategoryOption(1).click().then($value=>{
            this.selectedCategoryName = $value.text();
        });
    }

    checkCategoryPlaceholder(){
        this.categoryPageObject.getCategoryPlaceholder().should('contain.text',this.selectedCategoryName);
    }

    pressRemoveCategoryButton(){
        this.categoryPageObject.getRemoveCategoryButton().should('be.visible').click().wait(2000);
    }

    checkEmptyCategoryPlaceholder(){
        this.categoryPageObject.getCategoryPlaceholder().should('not.exist');
    }
}
export default CategoryNavigation;