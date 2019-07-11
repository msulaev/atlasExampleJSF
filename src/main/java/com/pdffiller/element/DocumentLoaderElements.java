package com.pdffiller.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Selector;

public interface DocumentLoaderElements {

    @FindBy(selector = Selector.CSS, value = ".document-loader")
    AtlasWebElement loader();

}
