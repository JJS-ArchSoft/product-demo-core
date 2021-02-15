package com.jjsarchsoft.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class WebDatabaseServiceApplication {

    public static void main(String[] args) {
        log.info("Starting web database service");
        SpringApplication.run(WebDatabaseServiceApplication.class, args);
    }

}
