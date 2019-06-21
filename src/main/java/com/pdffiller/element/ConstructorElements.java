package com.pdffiller.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface ConstructorElements {
    @FindBy("//button//span[contains(text(),'{{ filliableFieldName }}')]")
    AtlasWebElement toolbarElement(@Param("filliableFieldName") String toolName);

    default AtlasWebElement textFillableFieldBtn() {
        return toolbarElement("Text");
    }

    default AtlasWebElement numberFillableFieldBtn() {
        return toolbarElement("Number");
    }

    default AtlasWebElement dateFillableFieldBtn() {
        return toolbarElement("Date");
    }

    default AtlasWebElement dropdownFillableFieldBtn() {
        return toolbarElement("Dropdown");
    }

    default AtlasWebElement checkboxFillableFieldBtn() {
        return toolbarElement("Checkbox");
    }

    default AtlasWebElement signatureFillableFieldBtn() {
        return toolbarElement("Signature");
    }

    default AtlasWebElement initialsFillableFieldBtn() {
        return toolbarElement("Initials");
    }


    default AtlasWebElement imageFillableFieldBtn() {
        return toolbarElement("Image");
    }

}
