package com.emerald000.cluehelper.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ConfigFloorNumbering {
    AMERICAN("US"),
    BRITISH("UK");

    private final String type;

    @Override
    public String toString() {
        return type;
    }
}
