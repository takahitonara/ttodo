package com.takahitonara.ttodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class App {

    public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
    }
}