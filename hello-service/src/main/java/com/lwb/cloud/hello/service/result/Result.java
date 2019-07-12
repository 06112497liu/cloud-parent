package com.lwb.cloud.hello.service.result;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @author liuweibo
 * @date 2019/6/23
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Result<T> implements Serializable{

    private int    code = 0;
    private String msg  = "ok";
    private T data;

}
