package com.pdffiller.extension;

import driver.SelenoideDriverProvider;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

public class DriverExtension implements BeforeAllCallback {
    private Atlas atlas;
    private WebDriver driver;
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
         driver = new SelenoideDriverProvider().createDriver();
         atlas = new Atlas(new WebDriverConfiguration(driver, "http://192.168.1.120:3002/"));
    }
}
