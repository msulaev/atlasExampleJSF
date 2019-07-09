import org.junit.jupiter.api.Test;
import step.Top100FormStep;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.equalTo;

class OpenW9FormTest extends BaseTest {
    @Test
    void shouldSeeHelpModalWhenOpeningW9Form() {
        Top100FormStep top100FormStep = new Top100FormStep(driver, atlas);

        onSite().open("https://dev3.pdffiller.com/en/top.htm");
        top100FormStep.openW9FormFromTop100();

        await("Wait help modal").atMost(20, TimeUnit.SECONDS).ignoreExceptions()
                .until(top100FormStep.helpModal()::getText, equalTo("Need Help?"));

    }
}
