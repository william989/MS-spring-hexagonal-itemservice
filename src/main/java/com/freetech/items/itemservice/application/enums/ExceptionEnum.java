package com.freetech.items.itemservice.application.enums;

import lombok.Getter;

@Getter
public enum ExceptionEnum {
    ERROR_CREATE_ITEM("60001", "Error creating item");

    private String code;
    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
