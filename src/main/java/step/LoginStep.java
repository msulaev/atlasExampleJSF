package step;

import com.pdffiller.page.LoginPage;
import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;

public class LoginStep {
    private WebDriver driver;
    private Atlas atlas;

    public LoginStep(WebDriver driver, Atlas atlas) {
        this.driver = driver;
        this.atlas = atlas;
    }

    private LoginPage loginPage() {
        return onPage(LoginPage.class);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }


    @Step("Set email: { email }, set pwd: { pwd }")
    public LoginStep loginerUserWithCredentional(String email, String pwd) {
        loginPage().setEmail(email);
        loginPage().setPwd(pwd);
        loginPage().logInBtn().click();
        return this;
    }

    @Step
    public boolean isAlertMsg() {
        return loginPage().alertMsg().isDisplayed();
    }
}