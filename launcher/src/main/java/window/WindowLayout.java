package window;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import util.FTCEnum;
import window.components.Buttons;
import window.components.InstanceList;

import java.util.Map;
import java.util.Properties;

public final class WindowLayout {
    InstanceList instanceList;

    WindowLayout(InstanceList instanceList){
        this.instanceList = instanceList;
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
        webView.setPrefSize((double)FTCEnum.screenProperties.get(FTCEnum.ScreenInfo.WIDTH.getScreenString())/1.5,
                (double)FTCEnum.screenProperties.get(FTCEnum.ScreenInfo.HEIGHT.getScreenString()));
        return webView;
    }

    private VBox VBoxLayout() {
        VBox vbox = new VBox();

        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        Buttons buttons = new Buttons(instanceList);

        vbox.getChildren().addAll(instanceList.instanceListView(), buttons.getBrowseButton(), buttons.getInstallButton());

        return vbox;
    }

}
