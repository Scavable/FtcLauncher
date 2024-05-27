package Install;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.FTCEnum;
import util.DefaultWindow;
import window.LauncherWindow;

public class InstallWindow {
    public InstallWindow() {

        Stage stage = new DefaultWindow().getStage();
        TextField searchBox = new TextField();

        Scene scene = new Scene(searchBox);
        stage.setScene(scene);
        stage.setTitle(LauncherWindow.getProperties().getProperty(FTCEnum.Info.BROWSETITLE.getString()));
        stage.show();
    }
}
