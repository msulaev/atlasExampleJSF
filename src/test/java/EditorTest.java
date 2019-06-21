import com.pdffiller.page.EditorPage;
import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.DriverUrl;
import io.github.bonigarcia.seljup.SeleniumExtension;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
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
    String url = "http://192.168.1.121:4444/wd/hub";
    private Atlas atlas;
    private RemoteWebDriver driver;

    { //Example
        caps.setCapability("Name", "testtest");
        caps.setBrowserName("chrome");
        caps.setVersion("73.0");
        caps.setCapability("enableVNC", true);
        caps.setCapability("enableVideo", false);
    }

    @BeforeEach
    void startDriver(RemoteWebDriver driver) {
        this.driver = driver;
        this.atlas = new Atlas(new WebDriverConfiguration(driver, "http://192.168.1.121:3002/"));
    }

    @Test
    void shouldCanClickSimpleTool() {
        onPage().open();
        onPage().arrowTool().click();
        onPage().checkTool().click();
        onPage().circleTool().click();
    }

    @Test
    void shouldCanOpenConstructor() {
        onPage().constructorModeOn();
        onPage().textFilliableFieldBtn().click();
    }

    //TODO create generic
    private EditorPage onPage() {
        return onPage(EditorPage.class);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

}
