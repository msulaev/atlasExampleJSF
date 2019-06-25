package com.pdffiller.page;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public interface ConstructorPage extends WebPage{
    WebDriver driver = null;
    @FindBy("//button//span[contains(text(),'{{ filliableFieldName }}')]")
    AtlasWebElement constructorElement(@Param("filliableFieldName") String toolName);
    @FindBy("//span[contains(text(),'SAVE')]")
    AtlasWebElement saveBtn();
    @FindBy("//span[contains(text(), 'Advanced')]")
    AtlasWebElement advancedOptions();
    @FindBy("//*[contains(@class, ('panel-header is-active'))]")
    ElementsCollection advancedOptionsOpen();
    @FindBy("//div[@class='Select-option']")
    ElementsCollection ddValues();
    @FindBy("//span[contains(text(),'{{ advancedParameter }}')]/parent::*/parent::*/parent::*/div[@class='entitled-box__main']")
    AtlasWebElement advancedParamentrWithDd(@Param("advancedParameter") String parameter);


    default AtlasWebElement textFillableFieldBtn() { return constructorElement("Text"); }
    default AtlasWebElement numberFillableFieldBtn() { return constructorElement("Number"); }
    default AtlasWebElement dateFillableFieldBtn() {
        return constructorElement("Date");
    }
    default AtlasWebElement dropdownFillableFieldBtn() {
        return constructorElement("Dropdown");
    }
    default AtlasWebElement checkboxFillableFieldBtn() {
        return constructorElement("Checkbox");
    }
    default AtlasWebElement signatureFillableFieldBtn() {
        return constructorElement("Signature");
    }
    default AtlasWebElement initialsFillableFieldBtn() {
        return constructorElement("Initials");
    }
    default AtlasWebElement imageFillableFieldBtn() {
        return constructorElement("Image");
    }

}
