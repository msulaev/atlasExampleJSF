package configuration;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:testconfig.properties")

public interface ProjectProperties extends Config {
        @DefaultValue("http://192.168.1.121:4444/wd/hub/")
        @Key("selenoid.url")
        String url();

        @DefaultValue("http://http://192.168.1.211:3000/?isOfflineMode&dontWaitForPdf")
        @Key("base.url")
        String baseUrl();

        @DefaultValue("http://dev3.pdffiller.com/en/login.htm")
        @Key("login.url")
        String loginUrl();

    }
