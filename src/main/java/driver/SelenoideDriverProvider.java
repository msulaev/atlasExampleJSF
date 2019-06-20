package driver;

import configuration.ProjectProperties;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class SelenoideDriverProvider {

    public WebDriver createDriver() {
        ProjectProperties cfg = ConfigFactory.create(ProjectProperties.class);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("Name", "testtest");
        caps.setBrowserName("chrome");
        caps.setVersion("73.0");
        caps.setCapability("enableVNC", true);
        caps.setCapability("enableVideo", false);
        try {
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create(cfg.url()).toURL(),
                    caps);
            driver.manage().window().setSize(new Dimension(1980, 1024));
            driver.setFileDetector(new LocalFileDetector());
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
