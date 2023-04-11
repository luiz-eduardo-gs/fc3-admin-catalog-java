package com.fullcycle.admin.catalog.domain.validation.handler;

import com.fullcycle.admin.catalog.domain.exceptions.DomainException;
import com.fullcycle.admin.catalog.domain.validation.Error;
import com.fullcycle.admin.catalog.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(final Error error) {
        throw DomainException.with(List.of(error));
    }

    @Override
    public ValidationHandler append(ValidationHandler handler) {
        throw DomainException.with(handler.getErrors());
    }

    @Override
    public ValidationHandler validate(Validation validation) {
        try {
            validation.validate();
        } catch(final Exception ex) {
            throw DomainException.with(List.of(new Error(ex.getMessage())));
        }

        return this;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
}
