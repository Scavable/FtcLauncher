package Install.ftc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import util.FTCEnum;
import window.LauncherWindow;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public final class PacksURL {
    private PacksURL(){}

    public static List<Pack> getPackages() throws IOException {

        InputStream in = new URL(LauncherWindow.getProperties().getProperty(FTCEnum.LauncherInfo.PACKAGELISTURL.getLauncherString())).openStream();
        String fileLocation = PacksURL.class.getClassLoader().getResource("").toString().concat("temp.txt").substring(6);
        Path target = Paths.get(fileLocation);
        Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);

        String json = Files.readString(target);

        List<Pack> packages = new ObjectMapper().readValue(new ObjectMapper().readTree(json).get("packages").toPrettyString(), new TypeReference<>() {
        });

        for(Pack p : packages) {
            System.out.println(p.getLocation());
        }

        return packages;
    }
}
