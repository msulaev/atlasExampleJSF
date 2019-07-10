package com.pdffiller.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Selector;

import static io.qameta.atlas.webdriver.extension.Selector.ID;

public interface ModalElements extends AtlasWebElement {

    @FindBy(selector = Selector.CSS, value = ".modal-alert__title")
    AtlasWebElement modalAlert();

    @FindBy(selector = ID, value = "choice-modal" )
    AtlasWebElement modalChoice();
}
