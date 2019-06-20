package configuration;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:testconfig.properties")

public interface ProjectProperties extends Config {
        @DefaultValue("http://localhost:4444/wd/hub")
        @Key("selenoid.url")
        String url();

        @DefaultValue("http://localhost:3000")
        @Key("base.url")
        String baseUrl();

    }
