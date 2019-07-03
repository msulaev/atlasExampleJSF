import org.junit.jupiter.api.Test;
import step.LoginStep;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class LoginTest extends BaseTest {
    private static final String INVALID_EMAIL = "invalid@invalid.com";
    private static final String INVALID_PWD = "invalid@invalid.com";

    @Test
    void shouldCanNotLoginWithInvalidCredential() {
        onSite().open(cfg.loginUrl()); //TODO make URL from config
        LoginStep loginStep = new LoginStep(driver, atlas);
        assertThat(loginStep.loginerUserWithCredentional(INVALID_EMAIL, INVALID_PWD), equalTo(true));
    }

}
