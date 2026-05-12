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