import com.pdffiller.page.EditorPage;
import com.pdffiller.site.PdfFillerSite;
import driver.SelenoideDriverProvider;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

 class EditorTest {
    private Atlas atlas;
    private WebDriver driver;

    @BeforeEach
    void startDriver() {
        this.driver = new SelenoideDriverProvider().createDriver();
        this.atlas = new Atlas(new WebDriverConfiguration(this.driver, "http://192.168.1.120:3002/"));
    }

    @Test
    void shouldCanClickSimpleTool() {
        onSite().editor().open();
        onPage().arrowTool().click();
        onPage().checkTool().click();
        onPage().circleTool().click();
    }

    @Test
    void shouldCanOpenConstructor(){
        onSite().editor().open();
        onPage().constructorModeOn();
        onPage().textFilliableFieldBtn().click();
    }

    private EditorPage onPage() {
        return this.atlas.create(this.driver, EditorPage.class);
    }
     private PdfFillerSite onSite() {
         return this.atlas.create(this.driver, PdfFillerSite.class);
     }

}
