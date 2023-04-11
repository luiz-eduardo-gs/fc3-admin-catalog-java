package com.fullcycle.admin.catalog.application;

import com.fullcycle.admin.catalog.domain.category.Category;

public class UseCase {
    public Category execute() {
        return Category.newCategory("", "", true);
    }
}