import com.pdffiller.page.EditorPage;
import com.pdffiller.site.PdfFillerSite;
import com.pdffiller.utils.DocumentGridForField;
import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.DriverUrl;
import io.github.bonigarcia.seljup.SeleniumExtension;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import step.ConstructorStep;
import step.EditorStep;


@ExtendWith(SeleniumExtension.class)
class EditorTest extends BaseTest{

    @Test
    void shouldCanClickSimpleTool() throws InterruptedException {
        onSite().editor().open("http://192.168.1.211:3000/?isOfflineMode&dontWaitForPdf");
        editorStep.clickSimpleToolToolbarElement("Check");
    }

    @Test
    void shouldCanOpenConstructor() throws InterruptedException {
        onSite().editor().open("http://192.168.1.211:3000/?isOfflineMode&dontWaitForPdf");
        editorStep.openConstructor();
        constructorStep.clickSaveBtn();
    }

    @Test
    void addFieldToGrid() throws InterruptedException {
        onSite().editor().open("http://192.168.1.211:3000/?isOfflineMode&dontWaitForPdf");
        editorStep.openConstructor();
        int[][] grid = constructorStep.createGrid(10);
        constructorStep.addField("Number", "Number1", grid);
        constructorStep.addField("Text", "Text1", grid);
        constructorStep.clickSaveBtn();
        editorStep.enterTextToActiveField("123");
    }

    @Test
    void changePageScale() throws InterruptedException {
        onSite().editor().open("http://192.168.1.211:3000/?isOfflineMode&dontWaitForPdf");
        editorStep.goToLastDocumentPage();
        editorStep.setPercentPageScale("75");
    }

}
