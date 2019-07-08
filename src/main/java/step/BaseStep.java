package step;

import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;

public class BaseStep {

    WebDriver driver;
    Atlas atlas;

    <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

    public BaseStep(WebDriver driver, Atlas atlas) {
        this.driver = driver;
        this.atlas = atlas;
    }
}
