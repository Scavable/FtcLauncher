package window;

import Install.InstallWindow;
import Install.ftc.Download;
import instance.Instance;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import window.components.Buttons;
import window.components.InstanceList;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public final class WindowLayout {
    static Map<String, Double> screenProperties;
    InstanceList instanceList;

    WindowLayout(InstanceList instanceList, Map<String, Double> screenProperties){
        this.instanceList = instanceList;
        WindowLayout.screenProperties = screenProperties;
    }

    public GridPane layout(){
        GridPane gridPane = new GridPane();
        VBox vbox = VBoxLayout();

        WebView webView = WebViewLayout();
        gridPane.add(vbox, 0, 0);
        gridPane.add(webView, 1, 0);
        return gridPane;
    }

    private WebView WebViewLayout() {
        WebView webView = new WebView();
        webView.getEngine().load(String.valueOf(getClass().getClassLoader().getResource("./index.html")));
        webView.setPrefSize(screenProperties.get("width"), screenProperties.get("height"));
        return webView;
    }

    private VBox VBoxLayout() {
        VBox vbox = new VBox();

        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        Buttons buttons = new Buttons(screenProperties, instanceList);

        vbox.getChildren().addAll(instanceList.instanceListView(screenProperties), buttons.getBrowseButton(), buttons.getInstallButton());

        return vbox;
    }

}
