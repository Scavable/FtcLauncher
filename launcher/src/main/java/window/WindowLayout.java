package window;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import util.FTCEnum;
import window.components.Buttons;
import window.components.InstanceList;

import static util.FTCEnum.screenProperties;

public final class WindowLayout {
    private final InstanceList instanceList;


    WindowLayout(InstanceList instanceList){
        this.instanceList = instanceList;
    }

    public GridPane layout(){
        GridPane gridPane = new GridPane();
        VBox vbox = VBoxLayout();
        HBox hbox = HBoxLayout();

        gridPane.add(vbox, 0, 0);
        gridPane.add(hbox, 1, 0);
        return gridPane;
    }


    private VBox VBoxLayout() {
        VBox vbox = new VBox();

        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        Buttons buttons = new Buttons(instanceList);

        vbox.getChildren().addAll(instanceList.instanceListView(), buttons.getBrowseButton(), buttons.getInstallButton());

        return vbox;
    }

    private HBox HBoxLayout() {

        HBox hbox = new HBox();

        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setStyle("-fx-border-color: black");

        hbox.setPrefSize((double) screenProperties.get(FTCEnum.ScreenInfo.WIDTH.getScreenString())/1.5,
                (double) screenProperties.get(FTCEnum.ScreenInfo.HEIGHT.getScreenString())/2);

        return hbox;
    }

}
