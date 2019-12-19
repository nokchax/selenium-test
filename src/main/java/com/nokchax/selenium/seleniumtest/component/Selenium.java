package com.nokchax.selenium.seleniumtest.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Selenium {
    @PostConstruct
    public void init() {
        System.out.println("Start Crawl");

        doCrawl();

        System.out.println("End Crawl");
    }


    public void doCrawl() {
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
        System.out.println(browser.getTitle());
        browser.close();
    }
}
