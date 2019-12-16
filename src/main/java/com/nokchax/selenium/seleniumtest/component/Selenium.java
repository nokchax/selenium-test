package com.nokchax.selenium.seleniumtest.component;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@Component
public class Selenium {
    @PostConstruct
    public void init() throws InterruptedException {
        System.out.println("Start Crawl");

        doCrawl();

        // do crawl

        // update db using crawled data
        System.out.println("End Crawl");
    }

    public void doCrawl() throws InterruptedException {
        ClassPathResource resource = new ClassPathResource("/chromedriver");
        System.setProperty("webdriver.chrome.driver", resource.getPath());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // change user agent using randomization or round robin each request
        options.merge(DesiredCapabilities.operaBlink());
        WebDriver browser = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(browser, 20);
        browser.get("https://leetcode.com/accounts/login/");


        WebElement id = browser.findElement(By.name("login"));
        WebElement password = browser.findElement(By.name("password"));
        Thread.sleep(2000);

        id.click();
        humanizeTyping(id, "");
        Thread.sleep(300);
        id.sendKeys(Keys.TAB);
        password.clear();
        humanizeTyping(password, "");
        Thread.sleep(300);
        password.sendKeys(Keys.RETURN);
//        button.click();

        wait.until(presenceOfElementLocated(By.xpath("//*[@id=\"nav-user-app\"]")));
        browser.navigate().to("https://leetcode.com/api/problems/all/");
        WebElement body = browser.findElement(By.tagName("body"));

//        log.info(body.getText());
        System.out.println(body.getText());

        browser.close();
}

    private void humanizeTyping(WebElement element, String input) throws InterruptedException {
        for(char c : input.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            Thread.sleep(ThreadLocalRandom.current().nextLong(100) + 100);
        }
    }
}
