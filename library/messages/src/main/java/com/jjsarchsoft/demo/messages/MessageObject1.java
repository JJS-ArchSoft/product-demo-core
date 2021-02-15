package com.jjsarchsoft.demo.messages;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class MessageObject1 {

    private String property1;
    private String property2;
    @NotEmpty
    private String property3;

}
