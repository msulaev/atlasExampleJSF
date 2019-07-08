package step;

import com.pdffiller.entity.User;
import com.pdffiller.page.LoginPage;
import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import org.openqa.selenium.WebDriver;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver, Atlas atlas) {
        super(driver, atlas);
    }

    private LoginPage onLoginPage() {
        return onPage(LoginPage.class);
    }

    @Step("Set email: { email }, set pwd: { pwd }")
    public LoginStep loginerUserWithCredentional(User user) {
        onLoginPage().setEmail(user.getEmail());
        onLoginPage().setPwd(user.getPwd());
        onLoginPage().logInBtn().click();
        return this;
    }

    @Step
    public boolean isAlertMsg() {
        return onLoginPage().alertMsg().isDisplayed();
    }
}