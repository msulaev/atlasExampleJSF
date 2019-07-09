package matchers;

import io.qameta.atlas.core.AtlasException;
import io.qameta.atlas.webdriver.AtlasWebElement;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

import static org.openqa.selenium.By.xpath;

public class ExistsMatcher extends TypeSafeMatcher<AtlasWebElement> {

    @Factory
    public static ExistsMatcher isExists() {
        return new ExistsMatcher();
    }

    @Override
    protected boolean matchesSafely(AtlasWebElement element) {
        try {
            element.findElement(xpath("self::*"));
        } catch (AtlasException e) {
            return false;
        }
        return true;
    }

    public void describeTo(Description description) {
        description.appendText("element existing on page");
    }

    @Override
    public void describeMismatchSafely(AtlasWebElement element, Description mismatchDescription) {
        mismatchDescription.appendValue(element).
                appendText(" not existing on page");
    }

}

