package com.fullcycle.admin.catalog.infrastructure;

import com.fullcycle.admin.catalog.application.UseCase;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
        System.out.println(new UseCase().execute());
    }
}