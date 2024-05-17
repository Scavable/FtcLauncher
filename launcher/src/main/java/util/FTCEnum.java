package util;

import java.io.IOException;
import java.util.Properties;

public class FTCEnum {
    public static Properties properties = new Properties();
    public static void loadProperties(){
        try {
            properties.load(FTCEnum.class.getClassLoader().getResourceAsStream("launcher.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public enum Info {
        MAINTITLE, INSTALLTITLE, CURSEBASEAPI, CURESEAPIKEY, NEWSURL, PACKAGELISTURL, SELFUPDATEURL, PACKAGEURL;

        public String getString(){
            switch(this){
                case MAINTITLE:
                    return "MainTitle";

                case INSTALLTITLE:
                    return "InstallTitle";

                case CURSEBASEAPI:
                    return "cursebaseapi";

                case CURESEAPIKEY:
                    return "cureseapikey";

                case NEWSURL:
                    return "newsUrl";

                case PACKAGELISTURL:
                    return "packageListUrl";

                case PACKAGEURL:
                    return "packageUrl";

                case SELFUPDATEURL:
                    return "selfUpdateUrl";
            }
            return null;
        }
    }


}
