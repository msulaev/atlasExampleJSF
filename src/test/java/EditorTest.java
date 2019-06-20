import com.pdffiller.page.EditorPage;
import com.pdffiller.site.PdfFillerSite;
import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.DriverUrl;
import io.github.bonigarcia.seljup.SeleniumExtension;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@ExtendWith(SeleniumExtension.class)
class EditorTest {
    @DriverCapabilities
    DesiredCapabilities caps = new DesiredCapabilities();
    @DriverUrl
    String url = "http://localhost:4444/wd/hub";
    private Atlas atlas;
    private RemoteWebDriver driver;

    {
        caps.setCapability("Name", "testtest");
        caps.setBrowserName("chrome");
        caps.setVersion("73.0");
        caps.setCapability("enableVNC", true);
        caps.setCapability("enableVideo", false);
    }

    @BeforeEach
    void startDriver(RemoteWebDriver driver) {
        this.driver = driver;
        this.atlas = new Atlas(new WebDriverConfiguration(driver, "http://192.168.88.249:3002/"));
    }

    @Test
    void shouldCanClickSimpleTool() {
        onSite().editor().open();
        onPage().arrowTool().click();
        onPage().checkTool().click();
        onPage().circleTool().click();
    }

    @Test
    void shouldCanOpenConstructor() {
        onSite().editor().open();
        onPage().constructorModeOn();
        onPage().textFilliableFieldBtn().click();
    }

    //TODO create generic
    private EditorPage onPage() {
        return this.atlas.create(driver, EditorPage.class);
    }

    private PdfFillerSite onSite() {
        return this.atlas.create(driver, PdfFillerSite.class);
    }

}
