package com.pdffiller.element;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import org.slf4j.Logger;

import java.lang.invoke.MethodHandles;

import static org.slf4j.LoggerFactory.getLogger;


public interface ElementParameterOnToolbar {
    Logger logger = getLogger(MethodHandles.lookup().lookupClass());

    @FindBy("//button[@title='Select color']")
    AtlasWebElement colorList();

    @FindBy("//button//div[@class='control__box']/span[contains(@style, ('{{ color }}'))]")
    AtlasWebElement parameterColor(@Param("color") String percent);

}
