package com.drey.ussdapp.domains.enums;

import java.util.Optional;

public enum AccountType {
    SAVINGS("SAVINGS"), CURRENT("CURRENT");

    AccountType(String name) {
        this.name = name;
    }

    private final String name;

    public static Optional<AccountType> getType(String name) {
        for (AccountType v : values()) {
            if (v.name.equalsIgnoreCase(name)) {
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }
}
