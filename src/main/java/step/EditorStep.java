package step;

import com.pdffiller.page.EditorPage;
import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;
import com.pdffiller.element.DocumentElements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

public class EditorStep {
    DocumentElements documentElements;
    private WebDriver driver ;
    private Atlas atlas;
    private static final Logger logger
            = LoggerFactory.getLogger(EditorStep.class);

    public EditorStep(WebDriver driver, Atlas atlas) {
        this.driver = driver;
        this.atlas = atlas;
    }

    @Step
    public void checkField(){
        onEditorPage().activeField().isDisplayed();
        onEditorPage().activeField().click();
        System.out.println(onEditorPage().activeField().getLocation().toString());
    }

    @Step
    public void setPercentPageScale(String percent) {
        onEditorPage().pageScale().click();
        onEditorPage().pageScalePercent(percent).click();
    }

    @Step
    public void clickCheckTool() {
//        onEditorPage().checkTool().click();
//        logger.info("Click check tool");
        onEditorPage().getToolbarElement("Check");
    }

    @Step
    public void clickCircleTool() {
        onEditorPage().circleTool().click();
        logger.info("Click circle tool");
    }

    private EditorPage onEditorPage() {
        return onPage(EditorPage.class);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }
}
