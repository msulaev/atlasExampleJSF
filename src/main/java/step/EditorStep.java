package step;

import com.pdffiller.element.DocumentElements;
import com.pdffiller.page.EditorPage;
import com.pdffiller.utils.DocumentGridForField;
import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

import static matchers.ExistsMatcher.isExists;
import static org.hamcrest.Matchers.not;

public class EditorStep {
    DocumentElements documentElements;
    DocumentGridForField documentGridForField;
    private WebDriver driver;
    private Atlas atlas;

    public EditorStep(WebDriver driver, Atlas atlas) {
        this.driver = driver;
        this.atlas = atlas;
        documentGridForField = new DocumentGridForField();
    }

    public enum Color {
        Red("rgb(255, 0, 0)"),
        Blue("rgb(0, 0,255)"),
        White("rgb(255, 255,255)"),
        Black("rgb(0, 0, 0)");
        Color (String code) {
            this.code = code;
        }
        private String code;
        private static final Map<String, Color> BY_CODE = new HashMap<>();
        static {
            for (Color e : values()) {
                BY_CODE.put(e.code, e);
            }
        }

        public static Color valueOfCode(String code) {
            return BY_CODE.get(code);
        }
        public String getCode() {
            return code;
        }
    }

    @Step
    public void checkField() {
        onEditorPage().activeField().isDisplayed();
        onEditorPage().activeField().click();
    }

    @Step
    public void setPercentPageScale(String percent) {
        onEditorPage().getToolbarParameter("Fit Width").click();
        onEditorPage().getPercentScale(percent).click();
    }

    @Step
    public void clickSimpleToolToolbarElement(String element) {
        onEditorPage().getSimpleToolToolbarElement(element);
    }

    @Step
    public void openConstructor() {
        onEditorPage().constructorModeOn();
    }

    @Step
    public void enterTextToActiveField(String text) {
        onEditorPage().activeField().click();
        onEditorPage().activeField().sendKeys(text);
    }

    @Step
    public void waitForDocumentOpen() {
        onEditorPage().loader().waitUntil(not(isExists()), 15);
    }


    @Step
    public void addSimpleTool(String field, String fieldName, int[][] grid) {
        onEditorPage().getSimpleToolToolbarElement(field).click();
        documentGridForField.assignFieldToLocation(fieldName, grid);
        new Actions(driver).moveToElement(
                onEditorPage().document(), documentGridForField.fieldsLocation.get(fieldName)[0],
                documentGridForField.fieldsLocation.get(fieldName)[1]).click().build().perform();
    }

    @Step
    public String getElementColor(String element){
        if(element.equals("Cross")) {
            element = "checkmark";
        }
        String code = onEditorPage().addedSimpleElement(element).getCssValue("fill");
        return Color.valueOfCode(code).toString();
    }

    @Step
    public void setColorOnToolbar(String colorCode) {
        onEditorPage().colorList().click();
        onEditorPage().parameterColor(colorCode).click();

    }

    @Step
    public void goToLastDocumentPage() {
        onEditorPage().btnLastPage().click();
    }


    public EditorPage onEditorPage() {
        return onPage(EditorPage.class);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }
}
