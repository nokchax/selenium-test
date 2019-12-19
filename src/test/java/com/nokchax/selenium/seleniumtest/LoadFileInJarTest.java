package com.nokchax.selenium.seleniumtest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadFileInJarTest {
    @Test
    public void loadFileInJar() throws IOException, URISyntaxException {
        String property = System.getProperty("os.name");
        String driverPath = "/data/etc/webdriver/chromedriver";
        if(property.startsWith("Mac")) {
            driverPath = "/Users/nokchax" + driverPath;
        }

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.merge(DesiredCapabilities.operaBlink());

        WebDriver browser = new ChromeDriver(options);

        browser.get("https://naver.com");

        assertEquals("NAVER", browser.getTitle());
    }
}
