package step;

import com.pdffiller.page.Top100FormPage;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.exception.WaitUntilException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.equalTo;

public class Top100FormStep {

    private WebDriver driver;
    private Atlas atlas;

    public Top100FormStep(WebDriver driver, Atlas atlas) {
        this.driver = driver;
        this.atlas = atlas;
    }

    private Top100FormPage onTop100FormPage() {
        return onPage(Top100FormPage.class);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

    public void openW9FormFromTop100(){
    onTop100FormPage().formFromTop100("w9 2018-2019").click();
    onTop100FormPage().fillFormOnlineBtn("w9 2018-2019").click();
    }

    public AtlasWebElement helpModal(){
        return onTop100FormPage().modalAlert();
    }
}
