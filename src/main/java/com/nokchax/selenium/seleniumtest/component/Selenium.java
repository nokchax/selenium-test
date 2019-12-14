package com.nokchax.selenium.seleniumtest.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Selenium {
    @PostConstruct
    public void init() {
        System.out.println("test");

        // do crawl

        // update db using crawled data
    }
}
