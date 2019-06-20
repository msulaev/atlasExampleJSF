package com.pdffiller.page;

import com.pdffiller.element.ConstructorElements;
import com.pdffiller.element.ToolbarElements;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface EditorPage extends WebPage, ToolbarElements, ConstructorElements {

    @FindBy("//span[contains(text(),'ADD FILLABLE FIELDS')]")
    AtlasWebElement constructorBtn();

    default void constructorModeOn() {
        constructorBtn().click();
    }
}
