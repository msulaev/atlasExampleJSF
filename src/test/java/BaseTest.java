import com.pdffiller.page.EditorPage;
import com.pdffiller.site.PdfFillerSite;
import com.pdffiller.utils.DocumentGridForField;
import com.pdffiller.utils.MyCustomExt;
import configuration.ProjectProperties;
import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.DriverUrl;
import io.github.bonigarcia.seljup.SeleniumExtension;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import step.BaseStep;
import step.ConstructorStep;
import step.EditorStep;

@ExtendWith({SeleniumExtension.class, MyCustomExt.class})
class BaseTest {

    ProjectProperties cfg = ConfigFactory.create(ProjectProperties.class);

    @DriverCapabilities
    DesiredCapabilities caps = new DesiredCapabilities();

    @DriverUrl
    String url = "http://192.168.1.121:4444/wd/hub";

    ConstructorStep constructorStep;
    EditorStep editorStep;
    DocumentGridForField documentGridForField;
    BaseStep baseStep;
    Atlas atlas;
    RemoteWebDriver driver;

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
        constructorStep = new ConstructorStep(driver, atlas);
        editorStep = new EditorStep(driver, atlas);
        documentGridForField = new DocumentGridForField();
        baseStep = new BaseStep(driver, atlas);
    }

    //TODO create generic
    EditorPage onPage() {
        return onPage(EditorPage.class);
    }

    PdfFillerSite onSite() {
        return atlas.create(driver, PdfFillerSite.class);
    }

    private <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }
}
