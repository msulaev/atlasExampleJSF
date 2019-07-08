package com.pdffiller.page;

import com.pdffiller.element.ToolbarElements;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public interface LoginPage extends WebPage {
    Logger logger = getLogger(ToolbarElements.class);


    @FindBy("//input[@placeholder = 'Email' and @data-for='t2']")
    AtlasWebElement emailInpt();

    @FindBy("//input[@placeholder = 'Password' and @data-for='t6']")
    AtlasWebElement pwdInpt();

    @FindBy("//button[contains(text(),'Log In') and @type='submit']")
    AtlasWebElement logInBtn();

    @FindBy("//div[@class='alert alert--error']")
    AtlasWebElement alertMsg();

    default void setEmail(String email) {
        emailInpt().click();
        logger.info(" login selector: //input[@placeholder = 'Email' and @data-for='t2']");
        emailInpt().sendKeys(email);
    }

    default void setPwd(String pwd) {
        pwdInpt().click();
        logger.info("password input://input[@placeholder = 'Password' and @data-for='t6']");
        pwdInpt().sendKeys(pwd);
    }
}
