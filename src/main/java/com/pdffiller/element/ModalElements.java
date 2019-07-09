package com.pdffiller.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Selector;

public interface ModalElements extends AtlasWebElement {

    @FindBy(selector = Selector.CSS, value = ".modal-alert__title")
    AtlasWebElement modalAlert();
}
