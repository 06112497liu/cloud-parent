package com.lwb.cloud.client1.controller;

import com.lwb.cloud.client1.entity.Student;
import com.lwb.cloud.client1.enums.ResponseStatus;
import com.lwb.cloud.client1.result.Result;
import com.lwb.cloud.client1.result.ResultUtil;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author liuweibo
 * @date 2019/6/23
 */
@RestController
@RequestMapping("/student")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class StudentController {

    @PutMapping("/create")
    public Result<Student> create(@RequestBody @Validated Student student) {
        return ResultUtil.ok(student);
    }

    @GetMapping()
    public Result<Student> get(@NotNull(message = "学生id不能为空") String id) {
        return ResultUtil.ok();
    }

}
