package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:${env}.properties"})
public interface Environments extends Config {

    @Key("App.Url")
    String getAppURL();

    @Key("App.User")
    String getAppUser();

    @Key("App.Pass")
    String getAppPassword();

    @Key("DB.Host")
    String getDBHost();

    @Key("DB.User")
    String getDBUser();

    @Key("DB.Pass")
    String getDBPassword();
}
