package com.pdffiller.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface ConstructorElements {
    @FindBy("//button//span[contains(text(),'{{ filliableFieldName }}')]")
    AtlasWebElement toolbarElement(@Param("filliableFieldName") String toolName);

    default AtlasWebElement textFilliableFieldBtn() {
        return toolbarElement("Text");
    }

    default AtlasWebElement numberFilliableFieldBtn() {
        return toolbarElement("Number");
    }

    default AtlasWebElement dateFilliableFieldBtn() {
        return toolbarElement("Date");
    }

    default AtlasWebElement dropdownFilliableFieldBtn() {
        return toolbarElement("Dropdown");
    }

    default AtlasWebElement checkboxFilliableFieldBtn() {
        return toolbarElement("Checkbox");
    }

    default AtlasWebElement signatureFilliableFieldBtn() {
        return toolbarElement("Signature");
    }

    default AtlasWebElement initialsFilliableFieldBtn() {
        return toolbarElement("Initials");
    }


    default AtlasWebElement imageFilliableFieldBtn() {
        return toolbarElement("Image");
    }

}
