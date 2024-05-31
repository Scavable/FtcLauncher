package util;

import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public class FTCEnum {
    public static Properties launcherProperties = new Properties();
    public static Properties screenProperties = new Properties();
    public static void loadProperties(){

        GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        screenProperties.put("Width", graphicsDevice.getDefaultConfiguration().getBounds().getWidth());
        screenProperties.put("Height", graphicsDevice.getDefaultConfiguration().getBounds().getHeight());
        screenProperties.put("X", graphicsDevice.getDefaultConfiguration().getBounds().getCenterX());
        screenProperties.put("Y", graphicsDevice.getDefaultConfiguration().getBounds().getCenterY());

        try {
            launcherProperties.load(FTCEnum.class.getClassLoader().getResourceAsStream("launcher.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public enum LauncherInfo {
        MAINTITLE, BROWSETITLE, CURSEBASEAPI, CURESEAPIKEY, NEWSURL, PACKAGELISTURL, SELFUPDATEURL, PACKAGEURL;

        public String getLauncherString(){
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

    public enum ScreenInfo {
        WIDTH, HEIGHT, X, Y;

        public String getScreenString(){
            return switch (this) {
                case WIDTH -> "Width";
                case HEIGHT -> "Height";
                case X -> "X";
                case Y -> "Y";
            };
        }
        }

}
