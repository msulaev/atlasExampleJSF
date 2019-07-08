import com.pdffiller.entity.User;
import org.junit.jupiter.api.Test;
import step.LoginStep;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class LoginTest extends BaseTest {
    private static final String INVALID_EMAIL = "invalid@invalid.com";
    private static final String INVALID_PWD = "invalid@invalid.com";

    @Test
    void shouldCanNotLoginWithInvalidCredential() {
        LoginStep loginStep = new LoginStep(driver, atlas);
        onSite().open(cfg.loginUrl());
        assertThat(loginStep
                .loginerUserWithCredentional(new User().withEmail(INVALID_EMAIL).withPwd(INVALID_PWD))
                .isAlertMsg(), equalTo(true));
    }

}
