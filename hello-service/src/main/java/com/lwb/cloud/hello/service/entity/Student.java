package com.lwb.cloud.hello.service.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author liuweibo
 * @date 2019/6/23
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @NotNull(message = "id不能为空")
    Long id;
    @Length(max = 1)
    String name;

}
