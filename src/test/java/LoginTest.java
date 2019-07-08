import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import step.LoginStep;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class LoginTest extends BaseTest {
    private static final String INVALID_EMAIL = "invalid@invalid.com";
    private static final String INVALID_PWD = "invalid@invalid.com";

    @ExtendWith(MyCustomParameter.class)
    @Test
    void shouldCanNotLoginWithInvalidCredential(User user ) {
        LoginStep loginStep = new LoginStep(driver, atlas);
        onSite().open(cfg.loginUrl());
        assertThat(loginStep
                .loginerUserWithCredentional(INVALID_EMAIL, INVALID_PWD)
                .isAlertMsg(), equalTo(true));
    }

}
