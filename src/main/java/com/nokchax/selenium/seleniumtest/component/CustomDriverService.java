package com.nokchax.selenium.seleniumtest.component;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.chrome.ChromeDriverService.*;

public class CustomDriverService extends DriverService {

    public CustomDriverService(String filePath) throws IOException {
        super(new File(filePath), 1234, createArgs(), ImmutableMap.of());
    }

    protected CustomDriverService(File executable, int port, ImmutableList<String> args, ImmutableMap<String, String> environment) throws IOException {
        super(executable, port, args, environment);
    }

    private static ImmutableList<String> createArgs() {
        ImmutableList.Builder<String> argsBuilder = ImmutableList.builder();
        argsBuilder.add(String.format("--port=%d", 12345));

        if (Boolean.getBoolean(CHROME_DRIVER_VERBOSE_LOG_PROPERTY)) {
            argsBuilder.add("--verbose");
        }
        if (Boolean.getBoolean(CHROME_DRIVER_SILENT_OUTPUT_PROPERTY)) {
            argsBuilder.add("--silent");
        }
        if (System.getProperty(CHROME_DRIVER_WHITELISTED_IPS_PROPERTY) != null) {
            argsBuilder.add(String.format("--whitelisted-ips=%s", System.getProperty(CHROME_DRIVER_WHITELISTED_IPS_PROPERTY)));
        }

        return argsBuilder.build();
    }
}
