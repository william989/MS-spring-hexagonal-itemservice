package com.freetech.items.itemservice.application.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Error {
    private String code;
    private String message;
    private String cause;
}
