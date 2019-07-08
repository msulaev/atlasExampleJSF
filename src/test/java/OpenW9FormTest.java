import com.pdffiller.page.Top100FormPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import step.Top100FormStep;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class OpenW9FormTest extends BaseTest {
    @Test
    void shouldSeeHelpModalWhenOpeningW9Form()  {
        Top100FormStep top100FormStep = new Top100FormStep(driver, atlas);

        onSite().open("https://dev3.pdffiller.com/en/top.htm");
        top100FormStep.openW9FormFromTop100();

        assertThat(top100FormStep.helpModal().getText(), equalTo("Need Help?"));
    }
}
