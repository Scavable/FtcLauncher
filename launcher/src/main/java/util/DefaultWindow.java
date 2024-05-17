package util;

import javafx.stage.Stage;
import window.LauncherWindow;

import java.util.Map;

public class DefaultWindow {
    public Stage getStage(){
        Stage stage = new Stage();
        Map<String, Double> screenProperties = LauncherWindow.screenProperties();

        stage.setX(screenProperties.get("x"));
        stage.setY(screenProperties.get("y"));
        stage.setWidth(screenProperties.get("width"));
        stage.setHeight(screenProperties.get("height"));

        return stage;
    }
}
