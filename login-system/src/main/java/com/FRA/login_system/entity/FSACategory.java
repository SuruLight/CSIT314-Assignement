package com.FRA.login_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fsa_categories")
public class FSACategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catId;

    private String catName;
    private String catDesc;

    public FSACategory() {}

    public String createFSACat(String catName, String catDesc) {
        this.catName = catName;
        this.catDesc = catDesc;

        return "FSA Category created successfully.";
    }

    public String getFSACategories() {
        return "Category ID: " + catId + ", Name: " + catName + ", Description: " + catDesc;
    }

    public String updateFSACategory(int categoryID, String categoryName, String categoryDescription) {

        this.catName = categoryName;
        this.catDesc = categoryDescription;

        return "FSA Category updated successfully.";
    }

    public String deleteFSACategory(int categoryID) {
        return "FSA Category deleted successfully.";
    }

    public String searchFSACategory(String keyword) {
        return "Category ID: " + catId + ", Name: " + catName + ", Description: " + catDesc;
    }

    public int getCatId() {
        return catId;
    }

    public String getCatName() {
        return catName;
    }

    public String getCatDesc() {
        return catDesc;
    }
}