package step;

import com.pdffiller.page.MainPage;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class BaseStep {

    WebDriver driver;
    Atlas atlas;

    public BaseStep(WebDriver driver, Atlas atlas) {
        this.driver = driver;
        this.atlas = atlas;
    }

    private MainPage onMainPage() {
        return onPage(MainPage.class);
    }

    <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

    public void uploadFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File (classLoader.getResource(fileName).getFile());
        onMainPage().fileUploadInput().sendKeys(file.getAbsolutePath());
    }


}
