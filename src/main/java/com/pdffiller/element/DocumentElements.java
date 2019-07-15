package com.pdffiller.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import org.slf4j.Logger;

import java.lang.invoke.MethodHandles;

import static org.slf4j.LoggerFactory.getLogger;

public interface DocumentElements {
    Logger logger = getLogger(MethodHandles.lookup().lookupClass());

    @FindBy("//*[contains(@class, ('is-focused'))]//textarea")
    AtlasWebElement activeField();

    @FindBy("//div[@class='page-Page pageActive-Pagination']//div[@class='elementsWrapper-Content']")
    AtlasWebElement document();

    @FindBy("//div[@data-autotest-fillable='false'][@data-autotest-type='{{ type }}']//*[name()='path']")
    AtlasWebElement addedSimpleElement(@Param("type") String type);

    default void clickActiveField() {
        logger.info("active filed element selector //*[contains(@class, ('is-focused'))]//textarea");
        activeField().click();
    }

}
