import util.FTCEnum;
import window.LauncherWindow;

import java.io.File;

public final class Launcher {
    public static void main(String[] args) {

        FTCEnum.loadProperties();

        LauncherWindow.setProperties(FTCEnum.launcherProperties);

        String workingDir = System.getProperty("user.dir");
        File file = new File(workingDir.concat("/Instances"));
        if(!file.exists()){
            file.mkdir();
        }

        LauncherWindow.launch(LauncherWindow.class, args);
    }
}
