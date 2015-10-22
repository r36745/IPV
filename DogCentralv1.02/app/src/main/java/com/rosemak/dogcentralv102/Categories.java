package com.rosemak.dogcentralv102;

/**
 * Created by stevierose on 10/19/15.
 */
public class Categories {

    private String categoryName;


    public Categories (String _categoryName) {

        categoryName = _categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
