package com.jjsarchsoft.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class WebMessageServiceApplication {

    public static void main(String[] args) {
        log.info("Starting web message service");
        SpringApplication.run(WebMessageServiceApplication.class, args);
    }

}
