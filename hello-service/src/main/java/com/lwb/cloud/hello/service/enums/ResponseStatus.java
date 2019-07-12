package com.lwb.cloud.hello.service.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * @author liuweibo
 * @date 2019/6/23
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public enum ResponseStatus {

    OK(0, "ok"),
    ILLEGAL_PARAM(401, "参数非法：%s"),
    UNKNOWN_EX(5000, "未知异常");

    private int code;
    private String msg;

    ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
