package com.nokchax.selenium.seleniumtest;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SeleniumTestApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder().web(WebApplicationType.NONE)
                .sources(SeleniumTestApplication.class)
                .run(args);
    }

}
