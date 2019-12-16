package com.nokchax.selenium.seleniumtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SeleniumTestApplication {

    // TODO: 2019/12/14 run this app using below
    // https://www.baeldung.com/run-shell-command-in-java
    // https://www.mkyong.com/java/how-to-execute-shell-command-from-java/
    public static void main(String[] args) {
        new SpringApplicationBuilder().web(WebApplicationType.NONE)
                .sources(SeleniumTestApplication.class)
                .run(args);
    }

}
