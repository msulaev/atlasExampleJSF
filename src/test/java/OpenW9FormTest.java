import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step.Top100FormStep;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.equalTo;

class OpenW9FormTest extends BaseTest {
    private static final String TOP100_URL = "https://dev3.pdffiller.com/en/top.htm";
    Top100FormStep top100FormStep;

    @BeforeEach
    void setUp() {
        onSite().open(TOP100_URL);
        top100FormStep = new Top100FormStep(driver, atlas);

    }

    @Test
    void shouldSeeHelpModalWhenOpeningW9Form() {
        top100FormStep.openW9FormFromTop100();
        await("Wait help modal")
                .atMost(20, SECONDS)
                .ignoreExceptions()
                .until(top100FormStep.helpModal()::getText, equalTo("Need Help?"));
    }
}
