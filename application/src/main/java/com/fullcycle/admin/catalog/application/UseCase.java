package com.fullcycle.admin.catalog.application;

import com.fullcycle.admin.catalog.domain.Category;

public class UseCase {
    public Category execute() {
        return new Category();
    }
}