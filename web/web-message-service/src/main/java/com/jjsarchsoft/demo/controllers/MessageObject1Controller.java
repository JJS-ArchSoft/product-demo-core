package com.jjsarchsoft.demo.controllers;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import com.jjsarchsoft.demo.services.MessageObject1Service;
import com.jjsarchsoft.demo.messages.MessageObject1;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Log4j2
@RestController
@RequestMapping("/message")
@Validated
public class MessageObject1Controller {

    private final MessageObject1Service service;

    public MessageObject1Controller(MessageObject1Service service) {
        log.info("Instantiating message controller");
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody @Valid MessageObject1 message) {
        log.info("Executing controller to send message: {}", ReflectionToStringBuilder.toString(message, ToStringStyle.JSON_STYLE));
        service.sendMessage(message);
        return null;
    }

}
