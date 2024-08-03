package Install.ftc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import instance.Instance;
import util.FTCEnum;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Download {

    public Download(Instance instance) throws IOException, URISyntaxException {

        instanceFolderCheck();

        if(!instance.isInstalled()){
            File file = new File(System.getProperty("user.dir").concat("/Instances/")+instance.getName());

            if(!file.exists()){
                file.mkdir();
            }

            URL url = new URL(FTCEnum.launcherProperties.getProperty(FTCEnum.LauncherInfo.PACKAGEURL.getLauncherString()).concat(instance.getDownloadLocation()));
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.connect();

            if(httpsURLConnection.getResponseCode() == 200){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }

                bufferedReader.close();
                httpsURLConnection.disconnect();
                JsonNode node = new ObjectMapper().readTree(stringBuilder.toString());

                List<DownloadFile> downloads = new ObjectMapper().readValue(new ObjectMapper().readTree(stringBuilder.toString()).get("tasks").toPrettyString(), new TypeReference<>() {
                });
                for(DownloadFile df : downloads){
                    System.out.println(df);
                }
                //System.out.println(node);
                instance.setInstalled(true);
        }

        }
    }

    private void instanceFolderCheck() {
        File folder = new File(System.getProperty("user.dir").concat("/Instances/"));
        if(!folder.exists()){
            boolean status = folder.mkdir();
            System.out.println(status);
            System.out.println(folder.getAbsolutePath());
        }
    }
}
