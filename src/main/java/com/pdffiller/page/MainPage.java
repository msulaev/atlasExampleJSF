package com.pdffiller.page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.slf4j.Logger;

import java.lang.invoke.MethodHandles;

import static org.slf4j.LoggerFactory.getLogger;

public interface MainPage extends WebPage {
    Logger logger = getLogger(MethodHandles.lookup().lookupClass());

    @FindBy("//*[contains(@accept, ('.pdf'))]")
    AtlasWebElement fileUploadInput();


}
