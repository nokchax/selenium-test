package com.nokchax.selenium.seleniumtest;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * test that what kind of user agent can be applied with chrome web driver
 */
public class UserAgentTest {
    private WebDriver browser;

    @Test
    void chrome() {
        initOption(DesiredCapabilities.chrome());
    }

    @Test
    void opera() {
        initOption(DesiredCapabilities.operaBlink());
    }

    @Test
    void firefox() {
        initOption(DesiredCapabilities.firefox());
    }

    @Test
    void safari() {
        initOption(DesiredCapabilities.safari());
    }

    @AfterEach
    void crawlPage() {
        browser.get("https://en.wikipedia.org/wiki/World_Wide_Web");

        assertEquals("World Wide Web - Wikipedia", browser.getTitle());
    }

    private void initOption(DesiredCapabilities userAgent) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/webdriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // change user agent using randomization or round robin each request
        options.merge(userAgent);
        browser = new ChromeDriver(options);
    }

    //not work
//    @Test
//    void edge() {
//        initOption(DesiredCapabilities.edge());
//    }
//
//    @Test
//    void ie() {
//        initOption(DesiredCapabilities.internetExplorer());
//    }
}
