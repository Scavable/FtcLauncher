package util;

import javafx.stage.Stage;

import java.util.Properties;

public class DefaultWindow {
    public Stage getStage(){
        Stage stage = new Stage();
        Properties screenProperties = FTCEnum.screenProperties;

        stage.setX((double)screenProperties.get(FTCEnum.ScreenInfo.X.getScreenString())/2);
        stage.setY((double)screenProperties.get(FTCEnum.ScreenInfo.Y.getScreenString())/2);
        stage.setWidth((double)screenProperties.get(FTCEnum.ScreenInfo.WIDTH.getScreenString())/2);
        stage.setHeight((double)screenProperties.get(FTCEnum.ScreenInfo.HEIGHT.getScreenString())/2);

        return stage;
    }
}
