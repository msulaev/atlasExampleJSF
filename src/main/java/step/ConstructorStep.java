package step;

import com.pdffiller.page.ConstructorPage;
import com.pdffiller.utils.DocumentGridForField;
import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ConstructorStep {
    DocumentGridForField documentGridForField;
    private WebDriver driver;
    private Atlas atlas;

    public ConstructorStep(WebDriver driver, Atlas atlas) {
        this.driver = driver;
        this.atlas = atlas;
        documentGridForField = new DocumentGridForField();
    }


    @Step("add field type: { field }")
    public void addField(String field, String fieldName, int[][] grid) {
        onConstructorPage().fieldOnConstructorPanel(field).click();
        documentGridForField.assignFieldToLocation(fieldName, grid);
        new Actions(driver).moveToElement(
                onConstructorPage().document(),documentGridForField.fieldsLocation.get(fieldName)[0],
                documentGridForField.fieldsLocation.get(fieldName)[1]).click().build().perform();
    }

    @Step
    public int [][] createGrid(int fieldCount) {
        return documentGridForField.createGrid(fieldCount,
                onConstructorPage().document().getSize());
    }

    @Step
    public void checkField() {
        //do something with some field, maybe active, maybe no
    }

    @Step
    public void clickSaveBtn() {
        onConstructorPage().saveBtn().click();
    }

    public void openAdvancedOptions() {
        onConstructorPage().fieldAdvancedOptions().click();
    }

    public void chooseAdvancedParametrWithDd(String parameter) {
        onConstructorPage().fieldAdvancedParameter(parameter).click();
        onConstructorPage().ddValues(); // to do
    }

    private ConstructorPage onConstructorPage() {
        return onPage(ConstructorPage.class);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }
}
