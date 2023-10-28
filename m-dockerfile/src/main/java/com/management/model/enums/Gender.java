package com.management.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("E"),
    FEMALE("K");
    private final String gender;
}
