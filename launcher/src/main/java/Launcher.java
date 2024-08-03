import util.FTCEnum;
import window.LauncherWindow;

import java.io.File;

public final class Launcher {
    public static void main(String[] args) {

        FTCEnum.loadProperties();

        LauncherWindow.launch(LauncherWindow.class, args);
    }
}
