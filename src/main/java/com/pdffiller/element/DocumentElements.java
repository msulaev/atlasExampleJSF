package com.pdffiller.element;

import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.slf4j.Logger;

import java.lang.invoke.MethodHandles;

import static org.slf4j.LoggerFactory.getLogger;


public interface DocumentElements {
    Logger logger = getLogger(MethodHandles.lookup().lookupClass());

    @Retry(timeout = 2000, polling = 1000)
    @FindBy("//*[contains(@class, ('is-focused'))]//textarea")
    AtlasWebElement activeField();

    default void clickActiveField() {
        logger.info("active filed element selector //*[contains(@class, ('is-focused'))]//textarea");
        activeField().click();
    }
}
