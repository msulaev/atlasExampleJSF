package com.pdffiller.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import org.slf4j.Logger;

import java.lang.invoke.MethodHandles;

import static org.slf4j.LoggerFactory.getLogger;

public interface ToolbarElements {
    Logger logger = getLogger(MethodHandles.lookup().lookupClass());

    @FindBy("//button[@title='{{ toolName }} Tool']")
    AtlasWebElement toolbarElement(@Param("toolName") String toolName);

    @FindBy("//div[@class='toolbar__item']//span[contains(text(),'{{ toolBarItemName }}')]")
    AtlasWebElement toolBarItem(@Param("toolBarItemName") String toolBarItemName);

    @FindBy("//li[@class='menu__list-item']//button//span[contains(text(), '{{ percent }}')]/parent::*/parent::*/parent::*")
    AtlasWebElement pageScalePercent(@Param("percent") String percent);

    default AtlasWebElement getSimpleToolToolbarElement(String toolName) {
        logger.info("{} element selector: //button[@title='{} Tool']", toolName, toolName);
        return toolbarElement(toolName);
    }

    default AtlasWebElement getToolbarParameter(String parameter) {
        logger.info("'{}' element selector: //div[@class='toolbar__item']//span[contains(text(),'{}')]", parameter, parameter);
        return toolBarItem(parameter);
    }

    default AtlasWebElement getPercentScale(String percent) {
        logger.info("{} element selector: //li[@class='menu__list-item']//button//span[contains(text(), {})]/parent::*/parent::*/parent::*", percent, percent);
        return pageScalePercent(percent);
    }
}
