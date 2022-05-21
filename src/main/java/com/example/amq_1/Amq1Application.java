package com.example.amq_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@ServletComponentScan
@EnableJms
public class Amq1Application {

    public static void main(String[] args) {
        SpringApplication.run(Amq1Application.class, args);
    }

}
