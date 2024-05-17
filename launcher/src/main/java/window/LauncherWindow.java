package window;

import Install.ftc.PacksURL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.DefaultWindow;
import util.FTCEnum;
import window.components.InstanceList;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class LauncherWindow extends Application {

    static Properties properties;
    InstanceList instanceList;

    @Override
    public void start(Stage stage) {

        stage = new DefaultWindow().getStage();
        stage.setTitle(properties.getProperty(FTCEnum.Info.MAINTITLE.getString()));

        try {
            instanceList = new InstanceList(new PacksURL().getPackages());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        stage.setScene(createScene());
        stage.show();
        stage.setOnCloseRequest(windowEvent -> {System.exit(0);});

    }

    public Scene createScene() {

        WindowLayout windowLayout = new WindowLayout(instanceList, screenProperties());
        return new Scene(windowLayout.layout());

    }

    public static void setProperties(Properties properties1){
        properties = properties1;
    }

    public static Map<String, Double> screenProperties(){

        Map<String, Double> screenProperties = new HashMap<>();
        GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        screenProperties.put("width", graphicsDevice.getDefaultConfiguration().getBounds().getWidth() / 2.0);
        screenProperties.put("height", graphicsDevice.getDefaultConfiguration().getBounds().getHeight() / 2.0);
        screenProperties.put("x", graphicsDevice.getDefaultConfiguration().getBounds().getCenterX() / 2.0);
        screenProperties.put("y", graphicsDevice.getDefaultConfiguration().getBounds().getCenterY() / 2.0);
        return screenProperties;

    }

    public static Properties getProperties() {
        return properties;
    }
}
