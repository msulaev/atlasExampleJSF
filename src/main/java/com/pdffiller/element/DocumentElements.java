package com.pdffiller.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


public interface DocumentElements {
    Logger logger
            = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy("//*[contains(@class, ('is-focused'))]//textarea")
    AtlasWebElement activeField();

    default void clickActiveField() {
        logger.info("active filed element selector //*[contains(@class, ('is-focused'))]//textarea");
        activeField().click();
    }

}
