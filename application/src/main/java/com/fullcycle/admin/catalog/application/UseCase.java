package com.fullcycle.admin.catalog.application;

import com.fullcycle.admin.catalog.domain.category.Category;

public abstract class UseCase <IN, OUT> {
    public abstract OUT execute(IN in);
}