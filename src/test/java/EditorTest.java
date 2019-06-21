import com.pdffiller.page.EditorPage;
import com.pdffiller.site.PdfFillerSite;
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

@ExtendWith(SeleniumExtension.class)
class EditorTest {
    @DriverCapabilities
    DesiredCapabilities caps = new DesiredCapabilities();
    @DriverUrl
    String url = "http://192.168.1.121:4444/wd/hub";
    private Atlas atlas;
    private RemoteWebDriver driver;

    { //Example
        caps.setCapability("Name", "msulaev");
        caps.setBrowserName("chrome");
        caps.setVersion("73.0");
        caps.setCapability("enableVNC", true);
        caps.setCapability("enableVideo", false);
    }

    @BeforeEach
    void startDriver(ChromeDriver driver) {
        this.driver = driver;
        driver.manage().window().setSize(new Dimension(1980, 1024));
        this.atlas = new Atlas(new WebDriverConfiguration(driver));
    }

    @Test
    void shouldCanClickSimpleTool() throws InterruptedException {
        onSite().open("http://192.168.1.211:3000/?isOfflineMode&dontWaitForPdf");
        onPage().checkTool().click();
        onPage().circleTool().click();
    }

    @Test
    void shouldCanOpenConstructor() {
        onSite().open("http://192.168.1.211:3000/?isOfflineMode&dontWaitForPdf");
        onPage().constructorModeOn();
        onPage().textFillableFieldBtn().click();
    }

    //TODO create generic
    private EditorPage onPage() {
        return onPage(EditorPage.class);
    }

    private PdfFillerSite onSite() {
        return onPage(PdfFillerSite.class);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

}
