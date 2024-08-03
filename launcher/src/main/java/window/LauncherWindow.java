package window;

import Install.ftc.Pack;
import Install.ftc.PacksURL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.DefaultWindow;
import util.FTCEnum;
import window.components.InstanceList;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public final class LauncherWindow extends Application {

    private static final Properties properties = FTCEnum.launcherProperties;
    private InstanceList instanceList;

    @Override
    public void start(Stage stage) {

        stage = new DefaultWindow().getStage();
        stage.setTitle(properties.getProperty(FTCEnum.LauncherInfo.MAINTITLE.getLauncherString()));

        try {
            instanceList = new InstanceList(PacksURL.getPackages());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.setScene(createScene());
        stage.show();
        stage.setOnCloseRequest(windowEvent -> {System.exit(0);});

    }

    public Scene createScene() {

        WindowLayout windowLayout = new WindowLayout(instanceList);
        return new Scene(windowLayout.layout());

    }

    public static Properties getProperties() {
        return properties;
    }
}
