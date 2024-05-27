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
        MAINTITLE, BROWSETITLE, CURSEBASEAPI, CURESEAPIKEY, NEWSURL, PACKAGELISTURL, SELFUPDATEURL, PACKAGEURL;

        public String getString(){
            return switch (this) {
                case MAINTITLE -> "MainTitle";
                case BROWSETITLE -> "BrowseTitle";
                case CURSEBASEAPI -> "cursebaseapi";
                case CURESEAPIKEY -> "cureseapikey";
                case NEWSURL -> "newsUrl";
                case PACKAGELISTURL -> "packageListUrl";
                case PACKAGEURL -> "packageUrl";
                case SELFUPDATEURL -> "selfUpdateUrl";
            };
        }
    }


}
