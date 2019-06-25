package com.pdffiller.page;

import com.pdffiller.element.ToolbarElements;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import com.pdffiller.element.DocumentElements;

public interface EditorPage extends WebPage, ToolbarElements, DocumentElements {

    @FindBy("//span[contains(text(),'ADD FILLABLE FIELDS')]")
    AtlasWebElement constructorBtn();

    @FindBy("//i[@class='i i-end']")
    AtlasWebElement btnLastPage();


    default void constructorModeOn() {
        constructorBtn().isDisplayed();
        constructorBtn().click();
    }

}
