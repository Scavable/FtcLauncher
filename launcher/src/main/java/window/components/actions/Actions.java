package window.components.actions;

import Install.BrowseWindow;
import Install.ftc.Download;
import instance.Instance;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import window.components.InstanceList;

import java.io.IOException;
import java.net.URISyntaxException;

public class Actions {

    public static EventHandler<ActionEvent> installButtonAction(InstanceList instanceList) {
        return event -> {
            Instance instace = instanceList.getInstancesListView().getSelectionModel().getSelectedItem();
            if (instace != null) {
                try {
                    new Download(instace);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static EventHandler<ActionEvent> browseButtonAction() {
        return event -> {
            new BrowseWindow();
        };
    }

}
