package window.components;

import Install.ftc.Pack;
import instance.Instance;
import javafx.scene.control.ListView;
import util.FTCEnum;

import java.util.List;
import java.util.Map;

public final class InstanceList {

    private final ListView<Instance> instancesListView = new ListView<>();

    public InstanceList(List<Pack> packages) {
        for (Pack pack : packages) {
            instancesListView.getItems().add(new Instance(pack.getName(), pack.getTitle(), pack.getVersion(), "", pack.getLocation()));
        }
    }

    public ListView<Instance> instanceListView() {
        instancesListView.setPrefSize((double)FTCEnum.screenProperties.get(FTCEnum.ScreenInfo.WIDTH.getScreenString())/2,
                (double)FTCEnum.screenProperties.get(FTCEnum.ScreenInfo.HEIGHT.getScreenString())/2);

        return instancesListView;
    }

    public ListView<Instance> getInstancesListView() {
        return instancesListView;
    }
}
