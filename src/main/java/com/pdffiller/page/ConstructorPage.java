package com.pdffiller.page;

import com.pdffiller.element.DocumentElements;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import org.slf4j.Logger;

import java.lang.invoke.MethodHandles;

import static org.slf4j.LoggerFactory.getLogger;

public interface ConstructorPage extends WebPage, DocumentElements {
    Logger logger = getLogger(MethodHandles.lookup().lookupClass());

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

    @FindBy("//div//span[contains(text(),'{{ advancedParameter }}')]")
    AtlasWebElement fieldAdvancedParameter(@Param("advancedParameter") String parameter);// var parameter its name of advanced parameter,

    @FindBy(("//*[contains(@class, ('is-active'))]"))
    AtlasWebElement activeField();

    default AtlasWebElement getConstructorField(String toolName) {
        logger.info("'{}' element selector: //button//span[contains(text(),'{}')]", toolName, toolName);
        return fieldOnConstructorPanel(toolName);
    }

    default AtlasWebElement getFieldAdvancedParameter(String parameter) {
        logger.info("'{}' element selector: ///div//span[contains(text(),'{}')]",
                parameter, parameter);
        return fieldAdvancedParameter(parameter);
    }

}
