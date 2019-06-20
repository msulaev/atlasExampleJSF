package com.pdffiller.extension;

import io.github.bonigarcia.seljup.SeleniumExtension;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

@ExtendWith(SeleniumExtension.class)
public class AtlasExtension implements BeforeAllCallback {
    SeleniumExtension seleniumExtension = new SeleniumExtension();
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        seleniumExtension.addBrowsers();
    }

    private Atlas getAtlas(RemoteWebDriver driver){
        return new Atlas(new WebDriverConfiguration(driver, "http://192.168.1.120:3002/"));

    }

}
