package com.nokchax.selenium.seleniumtest;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.chrome.ChromeDriverService.*;

public class LoadFileInJarTest {
    private boolean verbose = Boolean.getBoolean(CHROME_DRIVER_VERBOSE_LOG_PROPERTY);
    private boolean silent = Boolean.getBoolean(CHROME_DRIVER_SILENT_OUTPUT_PROPERTY);
    private String whitelistedIps = System.getProperty(CHROME_DRIVER_WHITELISTED_IPS_PROPERTY);

    @Test
    public void loadFileInJar() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.merge(DesiredCapabilities.operaBlink());

        WebDriver browser = new ChromeDriver(ChromeDriverService.createDefaultService(), options);

        browser.get("https://naver.com");

        assertEquals("Naver", browser.getTitle());
    }


    private ChromeDriverService createNewChromeDriverService() {
        File executable = null;
        int port = 12345;
        ImmutableList<String> args = createArgs();
        ImmutableMap<String, String> environment;

//        ChromeDriverService chromeDriverService = new ChromeDriverService().;

//        return chromeDriverService;

        ChromeDriver driver = new ChromeDriver();
        return null;
    }


    private ImmutableList<String> createArgs() {
        ImmutableList.Builder<String> argsBuilder = ImmutableList.builder();
        argsBuilder.add(String.format("--port=%d", 12345));

        if (verbose) {
            argsBuilder.add("--verbose");
        }
        if (silent) {
            argsBuilder.add("--silent");
        }
        if (whitelistedIps != null) {
            argsBuilder.add(String.format("--whitelisted-ips=%s", whitelistedIps));
        }

        return argsBuilder.build();
    }
}
