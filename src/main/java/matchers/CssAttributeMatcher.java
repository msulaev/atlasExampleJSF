package matchers;

import io.qameta.atlas.webdriver.AtlasWebElement;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static org.hamcrest.CoreMatchers.is;

public class CssAttributeMatcher extends TypeSafeMatcher<AtlasWebElement> {

    private final String name;
    private final Matcher<String> matcher;

    private CssAttributeMatcher(String name, Matcher<String> matcher) {
        this.matcher = matcher;
        this.name = name;
    }

    @Factory
    public static CssAttributeMatcher cssAttribute(final String name, final Matcher<String> attributeMatcher) {
        return new CssAttributeMatcher(name, attributeMatcher);
    }

    @Factory
    public static CssAttributeMatcher cssAttribute(final String name, final String value) {
        return cssAttribute(name, is(value));
    }

    @Factory
    public static CssAttributeMatcher css(final String name, final Matcher<String> attributeMatcher) {
        return cssAttribute(name, attributeMatcher);
    }

    @Factory
    public static CssAttributeMatcher css(final String name, final String value) {
        return css(name, is(value));
    }

    @Override
    public boolean matchesSafely(AtlasWebElement item) {
        return matcher.matches(item.getCssValue(name));
    }

    public void describeTo(Description description) {
        description.appendText(" Atlas element css attribute ").
                appendValue(name).
                appendText(" is ").
                appendDescriptionOf(matcher);
    }

    @Override
    protected void describeMismatchSafely(AtlasWebElement item, Description mismatchDescription) {
        mismatchDescription.appendValue(item).
                appendText(" css attribute ").
                appendValue(name).
                appendText(" is ").
                appendValue(item.getCssValue(name));
    }
}
