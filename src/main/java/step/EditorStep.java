package step;

import com.pdffiller.element.DocumentElements;
import com.pdffiller.page.EditorPage;
import com.pdffiller.utils.DocumentGridForField;
import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
        String color = onEditorPage().addedSimpleElement(element).getCssValue("fill");
        if(color.equals("rgb(255, 0, 0)")){
            return "Red";
        }else if (color.equals("rgb(0, 0,255)")){
            return "Blue";
        }else if(color.equals("rgb(255, 255,255)")){
            return "White";
        }else if(color.equals("rgb(0, 0,0)")){
            return "Black";
        } else {
            return "";
        }
    }

    @Step
    public void selectColorOnToolbar(String color) {
        onEditorPage().colorList().click();
        if(color.equals("Red")){
            onEditorPage().parameterColor("rgb(255, 0, 0)").click();
        }else if (color.equals("Blue")){
            onEditorPage().parameterColor("rgb(0, 0, 255)").click();
        }else if(color.equals("White")){
            onEditorPage().parameterColor("rgb(255, 255, 255)").click();
        }else if(color.equals("Black")){
            onEditorPage().parameterColor("rgb(0, 0, 0)").click();
        }

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
