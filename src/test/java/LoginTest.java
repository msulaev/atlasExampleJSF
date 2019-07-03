import org.junit.jupiter.api.Test;
import step.LoginStep;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class LoginTest extends EditorTest {


    @Test
    void shouldCanNotLoginWithInvalidCredential() {
        onSite().open("http://dev3.pdffiller.com/en/login.htm");
        LoginStep loginStep = new LoginStep(driver, atlas);
        assertThat(loginStep.
                loginerUserWithCredentional("invalid@invalid.com", "invalid"), equalTo(true));
    }

}
