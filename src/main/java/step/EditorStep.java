package step;

import com.pdffiller.page.EditorPage;
import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;

public class EditorStep {

    private WebDriver driver ;
    private Atlas atlas;

    public EditorStep(WebDriver driver, Atlas atlas) {
        this.driver = driver;
        this.atlas = atlas;
    }

    @Step



    private EditorPage onEditorPage() {
        return onPage(EditorPage.class);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }
}
