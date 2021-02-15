package com.jjsarchsoft.demo.models;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class ModelObject1 {

    private Long id;
    @NotEmpty
    private String property1;
    private String property2;

}
