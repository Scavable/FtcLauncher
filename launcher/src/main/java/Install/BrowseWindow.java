package Install;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.FTCEnum;
import util.DefaultWindow;
import window.LauncherWindow;

public class BrowseWindow {
    public BrowseWindow() {

        Stage stage = new DefaultWindow().getStage();
        BorderPane root = new BorderPane();
        VBox vbox = new VBox();
        TextField searchBox = new TextField();

        vbox.getChildren().add(0, providers());
        vbox.getChildren().add(1, searchBox);

        root.setTop(vbox);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(LauncherWindow.getProperties().getProperty(FTCEnum.LauncherInfo.BROWSETITLE.getLauncherString()));
        stage.show();
    }

    private HBox providers(){
        HBox box = new HBox();
        box.setSpacing(10);
        box.getChildren().add(providersButtonBar());
        box.setAlignment(Pos.CENTER);
        return box;
    }

    private ButtonBar providersButtonBar(){
        ButtonBar buttonBar = new ButtonBar();
        buttonBar.getButtons().addAll(providerButton("FTC"), providerButton("CurseForge"), providerButton("Modrinth"));

        buttonBar.autosize();
        return buttonBar;
    }

    private Button providerButton(String name){
        Button button = new Button();
        button.setText(name);
        return button;
    }
}
