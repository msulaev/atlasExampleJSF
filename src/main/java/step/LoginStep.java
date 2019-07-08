package step;

import com.pdffiller.page.LoginPage;
import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver, Atlas atlas) {
        super(driver, atlas);
    }

    private LoginPage loginPage() {
        return onPage(LoginPage.class);
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