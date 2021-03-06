package com.jjsarchsoft.demo.services.implementations;

import com.jjsarchsoft.demo.messages.MessageObject1;
import com.jjsarchsoft.demo.services.interfaces.MessageObject1Service;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MessageObject1ServiceImpl implements MessageObject1Service {

    @Override
    public boolean sendMessage(MessageObject1 object) {
        log.info("Sending object {}", ReflectionToStringBuilder.toString(object, ToStringStyle.JSON_STYLE));
        return true;
    }

}
