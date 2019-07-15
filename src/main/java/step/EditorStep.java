package step;

import com.pdffiller.element.DocumentElements;
import com.pdffiller.page.EditorPage;
import com.pdffiller.utils.DocumentGridForField;
import com.pdffiller.utils.ToolbarColor;
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
    ToolbarColor toolbarColor;


    public EditorStep(WebDriver driver, Atlas atlas) {
        this.driver = driver;
        this.atlas = atlas;
        documentGridForField = new DocumentGridForField();
        toolbarColor = new ToolbarColor();

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
        return toolbarColor.getValueByCode(code);
    }

    @Step
    public void setColorOnToolbar(String color) {
        String colorCode = toolbarColor.getCode("Red");
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
