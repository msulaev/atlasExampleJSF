package com.pdffiller.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface ToolbarElements {
    @FindBy("//button[@title='{{ toolName }} Tool']")
    AtlasWebElement toolbarElement(@Param("toolName") String toolName);
    @FindBy("//div[@class='toolbar__item']//span[contains(text(),'{{ toolBarItemName }}')]")
    AtlasWebElement toolBarItem(@Param("toolBarItemName") String toolBarItemName);
    @FindBy("//li[@class='menu__list-item']//button//span[contains(text(), '{{ percent }}')]/parent::*/parent::*/parent::*")
    AtlasWebElement pageScalePercent(@Param("percent") String percent);

    default AtlasWebElement pageScale75() { return pageScalePercent("75%"); }
    default AtlasWebElement pageScale() { return  toolBarItem("Fit Width"); }
    default AtlasWebElement textTool() {
        return toolbarElement("Text");
    }
    default AtlasWebElement crossTool() {
        return toolbarElement("Cross");
    }
    default AtlasWebElement checkTool() {
        return toolbarElement("Check");
    }
    default AtlasWebElement circleTool() {
        return toolbarElement("Circle");
    }
    default AtlasWebElement signTool() {
        return toolbarElement("Sign");
    }
    default AtlasWebElement dateTool() {
        return toolbarElement("Date");
    }
    default AtlasWebElement imageTool() {
        return toolbarElement("Image");
    }
    default AtlasWebElement eraseTool() {
        return toolbarElement("Erase");
    }
    default AtlasWebElement blackoutTool() {
        return toolbarElement("Blackout");
    }
    default AtlasWebElement textBoxTool() {
        return toolbarElement("Text Box");
    }
    default AtlasWebElement arrowTool() { return toolbarElement("Arrow"); }
    default AtlasWebElement lineTool() {
        return toolbarElement("Line");
    }

}
