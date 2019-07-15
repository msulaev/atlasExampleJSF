package step;

import com.pdffiller.page.Top100FormPage;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import org.openqa.selenium.WebDriver;

public class Top100FormStep extends BaseStep{

    public Top100FormStep(WebDriver driver, Atlas atlas) {
        this.driver = driver;
        this.atlas = atlas;
    }

    private Top100FormPage onTop100FormPage() {
        return onPage(Top100FormPage.class);
    }

    public Top100FormStep openW9FormFromTop100() {
        onTop100FormPage().formFromTop100("w9 2018-2019").click();
        onTop100FormPage().fillFormOnlineBtn("w9 2018-2019").click();
        return this;
    }


    public AtlasWebElement helpModal() {
        return onTop100FormPage().modalAlert();
    }
}
