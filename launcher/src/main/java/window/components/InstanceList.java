package window.components;

import Install.ftc.Pack;
import instance.Instance;
import javafx.scene.control.ListView;

import java.util.List;
import java.util.Map;

public final class InstanceList {

    private final ListView<Instance> instancesListView = new ListView<>();

    public InstanceList(List<Pack> packages) {
        for (Pack pack : packages) {
            instancesListView.getItems().add(new Instance(pack.getName(), pack.getTitle(), pack.getVersion(), "", pack.getLocation()));
        }
    }

    public ListView<Instance> instanceListView(Map<String, Double> screenProperties) {
        instancesListView.setPrefSize(screenProperties.get("width")/2, screenProperties.get("height"));

        return instancesListView;
    }

    public ListView<Instance> getInstancesListView() {
        return instancesListView;
    }
}
