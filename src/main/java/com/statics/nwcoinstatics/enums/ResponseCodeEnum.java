package com.statics.nwcoinstatics.enums;

public enum ResponseCodeEnum {

    // 系统通用
    SUCCESS(200, "success"),

    ERROR(500, "error");


    private Integer code;
    private String message;

    ResponseCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

}