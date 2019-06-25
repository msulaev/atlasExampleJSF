package step;

import com.pdffiller.page.ConstructorPage;
import com.pdffiller.utils.DocumentGridForField;
import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.By;
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
        onConstructorPage().constructorElement(field).click();
        documentGridForField.assignFieldToLocation(fieldName, grid);
        System.out.println(onConstructorPage().findElement(By.className("elementsWrapper-Content")).getLocation().x);
        System.out.println(onConstructorPage().findElement(By.className("elementsWrapper-Content")).getLocation().y);
        new Actions(driver).moveToElement(
                driver.findElement(By.className("elementsWrapper-Content")),
                onConstructorPage().findElement(By.className("elementsWrapper-Content")).getLocation().x + documentGridForField.fieldsLocation.get(fieldName)[0],
                onConstructorPage().findElement(By.className("elementsWrapper-Content")).getLocation().y + documentGridForField.fieldsLocation.get(fieldName)[1]).click().build().perform();
    }

    @Step
    public void checkField() {


    }

    public void clickSaveBtn() {
        onConstructorPage().saveBtn().click();
    }

    public void openAdvancedOptions() {
        onConstructorPage().advancedOptions().click();
    }

    public void chooseAdvancedParametrWithDd(String parameter) {
        onConstructorPage().advancedParamentrWithDd(parameter).click();
        onConstructorPage().ddValues(); // to do
    }

    private ConstructorPage onConstructorPage() {
        return onPage(ConstructorPage.class);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }
}
