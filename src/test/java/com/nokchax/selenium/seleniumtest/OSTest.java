package com.nokchax.selenium.seleniumtest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OSTest {
    @Test
    void mac() {
        String property = System.getProperty("os.name");

        assertThat(property).startsWith("Mac OS");
    }

    //ubuntu's os.name = Linux
}
