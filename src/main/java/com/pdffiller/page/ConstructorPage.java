package com.pdffiller.page;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public interface ConstructorPage extends WebPage {
    Logger logger
            = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy("//button//span[contains(text(),'{{ filliableFieldName }}')]")
    AtlasWebElement fieldOnConstructorPanel(@Param("filliableFieldName") String toolName);

    @FindBy("//span[contains(text(),'SAVE')]")
    AtlasWebElement saveBtn();

    @FindBy("//span[contains(text(), 'Advanced')]")
    AtlasWebElement fieldAdvancedOptions();

    @FindBy("//*[contains(@class, ('panel-header is-active'))]")
    ElementsCollection advancedOptionsOpen();

    @FindBy("//div[@class='Select-option']")
    ElementsCollection ddValues();

    @FindBy("//span[contains(text(),'{{ advancedParameter }}')]/parent::*/parent::*/parent::*/div[@class='entitled-box__main']")
    AtlasWebElement fieldAdvancedParameter(@Param("advancedParameter") String parameter);// var parameter its name of advanced parameter,

    //this element is a field in which you need to specify the value of this advanced parameter
    @FindBy("//div[@class='page-Page pageActive-Pagination']//div[@class='elementsWrapper-Content']")
    AtlasWebElement document();

    @FindBy(("//*[contains(@class, ('is-active'))]"))
    AtlasWebElement activeField();

    default AtlasWebElement getConstructorField(String toolName) {
        logger.info("'{}' element selector: //button//span[contains(text(),'{}')]", toolName, toolName);
        return fieldOnConstructorPanel(toolName);
    }

    default AtlasWebElement getFieldAdvancedParameter(String parameter) {
        logger.info("'{}' element selector: //span[contains(text(),'{}')]/parent::*/parent::*/parent::*/div[@class='entitled-box__main']",
                parameter, parameter);
        return fieldAdvancedParameter(parameter);
    }

}
