package step;

import com.pdffiller.page.MainPage;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;

public class BaseStep {

    WebDriver driver;
    Atlas atlas;

    private MainPage onMainPage() {
        return onPage(MainPage.class);
    }

    <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

    public void uploadFile() {
        onMainPage().fileUploadInput().sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\test.pdf");
    }

    public BaseStep(WebDriver driver, Atlas atlas) {
        this.driver = driver;
        this.atlas = atlas;
    }
}
