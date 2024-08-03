package window.components;

import Install.ftc.Pack;
import instance.Instance;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.scene.control.ListView;
import util.FTCEnum;
import window.WindowLayout;

import java.util.List;
import java.util.Map;

import static util.FTCEnum.screenProperties;

public final class InstanceList {

    private final ListView<Instance> instancesListView = new ListView<>();

    public InstanceList(List<Pack> packages) {
        for (Pack pack : packages) {
            instancesListView.getItems().add(new Instance(pack.getName(), pack.getTitle(), pack.getVersion(), "", pack.getLocation()));
        }

        instancesListView.setOnMouseReleased(mouseEvent -> {
            //3 is right click
            if(mouseEvent.getButton().ordinal() == 3){

                instancesListView.setDisable(true);
                new InstancePopupMenu(0, 0, instancesListView, instancesListView.getSelectionModel().getSelectedItem());
            }
        });
    }

    public ListView<Instance> instanceListView() {
        instancesListView.setPrefSize((double) screenProperties.get(FTCEnum.ScreenInfo.WIDTH.getScreenString())/3,
                (double) screenProperties.get(FTCEnum.ScreenInfo.HEIGHT.getScreenString())/2);

        return instancesListView;
    }

    public ListView<Instance> getInstancesListView() {
        return instancesListView;
    }
}
