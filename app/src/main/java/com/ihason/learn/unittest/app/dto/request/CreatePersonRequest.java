package com.ihason.learn.unittest.app.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreatePersonRequest {

    @NotBlank
    private String name;

    private Integer age;

}
