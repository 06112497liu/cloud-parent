package com.lwb.cloud.hello.service.result;

import com.lwb.cloud.hello.service.enums.ResponseStatus;

/**
 * @author liuweibo
 * @date 2019/6/23
 */
public interface ResultUtil {

    static Result ok() {
        Result rs = new Result<>();
        return rs;
    }

    static <T> Result<T> ok(T data) {
        Result<T> rs = new Result<>();
        rs.setData(data);
        return rs;
    }

    static Result fail(int code, String msg) {
        Result rs = new Result();
        rs.setCode(code);
        rs.setMsg(msg);
        return rs;
    }

    static Result fail(ResponseStatus status) {
        Result rs = new Result();
        rs.setCode(status.getCode());
        rs.setMsg(status.getMsg());
        return rs;
    }

    static Result failForIllegalParam(ResponseStatus status, String detailMsg) {
        Result rs = new Result();
        rs.setCode(status.getCode());
        rs.setMsg(
            String.format(status.getMsg(), detailMsg)
        );
        return rs;
    }
}
