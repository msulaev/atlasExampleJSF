package com.pdffiller.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface DocumentElements {
    @FindBy("//*[contains(@class, ('jsf-fillable--active'))]//textarea")
    AtlasWebElement activeField();
}
