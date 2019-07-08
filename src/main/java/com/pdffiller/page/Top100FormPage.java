package com.pdffiller.page;

import com.pdffiller.element.ModalElements;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Page;
import io.qameta.atlas.webdriver.extension.Param;
import org.slf4j.Logger;

import java.lang.invoke.MethodHandles;

import static org.slf4j.LoggerFactory.getLogger;

public interface Top100FormPage extends WebPage, ModalElements {
    Logger logger = getLogger(MethodHandles.lookup().lookupClass());

    @FindBy("//a[contains(text(), '{{ form }}')]")
    AtlasWebElement formFromTop100(@Param("form") String form);

    @FindBy("//div[@title='Get the free {{ form }}  form']")
    AtlasWebElement fillFormOnlineBtn(@Param("form") String form);

    default AtlasWebElement getFormFromTop100(String form){
        logger.info("'{}' element selector: //a[contains(text(),'{}')]", form, form);
        return formFromTop100(form);
    }
}
