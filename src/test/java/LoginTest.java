import com.pdffiller.entity.User;
import extension.CustomParameterExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import step.LoginStep;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class LoginTest extends BaseTest {
    
    @ExtendWith(CustomParameterExtension.class)
    @Test
    void shouldCanNotLoginWithInvalidCredential(User invalidUserCreds) {
        LoginStep loginStep = new LoginStep(driver, atlas);

        onSite().open(cfg.loginUrl());
        assertThat(loginStep
                .loginerUserWithCredentional(invalidUserCreds)
                .isAlertMsg(), equalTo(true));
    }

}
