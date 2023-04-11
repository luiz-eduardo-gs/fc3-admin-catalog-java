package com.fullcycle.admin.catalog.domain;

import com.fullcycle.admin.catalog.domain.validation.ValidationHandler;

public abstract class AggregateRoot<ID extends Identifier> extends Entity<ID>{
    protected AggregateRoot(final ID id) {
        super(id);
    }
}
