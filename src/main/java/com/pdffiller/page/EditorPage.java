package com.pdffiller.page;

import com.pdffiller.element.Constructor;
import com.pdffiller.element.ToolbarElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface EditorPage extends WebPage, ToolbarElement, Constructor {

    @FindBy("//span[contains(text(),'ADD FILLABLE FIELDS')]")
    AtlasWebElement constructorBtn();

    default void constructorModeOn() {
        constructorBtn().click();
    }
}
