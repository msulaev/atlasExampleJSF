package com.pdffiller.page;

import com.pdffiller.element.DocumentElements;
import com.pdffiller.element.ToolbarElements;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public interface EditorPage extends WebPage, ToolbarElements, DocumentElements {
    Logger logger = getLogger(ToolbarElements.class);

    @FindBy("//span[contains(text(),'ADD FILLABLE FIELDS')]")
    AtlasWebElement constructorBtn();

    @FindBy("//i[@class='i i-end']")
    AtlasWebElement btnLastPage();


    default void constructorModeOn() {
        logger.info("constructorBtn element selector //span[contains(text(),'ADD FILLABLE FIELDS')]");
        constructorBtn().click();
    }
}
