package window.components;

import instance.Instance;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class InstancePopupMenu {

    public InstancePopupMenu(double x, double y, ListView<Instance> instancesListView, Instance selectedItem) {
        Stage stage = new Stage();
        System.out.println(instancesListView.getParent().getLayoutX());
        StageProperties(x, y, stage, selectedItem);
        Scene(stage, selectedItem);
        stage.setOnCloseRequest(windowEvent -> {
            instancesListView.setDisable(false);
        });
        stage.show();
    }

    private Stage StageProperties(double x, double y, Stage stage, Instance selectedItem){
        stage.setTitle(selectedItem.getTitle());
        stage.setX(x);
        stage.setY(y);
        return stage;
    }

    private Stage Scene(Stage stage, Instance selectedItem){
        Scene scene = new Scene(Vbox(selectedItem));
        stage.setScene(scene);
        return stage;
    }

    private VBox Vbox(Instance selectedItem){
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(Items(selectedItem));
        return vbox;
    }

    private List<Button> Items(Instance selectedItem){
        List<Button> list = new ArrayList<>();

        Button install = new Button("Install");
        Button overview = new Button("Overview");
        Button play = new Button("Play");
        Button mods = new Button("Mods");
        Button settings = new Button("Settings");

        if(!selectedItem.isInstalled())
            list.add(install);
        else
            list.add(play);

        list.add(overview);
        list.add(mods);
        list.add(settings);

        return  list;
    }
}
