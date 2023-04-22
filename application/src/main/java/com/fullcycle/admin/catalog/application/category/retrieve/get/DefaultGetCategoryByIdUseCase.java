package com.fullcycle.admin.catalog.application.category.retrieve.get;

import com.fullcycle.admin.catalog.domain.category.CategoryGateway;
import com.fullcycle.admin.catalog.domain.category.CategoryID;
import com.fullcycle.admin.catalog.domain.exceptions.DomainException;
import com.fullcycle.admin.catalog.domain.validation.Error;

import java.util.Objects;
import java.util.function.Supplier;

public class DefaultGetCategoryByIdUseCase extends GetCategoryByIdUseCase {

    private CategoryGateway categoryGateway;

    public DefaultGetCategoryByIdUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public CategoryOutput execute(final String id) {
        final var categoryId = CategoryID.from(id);

        return this.categoryGateway
                .findById(categoryId)
                .map(CategoryOutput::from)
                .orElseThrow(notFound(categoryId));
    }

    private Supplier<DomainException> notFound(final CategoryID id) {
        return () -> DomainException.with(new Error("Category with ID %s was not found".formatted(id.getValue())));
    }
}
