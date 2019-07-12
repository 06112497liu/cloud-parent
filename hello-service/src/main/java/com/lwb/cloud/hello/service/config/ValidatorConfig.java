package com.lwb.cloud.hello.service.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * @author liuweibo
 * @date 2019/6/23
 */
@Configuration
public class ValidatorConfig {

    @Bean
    public Validator validator() {
        return
            Validation.byProvider(HibernateValidator.class)
                .configure()
                // 校验快速失败
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();
    }
}
