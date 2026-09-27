package com.cfec.antiepidemic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cfec.antiepidemic.*")
public class CfecJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CfecJavaApplication.class, args);
    }

}
